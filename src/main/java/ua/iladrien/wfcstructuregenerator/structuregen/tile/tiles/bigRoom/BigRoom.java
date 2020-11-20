package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoom;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

public abstract class BigRoom extends Tile {
    @Override
    public void registerVariants() {
        // UP
        // DOWN
        variants_d.add(Tiles.FANCY_STONE_BASE);
    }
}
