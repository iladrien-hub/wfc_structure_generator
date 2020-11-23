package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof;

import net.minecraft.util.math.vector.Vector3i;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.LazyStuff;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;

public abstract class BigRoof extends Tile {
    @Override
    public void registerVariants() {

    }

    @Override
    public boolean checkOutStrictConditions(Vector3i pos, Generator generator) {
        Vector3i forward = directions[rotation.angle];
        Vector3i backward = directions[(rotation.angle + 2) % 4];
        return  generator.checkCoordinates(LazyStuff.addVectors3( forward, pos)) &&
                generator.checkCoordinates(LazyStuff.addVectors3(backward, pos));
    }

    public BigRoof() {
        super();
        this.allowedOnGround = false;
    }
}
