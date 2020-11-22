package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof;

import net.minecraft.util.math.vector.Vector3i;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;

public abstract class RoofEdge extends Tile {

    public RoofEdge() {
        super();
        allowedOnEdge = true;
        allowedOnGround = false;
    }

    private final Vector3i[] directions = new Vector3i[] {
            new Vector3i(0,0,1),
            new Vector3i(1,0,0),
            new Vector3i(0,0,-1),
            new Vector3i(-1,0,0),
    };

    @Override
    public boolean checkOutStrictConditions(Vector3i pos, Generator generator) {
        Vector3i forward = directions[rotation.angle];
        return generator.checkCoordinates(
                pos.getX() + forward.getX(),
                pos.getY() + forward.getY(),
                pos.getZ() + forward.getZ()
        );
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
