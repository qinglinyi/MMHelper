package com.zncm.dminter.mmhelper.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminter on 2016/11/28.
 */

public class ApkInfoUtils {
    public static void debug(Object object) {
        try {
            Log.d("xxx", String.valueOf(object));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static List getActivitiesByPackageName(Context context, String packageName) {
        ArrayList activities = new ArrayList();
        try {
            Context packageContext = context.createPackageContext(packageName, 0);
            AssetManager localAssetManager = packageContext.getAssets();
            XmlResourceParser xrp = localAssetManager.openXmlResourceParser(((Integer) AssetManager.class.getMethod("addAssetPath", new Class[]{String.class}).invoke(localAssetManager, new Object[]{packageContext.getPackageManager().getApplicationInfo(packageName, 0).sourceDir})).intValue(), "AndroidManifest.xml");
            while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
                if (xrp.getEventType() == XmlResourceParser.START_TAG) {
                    String tagName = xrp.getName();
                    if (tagName.endsWith("activity")) {
                        String className = xrp.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (className.startsWith(".")) {
                            className = packageName + className;
                        }
                        activities.add(className);
                    }
                } else if (xrp.getEventType() == XmlResourceParser.END_TAG) {
                } else if (xrp.getEventType() == XmlResourceParser.TEXT) {
                }
                xrp.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activities;

    }
}
