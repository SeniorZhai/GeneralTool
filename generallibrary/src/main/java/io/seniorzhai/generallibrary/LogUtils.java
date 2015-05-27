package io.seniorzhai.generallibrary;

/**
 * Created by zhaitao on 15/5/27.
 */
public class LogUtils {
    public static boolean isDebug = true;
    private static String defagltTag = "Debug";

    public static void setTag(String tag) {
        defagltTag = tag;
    }

    public static int i(Object o) {
        return isDebug && o != null ? android.util.Log.i(defagltTag,
                o.toString()) : -1;
    }

    public static int i(String m) {
        return isDebug && m != null ? android.util.Log.i(defagltTag, m) : -1;
    }

    public static int d(Object o) {
        return isDebug && o != null ? android.util.Log.d(defagltTag,
                o.toString()) : -1;
    }

    public static int d(String m) {
        return isDebug && m != null ? android.util.Log.d(defagltTag, m) : -1;
    }

    public static int v(Object o) {
        return isDebug && o != null ? android.util.Log.v(defagltTag,
                o.toString()) : -1;
    }

    public static int v(String m) {
        return isDebug && m != null ? android.util.Log.v(defagltTag, m) : -1;
    }

    public static int w(Object o) {
        return isDebug && o != null ? android.util.Log.w(defagltTag,
                o.toString()) : -1;
    }

    public static int w(String m) {
        return isDebug && m != null ? android.util.Log.w(defagltTag, m) : -1;
    }

    public static int e(Object o) {
        return isDebug && o != null ? android.util.Log.e(defagltTag,
                o.toString()) : -1;
    }

    public static int e(String m) {
        return isDebug && m != null ? android.util.Log.e(defagltTag, m) : -1;
    }

    public static int v(String tag, String msg) {
        return isDebug && msg != null ? android.util.Log.v(tag, msg) : -1;
    }

    public static int d(String tag, String msg) {
        return isDebug && msg != null ? android.util.Log.d(tag, msg) : -1;
    }

    public static int i(String tag, String msg) {
        return isDebug && msg != null ? android.util.Log.i(tag, msg) : -1;
    }

    public static int w(String tag, String msg) {
        return isDebug && msg != null ? android.util.Log.w(tag, msg) : -1;
    }

    public static int e(String tag, String msg) {
        return isDebug && msg != null ? android.util.Log.e(tag, msg) : -1;
    }

    public static int v(String tag, Object... msg) {
        return isDebug ? android.util.Log.v(tag, getLogMessage(msg)) : -1;
    }

    public static int d(String tag, Object... msg) {
        return isDebug ? android.util.Log.d(tag, getLogMessage(msg)) : -1;
    }

    public static int i(String tag, Object... msg) {
        return isDebug ? android.util.Log.i(tag, getLogMessage(msg)) : -1;
    }

    public static int w(String tag, Object... msg) {
        return isDebug ? android.util.Log.w(tag, getLogMessage(msg)) : -1;
    }

    public static int e(String tag, Object... msg) {
        return isDebug ? android.util.Log.e(tag, getLogMessage(msg)) : -1;
    }

    private static String getLogMessage(Object... msg) {
        if (msg != null && msg.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (Object s : msg) {
                if (msg != null && s != null)
                    sb.append(s.toString());
            }
            return sb.toString();
        }
        return "";
    }

    public static int v(String tag, String msg, Throwable tr) {
        return isDebug && msg != null ? android.util.Log.v(tag, msg, tr) : -1;
    }

    public static int d(String tag, String msg, Throwable tr) {
        return isDebug && msg != null ? android.util.Log.d(tag, msg, tr) : -1;
    }

    public static int i(String tag, String msg, Throwable tr) {
        return isDebug && msg != null ? android.util.Log.i(tag, msg, tr) : -1;
    }

    public static int w(String tag, String msg, Throwable tr) {
        return isDebug && msg != null ? android.util.Log.w(tag, msg, tr) : -1;
    }

    public static int e(String tag, String msg, Throwable tr) {
        return isDebug && msg != null ? android.util.Log.e(tag, msg, tr) : -1;
    }

    public static int v(Object tag, String msg) {
        return isDebug ? android.util.Log
                .v(tag.getClass().getSimpleName(), msg) : -1;
    }

    public static int d(Object tag, String msg) {
        return isDebug ? android.util.Log
                .d(tag.getClass().getSimpleName(), msg) : -1;
    }

    public static int i(Object tag, String msg) {
        return isDebug ? android.util.Log
                .i(tag.getClass().getSimpleName(), msg) : -1;
    }

    public static int w(Object tag, String msg) {
        return isDebug ? android.util.Log
                .w(tag.getClass().getSimpleName(), msg) : -1;
    }

    public static int e(Object tag, String msg) {
        return isDebug ? android.util.Log
                .e(tag.getClass().getSimpleName(), msg) : -1;
    }
}
