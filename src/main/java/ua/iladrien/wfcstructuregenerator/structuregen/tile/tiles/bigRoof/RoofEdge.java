package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

public abstract class RoofEdge extends Tile {

    public RoofEdge() {
        super();
        allowedOnEdge = true;
        allowedOnGround = false;
    }

    @Override
    public void registerVariants() {
        addVariant_u(Tiles.EMPTY_TILE);
        addVariant_d(Tiles.EMPTY_TILE);
        switch (rotation) {
            case ROTATION0:
                addVariant_w(Tiles.EMPTY_TILE);
                addVariant_w(this);
                addVariant_e(Tiles.EMPTY_TILE);
                addVariant_n(Tiles.EMPTY_TILE);
                break;
            case ROTATION90:
                addVariant_w(Tiles.EMPTY_TILE);
                addVariant_s(Tiles.EMPTY_TILE);
                addVariant_s(this);
                addVariant_n(Tiles.EMPTY_TILE);
                break;
            case ROTATION180:
                addVariant_w(Tiles.EMPTY_TILE);
                addVariant_w(this);
                addVariant_e(Tiles.EMPTY_TILE);
                addVariant_s(Tiles.EMPTY_TILE);
                break;
            case ROTATION270:
                addVariant_e(Tiles.EMPTY_TILE);
                addVariant_s(Tiles.EMPTY_TILE);
                addVariant_s(this);
                addVariant_n(Tiles.EMPTY_TILE);
                break;
        }
    }
}
