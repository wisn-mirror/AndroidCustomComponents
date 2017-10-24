package com.wisn.customview;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.wisn.components.view.BitMapUtils;
import com.wisn.utils.DensityUtils;

public class MainActivity extends Activity {

    private ImageView mImageView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
//        mImageView.add
//        mImageView.setImageBitmap(BitMapUtils.loadBitMap(getResources(),R.raw.test,100,100));

        mImageView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            @Override
            public void onDraw() {
                Log.e("addOnDrawListener",mImageView.getMeasuredHeight()+" : "+mImageView.getMeasuredWidth());
                Log.e("addOnDrawListener",mImageView.getHeight()+" : "+mImageView.getWidth());
            }
        });

        mImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                Log.e("addOnGlobalLayoutListener",mImageView.getMeasuredHeight()+" : "+mImageView.getMeasuredWidth());
                Log.e("addOnGlobalLayoutListener",mImageView.getHeight()+" : "+mImageView.getWidth());
                /*mImageView.setImageBitmap(BitMapUtils.loadBitMap(getResources(),R.raw.test,
                                                                 mImageView.getWidth(),mImageView.getHeight()));*/

            }
        });
        mImageView.setImageBitmap(BitMapUtils.loadBitMap(getResources(),
                                                         R.raw.test,
                                                         DensityUtils.getDeviceInfo(this)[0],
                                                         DensityUtils.getDeviceInfo(this)[1]));
    }
}
