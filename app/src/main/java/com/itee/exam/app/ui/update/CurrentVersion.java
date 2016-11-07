package com.itee.exam.app.ui.update;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.itee.exam.R;

/**
 * Created by pkwsh on 2016-04-05.
 */
public class CurrentVersion {
    private static final String TAG = "Config";
    public static final String appPackName = "com.itee.exam";

    public static int getVerCode(Context context) throws PackageManager.NameNotFoundException {
        int verCode = -1;
        try {
            verCode = context.getPackageManager()
                    .getPackageInfo(appPackName, 0).versionCode;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return verCode;
    }

    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager()
                    .getPackageInfo(appPackName, 0).versionName;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return verName;
    }

    public static String getAppName(Context context) {
        String appName = context.getResources().getText(R.string.app_name)
                .toString();
        return appName;
    }
}
