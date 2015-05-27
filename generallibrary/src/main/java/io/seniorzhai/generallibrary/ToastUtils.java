package io.seniorzhai.generallibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhaitao on 15/5/27.
 */
public class ToastUtils {
    public static void show(Context context,String str){
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
    public static void show_long(Context context,String str){
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
