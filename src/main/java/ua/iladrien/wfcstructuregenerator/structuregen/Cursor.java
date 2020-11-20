package ua.iladrien.wfcstructuregenerator.structuregen;

public class Cursor {
    private int x, y, z;

    public Cursor go(int offset, Direction dir) {
        switch (dir) {
            case WEST:
                x -= offset;
                break;
            case EAST:
                x += offset;
                break;
            case SOUTH:
                z += offset;
                break;
            case NORTH:
                z -= offset;
                break;
        }
        return this;
    }

    public Cursor goWest(int offset) {
        x -= offset;
        return this;
    }

    public Cursor goEast(int offset) {
        x += offset;
        return this;
    }

    public Cursor goSouth(int offset) {
        z += offset;
        return this;
    }

    public Cursor goNorth(int offset) {
        z -= offset;
        return this;
    }

    public Cursor goUp(int offset) {
        y += offset;
        return this;
    }

    public Cursor goDown(int offset) {
        y -= offset;
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Cursor(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Cursor() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Cursor clone() {
        Cursor res = new Cursor();
        res.x = x;
        res.y = y;
        res.z = z;
        return res;
    }
}
