package ua.iladrien.wfcstructuregenerator.structuregen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import ua.iladrien.wfcstructuregenerator.WFCStructureGenerator;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.ListHolder;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private static final int size_Y = 3;
    private static final int size_X = 3;
    private static final int size_Z = 3;

    private final ArrayDeque<Vector3i> collapseQueue = new ArrayDeque<>();
    private ListHolder[][][] data;

    private ListHolder[][][] initializeData() {
        ListHolder[][][] result = new ListHolder[size_Y][size_X][size_Z];
        for (int y = 0; y < size_Y; y++)
            for (int x = 0; x < size_X; x++)
                for (int z = 0; z < size_Z; z++) {
                    result[y][x][z] = new ListHolder();
                    result[y][x][z].list = Tiles.getRegistered();
                    if (y == 0) {
                        result[y][x][z].list.removeIf(tile -> !tile.isAllowedOnGround());
                    } else {
                        result[y][x][z].list.removeIf(Tile::isOnGroundOnly);
                    }
//                    if (x == 0 || x == size_X-1 || z == 0 || z == size_Z-1) {
//                        result[y][x][z].list.removeIf(tile -> !tile.isAllowedOnEdge());
//                    }
                }
        return result;
    }

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static class dataItemStruct {
        int x, y, z;
        ArrayList<Tile> list;
    }

    private dataItemStruct getUnfinished() {
        ArrayList<dataItemStruct> items = new ArrayList<>();
        for (int y = 0; y < size_Y; y++)
            for (int x = 0; x < size_X; x++)
                for (int z = 0; z < size_Z; z++)
                    if (data[y][x][z].list.size() > 1) {
                        // TODO: (someonePLZ) rewrite this scrap
                        dataItemStruct item = new dataItemStruct();
                        item.x = x;
                        item.y = y;
                        item.z = z;
                        item.list = data[y][x][z].list;
                        items.add(item);
                    }
        if (items.size() > 0)
            return items.get(RANDOM.nextInt(items.size()));
        return null;
    }

    public void generate() {
        int y = 0;
        int x = 1;
        int z = 1;
        data = initializeData();
        collapseQueue.clear();
        data[y][x][z].list.removeIf(tile -> tile != Tiles.FANCY_STONE_BASE);
        enqueueNeighbours(new Vector3i(x,y,z));
        collapse();
    }

    protected void collapse() {
        while (collapseQueue.size() > 0) {
            Vector3i pos = collapseQueue.poll();
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            boolean isDeleted = data[y][x][z].list.removeIf(tile -> !isTileSuits(tile, pos));
            if (isDeleted) enqueueNeighbours(pos);
            if (data[y][x][z].list.size() == 0) generate();
        }
        dataItemStruct max = getUnfinished();
        if (max != null) {
            Tile randomTile = max.list.get(RANDOM.nextInt(max.list.size()));
            data[max.y][max.x][max.z].list.clear();
            data[max.y][max.x][max.z].list.add(randomTile);
            enqueueNeighbours(new Vector3i(max.x, max.y, max.z));
            collapse();
        }
    }

    protected void resetNeighbours(Vector3i pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        data[y][x][z].list = Tiles.getRegistered();
        if (checkCoordinates(x+1, y, z)) data[y][x+1][z].list = Tiles.getRegistered();
        if (checkCoordinates(x-1, y, z)) data[y][x-1][z].list = Tiles.getRegistered();
        if (checkCoordinates(x, y+1, z)) data[y+1][x][z].list = Tiles.getRegistered();
        if (checkCoordinates(x, y-1, z)) data[y-1][x][z].list = Tiles.getRegistered();
        if (checkCoordinates(x, y, z+1)) data[y][x][z+1].list = Tiles.getRegistered();
        if (checkCoordinates(x, y, z-1)) data[y][x][z-1].list = Tiles.getRegistered();
    }

    protected void enqueueNeighbours(Vector3i pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if (checkCoordinates(x+1, y, z)) collapseQueue.add(new Vector3i(x+1, y, z));
        if (checkCoordinates(x-1, y, z)) collapseQueue.add(new Vector3i(x-1, y, z));
        if (checkCoordinates(x, y+1, z)) collapseQueue.add(new Vector3i(x, y+1, z));
        if (checkCoordinates(x, y-1, z)) collapseQueue.add(new Vector3i(x, y-1, z));
        if (checkCoordinates(x, y, z+1)) collapseQueue.add(new Vector3i(x, y, z+1));
        if (checkCoordinates(x, y, z-1)) collapseQueue.add(new Vector3i(x, y, z-1));
    }

    protected boolean isTileSuits(Tile tile, Vector3i pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        Vector3i[] sides = {
                new Vector3i(1,0,0),
                new Vector3i(-1,0,0),
                new Vector3i(0,1,0),
                new Vector3i(0,-1,0),
                new Vector3i(0,0,1),
                new Vector3i(0,0,-1)
        };
        if (!tile.checkOutStrictConditions(pos, this)) return false;
        for (Vector3i side: sides) {
            int dx = side.getX();
            int dy = side.getY();
            int dz = side.getZ();
            if (checkCoordinates(x+dx, y+dy, z+dz)) {
                boolean result = false;
                for (Tile tile_e: data[y+dy][x+dx][z+dz].list) {
                    result = result || tile_e.getVariants(side).contains(tile);
                }
                if (!result) return false;
            }
        }
        return true;
    }

    public void place(World world, BlockPos pos) {
        int center_x = -1 + size_X * Tile.WIDTH / 2;
        int center_z = -1 + size_Z * Tile.WIDTH / 2;
        for (int y = 0; y < size_Y; y++) {
            for (int x = 0; x < size_X; x++) {
                for (int z = 0; z < size_Z; z++) {
                    if (data[y][x][z].list.size() == 1) {
                        data[y][x][z].list.get(0).placeAt(world, pos.add(Tile.WIDTH * x - center_x - x, Tile.HEIGHT * y, Tile.WIDTH * z - center_z - z), this);
                    } else
                        WFCStructureGenerator.log(Level.WARN, "At (" +
                                String.join(",", new String[]{String.valueOf(x), String.valueOf(y), String.valueOf(z)}) +
                                ") received weird list with size " + data[y][x][z].list.size());
                }
            }
        }
    }

    public boolean checkCoordinates(int x, int y, int z) {
        return x >= 0 && y >=0 && z >=0 && x < size_X && y < size_Y && z < size_Z;
    }

    public boolean checkCoordinates(Vector3i pos) {
        return checkCoordinates(pos.getX(), pos.getY(), pos.getZ());
    }
}
