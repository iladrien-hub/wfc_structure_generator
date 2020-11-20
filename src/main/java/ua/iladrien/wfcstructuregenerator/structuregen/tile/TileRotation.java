package ua.iladrien.wfcstructuregenerator.structuregen.tile;

public enum TileRotation {
    ROTATION0(0), ROTATION90(1), ROTATION180(2), ROTATION270(3);

    public final int angle;

    TileRotation(int angle) {
        this.angle = angle;
    }
}
