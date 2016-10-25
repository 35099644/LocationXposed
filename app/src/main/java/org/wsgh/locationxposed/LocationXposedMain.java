package org.wsgh.locationxposed;

/**
 * Created by sandy on 2016/10/25.
 */

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class LocationXposedMain implements IXposedHookLoadPackage {


    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("Loaded app: " + lpparam.packageName);
    }

    public void handleLoadPackage(finalLoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.android.systemui")) return;
        findAndHookMethod("com.android.systemui.statusbar.policy.Clock", lpparam.classLoader, "updateClock", newXC_MethodHook());
        {
            @Override
            protected void beforeHookedMethod (MethodHookParam param)throws Throwable {
            // this will be called beforethe clock was updated by the original method
        }
            @Override
            protected void AfterHookedMethod (MethodHookParam param)throws Throwable {
            // this will be called afterthe clock was updated by the original method
        }
        });
    }
}
