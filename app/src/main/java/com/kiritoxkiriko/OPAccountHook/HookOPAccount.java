package com.kiritoxkiriko.OPAccountHook;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.Toast;

import java.net.ContentHandler;

import javax.xml.datatype.Duration;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookOPAccount implements IXposedHookLoadPackage {
    private Context context=null;
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if (lpparam.packageName.equals("com.oneplus.account")) {
            XposedBridge.log("Has hooked OPAccount!");
            try {
                final Class hookedClass= lpparam.classLoader.loadClass("com.oneplus.account.util.ServerConfigUtils");
                XposedBridge.log("Region class has found");

                //HOOK 区域函数
                XposedHelpers.findAndHookMethod(hookedClass, "getVersionRegion", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult("CN");
                        XposedBridge.log("Hooked Region has succeed");
                    }
                });


            } catch (ClassNotFoundException e) {
                XposedBridge.log("Region class hasn't found");
            }

//            try {
//                final Class hookedClass2= lpparam.classLoader.loadClass("com.oneplus.account.util.AccountUtils");
//                XposedBridge.log("Phone region class has found");
//
//                //HOOK 区域函数
//                XposedHelpers.findAndHookMethod(hookedClass2, "isIndiaVersion",android.content.Context.class, new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        param.setResult(false);
//                        XposedBridge.log("Hooked phone region has succeed");
//                    }
//                });
//
//
//            } catch (ClassNotFoundException e) {
//                XposedBridge.log("Phone region Class hasn't found");
//            }
        }
    }
}
