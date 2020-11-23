package ua.iladrien.wfcstructuregenerator.structuregen.tile;

public enum TileRotation {
    ROTATION0(0), ROTATION90(1), ROTATION180(2), ROTATION270(3);

    public final int angle;

    public static TileRotation fromAngle(int angle) {
        switch (angle) {
            case 0: return ROTATION0;
            case 1: return ROTATION90;
            case 2: return ROTATION180;
            case 3: return ROTATION270;
        }
        return null;
    }

    TileRotation(int angle) {
        this.angle = angle;
    }
}
