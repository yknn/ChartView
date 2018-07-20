package com.chartview.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Date: 2018/3/19  14:35
 * Description:
 */
public class DensityUtil {
    private static final String TAG = "DensityUtil";

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取手机的分辨率px，返回一个数组，为宽度和长度。
     */
    public static int[] getDevicePx(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int heigth = metrics.heightPixels;
        return new int[]{width, heigth};
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }


    public static int getDefaultSize(int size, int measureSpec) {
        //设置默认大小
        int result = size;
        //获取宽/高测量规格的模式 & 测量大小
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            // 模式为UNSPECIFIED时，使用提供的默认大小
            // 即第一个参数：size
            case View.MeasureSpec.UNSPECIFIED:
                result = size;
                Log.d("asd", "测量模式:View.MeasureSpec.UNSPECIFIED ");
                break;
            case View.MeasureSpec.AT_MOST:
                result = size;
                Log.d("asd", "测量模式:View.MeasureSpec.AT_MOST ");
                break;
            // EXACTLY时，使用View测量后的宽/高值
            // 即measureSpec中的specSize
            case View.MeasureSpec.EXACTLY:
                result = specSize == 0 ? 2 : specSize;
                Log.d("asd", "测量模式:View.MeasureSpec.EXACTLY ");
                break;
        }
        //返回View的宽/高值
        return result;
    }
}