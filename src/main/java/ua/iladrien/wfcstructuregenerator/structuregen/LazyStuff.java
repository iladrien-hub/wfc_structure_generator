package ua.iladrien.wfcstructuregenerator.structuregen;

import net.minecraft.util.math.vector.Vector3i;

public class LazyStuff {
    public static Vector3i addVectors3(Vector3i a, Vector3i b) {
        return new Vector3i(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }
}
