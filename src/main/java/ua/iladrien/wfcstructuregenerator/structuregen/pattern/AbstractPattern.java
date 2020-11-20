package ua.iladrien.wfcstructuregenerator.structuregen.pattern;

import net.minecraft.block.BlockState;

import java.util.Random;

public abstract class AbstractPattern {

    protected static Random RANDOM = new Random();

    public abstract BlockState get();
}
