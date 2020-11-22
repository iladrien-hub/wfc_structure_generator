package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles;

import net.minecraft.block.BlockState;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;

public class EmptyTile extends Tile {

    public EmptyTile() {
        super();
        allowedOnEdge = true;
    }

    @Override
    public void registerVariants() {
        addVariant_u(this);
        addVariant_w(this);
        addVariant_s(this);
    }

    @Override
    public BlockState[][][] getStructure() {
        return new BlockState[HEIGHT][WIDTH][WIDTH];
    }
}
