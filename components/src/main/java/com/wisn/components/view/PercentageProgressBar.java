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
 * Created by wisn on 2017/9/27.
 */

public class PercentageProgressBar extends View {
    private Paint mPaint=null;
    private Rect mRect;

    public void init(Context context,
                     @Nullable AttributeSet attrs){
        mPaint=new Paint();
        mPaint.setTextSize(120);
        mRect = new Rect();
        mPaint.getTextBounds("HELLO",0,"HELLO".length(),mRect);
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
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawText("AAAAA",(getWidth()-mRect.width())/2,(getHeight()+mRect.height())/2,mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawText("AAAAA",getWidth()/2,getHeight()/2,mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("AAAAA",200,200,mPaint);
    }

    public PercentageProgressBar(Context context) {
        super(context);
    }

    public PercentageProgressBar(Context context,
                                 @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public PercentageProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }


}
