package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoom;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

public abstract class SmallRoom extends Tile {
    @Override
    public void registerVariants() {
        addVariant_u(Tiles.BIG_SPRUCE_ROOM);
        //
        addVariant_e(Tiles.EMPTY_TILE);
        addVariant_w(Tiles.EMPTY_TILE);
        addVariant_s(Tiles.EMPTY_TILE);
        addVariant_n(Tiles.EMPTY_TILE);
    }
}
