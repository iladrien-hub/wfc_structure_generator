package ua.iladrien.wfcstructuregenerator.structuregen.randomblock;

import net.minecraft.block.BlockState;

import java.util.Random;

public abstract class AbstractRandomBlock {

    protected static Random RANDOM = new Random();

    public abstract BlockState get();
}
