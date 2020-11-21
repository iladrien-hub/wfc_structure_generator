package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration;

import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

public abstract class DirectionalDecoration extends Decoration {
    @Override
    public void registerVariants() {
        super.registerVariants();
        switch (rotation) {
            case ROTATION0:
                addVariant_w(Tiles.EMPTY_TILE);
                addVariant_s(Tiles.EMPTY_TILE);
                addVariant_n(Tiles.EMPTY_TILE);
                break;
            case ROTATION90:
                addVariant_w(Tiles.EMPTY_TILE);
                addVariant_e(Tiles.EMPTY_TILE);
                addVariant_s(Tiles.EMPTY_TILE);
                break;
            case ROTATION180:
                addVariant_e(Tiles.EMPTY_TILE);
                addVariant_s(Tiles.EMPTY_TILE);
                addVariant_n(Tiles.EMPTY_TILE);
                break;
            case ROTATION270:
                addVariant_w(Tiles.EMPTY_TILE);
                addVariant_e(Tiles.EMPTY_TILE);
                addVariant_n(Tiles.EMPTY_TILE);
                break;
        }
    }
}
