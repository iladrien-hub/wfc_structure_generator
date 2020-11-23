package ua.iladrien.wfcstructuregenerator.structuregen.tile;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.RotateStructure;

import java.util.ArrayList;

public abstract class Tile {

    public static final int WIDTH = 7;
    public static final int HEIGHT = 4;

    public abstract void registerVariants();
    public abstract BlockState[][][] getStructure();

    protected boolean allowedOnGround = true;
    protected boolean onGroundOnly = false;
    protected boolean allowedOnEdge = false;

    protected TileRotation rotation = TileRotation.ROTATION0;

    // Variants
    private final ArrayList<Tile> variants_u = new ArrayList<>();
    private final ArrayList<Tile> variants_d = new ArrayList<>();
    private final ArrayList<Tile> variants_s = new ArrayList<>();
    private final ArrayList<Tile> variants_n = new ArrayList<>();
    private final ArrayList<Tile> variants_e = new ArrayList<>();
    private final ArrayList<Tile> variants_w = new ArrayList<>();

    protected Vector3i[] directions = {
            new Vector3i(0,0,1),
            new Vector3i(1,0,0),
            new Vector3i(0,0,-1),
            new Vector3i(-1,0,0),
    };

    public void placeAt(World world, BlockPos pos, Generator generator) {
        BlockState[][][] data  = getStructure();
        switch (rotation) {
            case ROTATION0:
                break;
            case ROTATION90:
                data = RotateStructure.rotate90(data);
                break;
            case ROTATION180:
                data = RotateStructure.rotate180(data);
                break;
            case ROTATION270:
                data = RotateStructure.rotate270(data);
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

    protected void addVariant_u(Tile variant) {
        if (!variants_u.contains(variant))
            variants_u.add(variant);
        if (!variant.variants_d.contains(this))
            variant.variants_d.add(this);
    }

    protected void addVariant_d(Tile variant) {
        if (!variants_d.contains(variant))
            variants_d.add(variant);
        if (!variant.variants_u.contains(this))
            variant.variants_u.add(this);
    }

    protected void addVariant_e(Tile variant) {
        if (!variants_e.contains(variant))
            variants_e.add(variant);
        if (!variant.variants_w.contains(this))
            variant.variants_w.add(this);
    }

    protected void addVariant_w(Tile variant) {
        if (!variants_w.contains(variant))
            variants_w.add(variant);
        if (!variant.variants_e.contains(this))
            variant.variants_e.add(this);
    }

    protected void addVariant_s(Tile variant) {
        if (!variants_s.contains(variant))
            variants_s.add(variant);
        if (!variant.variants_n.contains(this))
            variant.variants_n.add(this);
    }

    protected void addVariant_n(Tile variant) {
        if (!variants_n.contains(variant))
            variants_n.add(variant);
        if (!variant.variants_s.contains(this))
            variant.variants_s.add(this);
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

    public boolean isOnGroundOnly() {
        return onGroundOnly;
    }

    public boolean isAllowedOnEdge() {
        return allowedOnEdge;
    }

    public ArrayList<Tile> getVariants(Vector3i side) {
        if (side.getX() == 1)
            return getVariants_w();
        else if (side.getX() == -1)
            return getVariants_e();
        else if (side.getY() == 1)
            return getVariants_d();
        else if (side.getY() == -1)
            return getVariants_u();
        else if (side.getZ() == 1)
            return getVariants_n();
        else if (side.getZ() == -1)
            return getVariants_s();
        else return null;
    }

    public boolean checkOutStrictConditions(Vector3i pos, Generator generator) { return true; }

}
