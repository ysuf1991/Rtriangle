package ru.sonic;

/**
 * Created by sonic
 */
public class Rtriangle implements IRtriangle {
    private int x[];
    private int y[];

    public Rtriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x = new int[]{x1, x2, x3};
        this.y = new int[]{y1, y2, y3};
    }

    @Override
    public int getApexX1() {
        return x[0];
    }

    @Override
    public int getApexY1() {
        return y[0];
    }

    @Override
    public int getApexX2() {
        return x[1];
    }

    @Override
    public int getApexY2() {
        return y[1];
    }

    @Override
    public int getApexX3() {
        return x[2];
    }

    @Override
    public int getApexY3() {
        return y[2];
    }

}
