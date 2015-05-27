package io.seniorzhai.generallibrary;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by zhaitao on 15/5/27.
 */
public class BitmapUtils {
    /**
     * 转换图片成圆形
     *
     * @param bitmap 传入Bitmap对象
     * @return
     */
    static public Bitmap toRoundBitmap(Bitmap bitmap) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float roundPx;
            float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
            if (width <= height) {
                roundPx = width / 2;
                top = 0;
                bottom = width;
                left = 0;
                right = width;
                height = width;
                dst_left = 0;
                dst_top = 0;
                dst_right = width;
                dst_bottom = width;
            } else {
                roundPx = height / 2;
                float clip = (width - height) / 2;
                left = clip;
                right = width - clip;
                top = 0;
                bottom = height;
                width = height;
                dst_left = 0;
                dst_top = 0;
                dst_right = height;
                dst_bottom = height;
            }

            Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(output);

            final int color = 0xff424242;
            final Paint paint = new Paint();
            final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
            final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
            final RectF rectF = new RectF(dst);

            paint.setAntiAlias(true);

            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, src, dst, paint);
            return output;
        } finally {
            bitmap.recycle();
        }
    }

    public static final int COMPRESS_MAX_X = 600;
    public static final int COMPRESS_MAX_Y = 600;

    /**
     * 缩放Bitmap大小
     *
     * @param bitmap
     * @return
     */
    public static Bitmap zoomImageScale(Bitmap bitmap) {
        return zoomImageScale(bitmap, COMPRESS_MAX_X, COMPRESS_MAX_Y);
    }

    public static Bitmap zoomImageScale(Bitmap bitmap, int newWidth, int newHeight) {
        if (bitmap.getWidth() > newWidth
                || bitmap.getHeight() > newHeight) {
            final int temp1 = bitmap.getWidth() / newWidth;
            final int temp2 = bitmap.getHeight() / newHeight;
            int scale = temp1 > temp2 ? temp1 : temp2;
            return zoomImage(bitmap, bitmap.getWidth() / scale, bitmap.getHeight() / scale);
        }
        return bitmap;
    }

    /**
     * 缩放Bitmap大小
     *
     * @param bitMap
     * @param newWidth
     * @param newHeight
     * @return
     */
    public static Bitmap zoomImage(Bitmap bitMap, int newWidth, int newHeight) {
        // File file = new File("");
        // Bitmap b = B
        if (bitMap == null) {
            return null;
        }
        // 获取这个图片的宽和高
        int width = bitMap.getWidth();
        int height = bitMap.getHeight();
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 计算缩放率，新尺寸除原始尺寸
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 新尺寸大于原始尺寸则不缩放
        if (scaleWidth > 1.0f || scaleHeight > 1.0f) {
            return bitMap;
        }
        // 缩放图片动作
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bitMap, 0, 0, width, height, matrix, true);
        bitMap.recycle();
        return bitmap;
    }
}
