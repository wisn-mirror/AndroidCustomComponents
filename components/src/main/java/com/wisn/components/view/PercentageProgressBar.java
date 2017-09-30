package com.wisn.components.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by wisn on 2017/9/27.
 */

public class PercentageProgressBar extends View {
    public static final String TAG = "PercentageProgressBar";
    private Paint mPaint = null;
    private Rect mRect;
    private int mWidthSize;
    private int mHeightSize;
    private String Text="AAA";
    public void init(Context context,
                     @Nullable AttributeSet attrs) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(120);
        mRect = new Rect();
        mPaint.getTextBounds(Text, 0, Text.length(), mRect);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        mWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        mHeightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.d(TAG,
              "widthSize- " +
              mWidthSize +
              " heightSize- " +
              mHeightSize +
              "  getPaddingLeft()" +
              getPaddingLeft() +
              " getPaddingBottom" +
              getPaddingBottom());
        if (widthMode == MeasureSpec.EXACTLY) {
            //绝对大小
            Log.d(TAG, "widthMode->MeasureSpec.EXACTLY");
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //给你最大
            mWidthSize = mRect.width() + getPaddingLeft() + getPaddingRight();
            Log.d(TAG, "widthMode->MeasureSpec.AT_MOST");
        } else if (widthMode == MeasureSpec.UNSPECIFIED) {
            Log.d(TAG, "widthMode->MeasureSpec.UNSPECIFIED");
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            Log.d(TAG, "heightMode->MeasureSpec.EXACTLY");
        } else if (heightMode == MeasureSpec.AT_MOST) {
            mHeightSize = mRect.height() + getPaddingTop() + getPaddingBottom();
            Log.d(TAG, "heightMode->MeasureSpec.AT_MOST");
        } else if (heightMode == MeasureSpec.UNSPECIFIED) {
            Log.d(TAG, "heightMode->MeasureSpec.UNSPECIFIED");
        }
        setMeasuredDimension(mWidthSize, mHeightSize);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(0, 0, mWidthSize, mHeightSize, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawText(Text, getPaddingLeft(), mRect.height()+getPaddingTop(), mPaint);
    }

    public PercentageProgressBar(Context context) {
        super(context);
    }

    public PercentageProgressBar(Context context,
                                 @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PercentageProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


}
