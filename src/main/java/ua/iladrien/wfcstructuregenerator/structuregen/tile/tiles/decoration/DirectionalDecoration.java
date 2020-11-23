package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration;

import net.minecraft.util.math.vector.Vector3i;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.LazyStuff;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

public abstract class DirectionalDecoration extends Decoration {

    @Override
    public boolean checkOutStrictConditions(Vector3i pos, Generator generator) {
        Vector3i left = directions[(rotation.angle + 1) % 4];
        return generator.checkCoordinates(LazyStuff.addVectors3(pos, left));
    }

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
