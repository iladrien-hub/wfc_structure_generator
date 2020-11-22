package ua.iladrien.wfcstructuregenerator.structuregen;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.util.Direction;

public class RotateStructure {

    private static final Direction[] directions = new Direction[] {
            Direction.WEST,
            Direction.SOUTH,
            Direction.EAST,
            Direction.NORTH
    };

    private static int fromVal(Direction dir) {
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == dir) return i;
        }
        return -1;
    }

    public static BlockState update(BlockState initial, int angle) {
        // HORIZONTAL_FACING
        try {
            Direction facing = initial.get(HorizontalBlock.HORIZONTAL_FACING);
            int facingIn = (fromVal(facing) + angle) % 4;
            initial = initial.with(HorizontalBlock.HORIZONTAL_FACING, directions[facingIn]);
        } catch (Exception ignored) { }
        return initial;
    }

    public static BlockState[][][] rotate90(BlockState[][][] initial) {
        int size_y = initial.length;
        int size_x = initial[0].length;
        int size_z = initial[0][0].length;
        BlockState[][][] result = new BlockState[size_y][size_z][size_x];
        for (int y = 0; y < size_y; y++) {
            for (int x = 0; x < size_x; x++) {
                for (int z = 0; z < size_z; z++) {
                    if (initial[y][x][z] != null)
                        result[y][z][size_x-x-1] = update(initial[y][x][z], 1);
                }
            }
        }
        return result;
    }

    public static BlockState[][][] rotate180(BlockState[][][] initial) {
        int size_y = initial.length;
        int size_x = initial[0].length;
        int size_z = initial[0][0].length;
        BlockState[][][] result = new BlockState[size_y][size_x][size_z];
        for (int y = 0; y < size_y; y++) {
            for (int x = 0; x < size_x; x++) {
                for (int z = 0; z < size_z; z++) {
                    if (initial[y][x][z] != null)
                        result[y][size_x-x-1][size_z-z-1] = update(initial[y][x][z], 2);
                }
            }
        }
        return result;
    }

    public static BlockState[][][] rotate270(BlockState[][][] initial) {
        int size_y = initial.length;
        int size_x = initial[0].length;
        int size_z = initial[0][0].length;
        BlockState[][][] result = new BlockState[size_y][size_z][size_x];
        for (int y = 0; y < size_y; y++) {
            for (int x = 0; x < size_x; x++) {
                for (int z = 0; z < size_z; z++) {
                    if (initial[y][x][z] != null)
                        result[y][size_z-z-1][x] = update(initial[y][x][z], 3);
                }
            }
        }
        return result;
    }
}
