package org.wsgh.locationxposed;

/**
 * Created by sandy on 2016/10/25.
 */

import android.util.Log;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class LocationXposedMain implements IXposedHookLoadPackage {

    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {

        if (!lpparam.packageName.equals("com.zymobile.zywork")) {
            return;
        }
        XposedBridge.log("Catch it, FUCK IT: " + lpparam.packageName);
        XC_MethodHook hook = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                Log.i("zypXposed","afterHookedMethod");
                double latitude = 40.01547;
                double longitude = 116.40761;
                Object euexInstance = methodHookParam.thisObject;
                Class euexClass = euexInstance.getClass();
                Field latitudeField = euexClass.getDeclaredField("latitude");
                latitudeField.setAccessible(true);
                latitudeField.setDouble(euexInstance, latitude);
                Field longitudeField = euexClass.getDeclaredField("longitude");
                longitudeField.setAccessible(true);
                longitudeField.setDouble(euexInstance, longitude);
                XposedBridge.log("Crack punch location Successfully!!! ");
            }
        };
        XC_MethodReplacement replacement = new XC_MethodReplacement(){

            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable
            {
                double latitude = 40.01547;
                double longitude = 116.40761;
                Object euexInstance = methodHookParam.thisObject;
                Class euexClass = euexInstance.getClass();
                Field latitudeField = euexClass.getDeclaredField("latitude");
                latitudeField.setAccessible(true);
                latitudeField.setDouble(euexInstance, latitude);
                Field longitudeField = euexClass.getDeclaredField("longitude");
                longitudeField.setAccessible(true);
                longitudeField.setDouble(euexInstance, longitude);
                XposedBridge.log("Crack punch location Successfully!!! ");
                return null;
            }
        };
        findAndHookMethod("org.zywx.wbpalmstar.plugin.uexpunchzymobi.EUExPunchZymobi", lpparam.classLoader, "getLocation", hook);
    }
}
