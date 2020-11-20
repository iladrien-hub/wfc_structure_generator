package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;

public abstract class BigRoof extends Tile {
    @Override
    public void registerVariants() {

    }

    public BigRoof() {
        super();
        this.allowedOnGround = false;
    }
}
