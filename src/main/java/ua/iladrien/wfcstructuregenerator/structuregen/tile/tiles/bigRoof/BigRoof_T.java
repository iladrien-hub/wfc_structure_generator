package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof;

import net.minecraft.util.math.vector.Vector3i;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.LazyStuff;

public abstract class BigRoof_T extends BigRoof {
    @Override
    public boolean checkOutStrictConditions(Vector3i pos, Generator generator) {
        Vector3i forward = directions[rotation.angle];
        Vector3i backward = directions[(rotation.angle + 2) % 4];
        Vector3i right = directions[(rotation.angle + 3) % 4];
        return  generator.checkCoordinates(LazyStuff.addVectors3( forward, pos)) &&
                generator.checkCoordinates(LazyStuff.addVectors3(   right, pos)) &&
                generator.checkCoordinates(LazyStuff.addVectors3(backward, pos));
    }
}
