package com.wisn.components.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by wisn on 2017/10/24.
 */

public class BitMapUtils {
    public static Bitmap loadBitMap(Resources resources, int resid, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resid, options);
        options.inSampleSize =
                calculateInSampleSize(options, width, height);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resid, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int outHeight = options.outHeight;
        int outWidth = options.outWidth;
        int isSampleSize = 1;
        if (outHeight > reqHeight || outWidth > reqWidth) {
            if (outWidth > outHeight) {
                isSampleSize = Math.round((float) outHeight / (float) reqHeight);
            } else {
                isSampleSize = Math.round((float) outWidth / (float) reqWidth);
            }
        }
        Log.e("BitMapUtils"," "+isSampleSize);
        return isSampleSize;
    }
}
