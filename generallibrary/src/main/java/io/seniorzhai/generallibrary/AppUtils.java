package io.seniorzhai.generallibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by zhaitao on 15/5/27.
 */
public class AppUtils {
    private AppUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    // 获取应用程序名称
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 当前应用的版本名称
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取系统信息
     *
     * @return
     */
    public static String getSystemInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------- 系统信息 -----------------");
        sb.append("\nBOARD        :" + android.os.Build.BOARD);
        sb.append("\nDEVICE       :" + android.os.Build.DEVICE);
        sb.append("\nMANUFACTURER :" + android.os.Build.MANUFACTURER);
        sb.append("\nPRODUCT      :" + android.os.Build.PRODUCT);
        sb.append("\nCODENAME     :" + android.os.Build.VERSION.CODENAME);
        sb.append("\nRELEASE      :" + android.os.Build.VERSION.RELEASE);
        sb.append("\nSDK          :" + android.os.Build.VERSION.SDK);
        return sb.toString();
    }
}
