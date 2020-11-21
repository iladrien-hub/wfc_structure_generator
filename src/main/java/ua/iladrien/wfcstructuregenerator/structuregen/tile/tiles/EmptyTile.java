package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles;

import net.minecraft.block.BlockState;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;

public class EmptyTile extends Tile {
    @Override
    public void registerVariants() {
        variants_u.addAll(Tiles.getRegistered());
        //
        variants_u.remove(Tiles.BIG_SPRUCE_ROOM);
        //
        variants_d.addAll(Tiles.getRegistered());
        variants_e.addAll(Tiles.getRegistered());
        variants_w.addAll(Tiles.getRegistered());
        variants_s.addAll(Tiles.getRegistered());
        variants_n.addAll(Tiles.getRegistered());
    }

    @Override
    public BlockState[][][] getStructure() {
        return new BlockState[HEIGHT][WIDTH][WIDTH];
    }
}
