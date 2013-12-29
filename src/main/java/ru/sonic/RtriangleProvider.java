package ru.sonic;

/**
 * Created by sonic
 */
public final class RtriangleProvider {
    private static IRtriangle rtriangle;

    public static void setRtriangle(IRtriangle triangle) {
        rtriangle = triangle;
    }

    public static IRtriangle getRtriangle() {
        return rtriangle;
    }
}
