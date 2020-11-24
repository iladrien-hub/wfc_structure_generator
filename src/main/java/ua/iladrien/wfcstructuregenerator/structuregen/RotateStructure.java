package ua.iladrien.wfcstructuregenerator.structuregen;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

public class RotateStructure {

    private static final Direction[] directions = new Direction[] {
            Direction.WEST,
            Direction.SOUTH,
            Direction.EAST,
            Direction.NORTH
    };

    private static final Direction.Axis[] axis = new Direction.Axis[] {
            Direction.Axis.X,
            Direction.Axis.Y,
    };

    private static int facingFromVal(Direction dir) {
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == dir) return i;
        }
        return -1;
    }

    private static int axisFromVal(Direction.Axis ax) {
        for (int i = 0; i < axis.length; i++) {
            if (axis[i] == ax) return i;
        }
        return -1;
    }

    public static BlockState update(BlockState initial, int angle) {
        // HORIZONTAL_FACING
        try {
            Direction facing = initial.get(HorizontalBlock.HORIZONTAL_FACING);
            int facingIn = (facingFromVal(facing) + angle) % 4;
            initial = initial.with(HorizontalBlock.HORIZONTAL_FACING, directions[facingIn]);
        } catch (Exception ignored) { }
        // AXIS
        try {
            Direction.Axis facing = initial.get(RotatedPillarBlock.AXIS);
            int facingIn = (axisFromVal(facing) + angle) % 2;
            initial = initial.with(RotatedPillarBlock.AXIS, axis[facingIn]);
        } catch (Exception ignored) { }
        // FOUR WAY BLOCK
        try {
            boolean[] dir = new boolean[4];
            dir[angle]       = initial.get(BlockStateProperties.SOUTH);
            dir[(angle+1)%4] = initial.get(BlockStateProperties.EAST);
            dir[(angle+2)%4] = initial.get(BlockStateProperties.NORTH);
            dir[(angle+3)%4] = initial.get(BlockStateProperties.WEST);
            initial = initial.with(BlockStateProperties.SOUTH, dir[0]).with(BlockStateProperties.EAST, dir[1]).with(BlockStateProperties.NORTH, dir[2]).with(BlockStateProperties.WEST, dir[3]);
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
