package ua.iladrien.wfcstructuregenerator.structuregen;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Direction {

    WEST(0),
    SOUTH(1),
    EAST(2),
    NORTH(3);

    private static final net.minecraft.util.Direction[] D2M = {
            net.minecraft.util.Direction.WEST,
            net.minecraft.util.Direction.SOUTH,
            net.minecraft.util.Direction.EAST,
            net.minecraft.util.Direction.NORTH
    };
    private final int intVal;
    private static final List<Direction> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Direction random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    Direction(int val) {
        intVal = val;
    }

    public net.minecraft.util.Direction minecraftValue() {
        return D2M[intVal];
    }

    public static Direction fromInt(int i) {
        return VALUES.get(i);
    }

    public static Direction fromMinecraftValue(net.minecraft.util.Direction val) {
        for (int i = 0; i < 4; i++) {
            if (D2M[i] == val)
                return VALUES.get(i);
        }
        return VALUES.get(0);
    }

    public int toInt() {
        return intVal;
    }

    public Direction rotate90() {
        return VALUES.get((intVal + 1) % 4);
    }

    public Direction rotate180() {
        return VALUES.get((intVal + 2) % 4);
    }

    public Direction rotate270() {
        return VALUES.get((intVal + 3) % 4);
    }

}
