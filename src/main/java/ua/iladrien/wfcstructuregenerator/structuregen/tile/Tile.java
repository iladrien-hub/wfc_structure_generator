package ua.iladrien.wfcstructuregenerator.structuregen.tile;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ua.iladrien.wfcstructuregenerator.structuregen.RotateStructure;

import java.util.ArrayList;

public abstract class Tile {

    public static final int WIDTH = 7;
    public static final int HEIGHT = 4;

    public abstract void registerVariants();
    public abstract BlockState[][][] getStructure();

    protected boolean allowedOnGround = true;

    protected TileRotation rotation = TileRotation.ROTATION0;

    // Variants
    protected ArrayList<Tile> variants_u = new ArrayList<>();
    protected ArrayList<Tile> variants_d = new ArrayList<>();
    protected ArrayList<Tile> variants_s = new ArrayList<>();
    protected ArrayList<Tile> variants_n = new ArrayList<>();
    protected ArrayList<Tile> variants_e = new ArrayList<>();
    protected ArrayList<Tile> variants_w = new ArrayList<>();

    public void placeAt(World world, BlockPos pos) {
        BlockState[][][] data  = getStructure();
        for (int i = 0; i < rotation.angle; i++) {
            data = RotateStructure.rotate(data);
        }
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                for (int z = 0; z < WIDTH; z++) {
                    if (data[y][x][z] != null) {
                        final BlockPos pos1 = pos.add(x, y, z);
                        world.setBlockState(pos1, data[y][x][z]);
                        world.notifyNeighborsOfStateChange(pos1, data[y][x][z].getBlock());
                    }
                }
            }
        }
    }

    public Tile setRotation(TileRotation rotation) {
        this.rotation = rotation;
        return this;
    }

    public ArrayList<Tile> getVariants_d() {
        return new ArrayList<>(variants_d);
    }

    public ArrayList<Tile> getVariants_u() {
        return new ArrayList<>(variants_u);
    }

    public ArrayList<Tile> getVariants_s() {
        return new ArrayList<>(variants_s);
    }

    public ArrayList<Tile> getVariants_n() {
        return new ArrayList<>(variants_n);
    }

    public ArrayList<Tile> getVariants_e() {
        return new ArrayList<>(variants_e);
    }

    public ArrayList<Tile> getVariants_w() {
        return new ArrayList<>(variants_w);
    }

    public boolean isAllowedOnGround() {
        return allowedOnGround;
    }
}
