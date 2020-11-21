package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles;

import net.minecraft.block.BlockState;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;

public class EmptyTile extends Tile {
    @Override
    public void registerVariants() {

    }

    @Override
    public BlockState[][][] getStructure() {
        return new BlockState[HEIGHT][WIDTH][WIDTH];
    }
}
