package org.wsgh.locationxposed;

/**
 * Created by yipeng on 2016/11/25.
 */

public class Utils {
    private static double degreePerMeter = 360 / 400000000;
    private static double radius = degreePerMeter * 500;//认为是半径500米

    public static double getRandom(double start, double end) {
        return start + (end - start) * Math.random();
    }
}
