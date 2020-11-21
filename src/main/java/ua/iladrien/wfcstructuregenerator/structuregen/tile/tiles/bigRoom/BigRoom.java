package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoom;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

public abstract class BigRoom extends Tile {
    @Override
    public void registerVariants() {
        addVariant_d(Tiles.FANCY_STONE_BASE);
        addVariant_d(Tiles.STONE_ON_GROUND_SUPPORT);
    }
}
