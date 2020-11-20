package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoof;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;

public abstract class SmallRoof extends Tile {
    @Override
    public void registerVariants() {

    }

    public SmallRoof() {
        super();
        allowedOnGround = false;
    }
}
