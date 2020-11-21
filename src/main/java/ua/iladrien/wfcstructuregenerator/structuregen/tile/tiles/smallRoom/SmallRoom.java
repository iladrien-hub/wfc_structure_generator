package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoom;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

public abstract class SmallRoom extends Tile {
    @Override
    public void registerVariants() {
        // UP
        variants_u.add(Tiles.BIG_SPRUCE_ROOM);
        //
        variants_e.add(Tiles.EMPTY_TILE);
        variants_w.add(Tiles.EMPTY_TILE);
        variants_s.add(Tiles.EMPTY_TILE);
        variants_n.add(Tiles.EMPTY_TILE);
    }
}
