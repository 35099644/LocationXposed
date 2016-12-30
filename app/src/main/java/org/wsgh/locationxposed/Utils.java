package org.wsgh.locationxposed;

import android.content.Context;
import android.content.SharedPreferences;

import de.robv.android.xposed.XSharedPreferences;

/**
 * Created by yipeng on 2016/11/25.
 */

public class Utils {
    private static double degreePerMeter = 360 / 400000000;
    private static double radius = degreePerMeter * 500;//认为是半径500米

    public static double getRandom(double start, double end) {
        return start + (end - start) * Math.random();
    }

    public static XSharedPreferences getDefaultSharedPreferences(String packageName) {
        return new XSharedPreferences(packageName,
                getDefaultSharedPreferencesName(packageName));
    }

    private static String getDefaultSharedPreferencesName(String packageName) {
        return packageName + "_preferences";
    }

    private static int getDefaultSharedPreferencesMode() {
        return Context.MODE_PRIVATE;
    }
}
