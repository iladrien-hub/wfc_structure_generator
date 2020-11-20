package ua.iladrien.wfcstructuregenerator.structuregen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.ListHolder;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private static final int size_Y = 3;
    private static final int size_X = 3;
    private static final int size_Z = 3;

    private ListHolder[][][] data;

    private ListHolder[][][] initializeData() {
        ListHolder[][][] result = new ListHolder[size_Y][size_X][size_Z];
        for (int y = 0; y < size_Y; y++)
            for (int x = 0; x < size_X; x++)
                for (int z = 0; z < size_Z; z++) {
                    result[y][x][z] = new ListHolder();
                    result[y][x][z].list = Tiles.getRegistered();
                }
        for (int x = 0; x < size_X; x++)
            for (int z = 0; z < size_Z; z++) {
                result[0][x][z].list.removeIf(tile -> !tile.isAllowedOnGround());
            }
        return result;
    }

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public void generate() {
        int y = 0;
        int x = 1;
        int z = 1;
        data = initializeData();
        data[y][x][z].list.removeIf(tile -> tile != Tiles.FANCY_STONE_BASE);
        collapse(x, y, z);
    }

    private void doCollapse(int x, int y, int z, ArrayList<Tile> comparable) {
        if (checkCoordinates(x, y, z) && data[y][x][z].list.size() > 1) {
            data[y][x][z].list.removeIf(tile -> !comparable.contains(tile));
            if (data[y][x][z].list.size() == 1)
                collapse(x, y, z);
        }
    }

    protected void collapse(int x, int y, int z) {
        Tile thisTile = data[y][x][z].list.get(0);
        doCollapse(x, y+1, z, thisTile.getVariants_u());
        doCollapse(x, y-1, z, thisTile.getVariants_d());
        doCollapse(x+1, y, z, thisTile.getVariants_e());
        doCollapse(x-1, y, z, thisTile.getVariants_e());
        doCollapse(x, y, z+1, thisTile.getVariants_s());
        doCollapse(x, y, z-1, thisTile.getVariants_n());
    }

    public void place(World world, BlockPos pos) {
        int center_x = size_X * Tile.WIDTH / 2;
        int center_z = size_Z * Tile.WIDTH / 2;
        for (int y = 0; y < size_Y; y++) {
            for (int x = 0; x < size_X; x++) {
                for (int z = 0; z < size_Z; z++) {
                    if (data[y][x][z].list.size() == 1)
                        data[y][x][z].list.get(0).placeAt(world, pos.add(Tile.WIDTH*x-center_x, Tile.HEIGHT*y, Tile.WIDTH*z-center_z));
                }
            }
        }
    }

//    public void generateRoofs() {
//        for (int y = 0; y < size_Y - 1; y++)
//            for (int x = 0; x < size_X; x++)
//                for (int z = 0; z < size_Z; z++) {
//                    if (building[y][x][z] != null && building[y+1][x][z] == null) {
//                        int finalY = y;
//                        int finalX = x;
//                        int finalZ = z;
//                        roofs[y+1][x][z] = new ListHolder();
//                        roofs[y+1][x][z].list = Tiles.getRoofs();
//                        roofs[y+1][x][z].list.removeIf(tile -> !building[finalY][finalX][finalZ].getVariants_u().contains(tile));
//                    }
//                }
//    }

//    protected void collapse(int x, int y, int z) {
//        if (building[y][x][z] != null) return;
//
//        ArrayList<Tile> variants = new ArrayList<>(Tiles.getRooms());
//        // Down
//        int step = y - 1;
//        if (checkCoordinates(x, step, z) && building[step][x][z] != null) {
//            variants.removeIf(tile -> !building[step][x][z].getVariants_u().contains(tile));
//        }
//
//        if (variants.size() > 0)
//            building[y][x][z] = variants.get(RANDOM.nextInt(variants.size()));
//
//        if (checkCoordinates(x, y+1, z)) collapse(x, y+1, z);
//    }

//    public void place(World world, BlockPos pos) {
//        int center_x = size_X * Tile.WIDTH / 2;
//        int center_z = size_Z * Tile.WIDTH / 2;
//        for (int y = 0; y < size_Y; y++) {
//            for (int x = 0; x < size_X; x++) {
//                for (int z = 0; z < size_Z; z++) {
//                    if (building[y][x][z] != null)
//                        building[y][x][z].placeAt(world, pos.add(Tile.WIDTH*x-center_x, Tile.HEIGHT*y, Tile.WIDTH*z-center_z));
//                }
//            }
//        }
//    }

    private boolean checkCoordinates(int x, int y, int z) {
        return x >= 0 && y >=0 && z >=0 && x < size_X && y < size_Y && z < size_Z;
    }

}
