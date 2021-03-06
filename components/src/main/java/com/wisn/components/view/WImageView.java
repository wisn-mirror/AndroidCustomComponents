package com.wisn.components.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wisn on 2017/10/24.
 */

public class WImageView extends View {
    private Paint mPaint = null;
    private Rect mRect;
    private Context mContext;

    public WImageView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public WImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public WImageView(Context context,
                      @Nullable AttributeSet attrs,
                      int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void init(Context context,
                     @Nullable AttributeSet attrs,
                     int defStyleAttr) {
        this.mContext = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(110, 110, 100, mPaint);
//        canvas.drawRect(10,10,10,10,mPaint);
    }
}
