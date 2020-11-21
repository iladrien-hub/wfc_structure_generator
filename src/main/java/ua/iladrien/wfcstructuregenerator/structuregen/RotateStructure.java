package ua.iladrien.wfcstructuregenerator.structuregen;

import net.minecraft.block.BlockState;

public class RotateStructure {
    public static BlockState[][][] rotate90(BlockState[][][] initial) {
        int size_y = initial.length;
        int size_x = initial[0].length;
        int size_z = initial[0][0].length;
        BlockState[][][] result = new BlockState[size_y][size_z][size_x];
        for (int y = 0; y < size_y; y++) {
            for (int x = 0; x < size_x; x++) {
                for (int z = 0; z < size_z; z++) {
                    result[y][z][x] = initial[y][x][z];
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
                    result[y][size_x-x-1][size_z-z-1] = initial[y][x][z];
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
                    result[y][size_z-z-1][size_x-x-1] = initial[y][x][z];
                }
            }
        }
        return result;
    }
}
