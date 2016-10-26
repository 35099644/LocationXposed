package org.wsgh.locationxposed;

/**
 * Created by sandy on 2016/10/25.
 */

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class LocationXposedMain implements IXposedHookLoadPackage {

    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {

        if (!lpparam.packageName.equals("com.zymobile.zywork")) {
            return;
        }
        XposedBridge.log("Catch it, FUCK IT: " + lpparam.packageName);
        findAndHookMethod("org.zywx.wbpalmstar.plugin.uexpunchzymobi.EUExPunchZymobi", lpparam.classLoader, "getLocation", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called before the clock was updated by the original method
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                // this will be called after the clock was updated by the original method
                Object obj = param.thisObject;
                obj.
            }
        });
    }
}
