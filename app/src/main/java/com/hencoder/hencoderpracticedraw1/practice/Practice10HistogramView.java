package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int width = getWidth();
        final int height = getHeight();
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        /*先画横纵坐标轴*/
        final int stopY = height - 150;
        final int stopX = width - 50;
        canvas.drawLine(100, 50, 100, stopY, paint);
        canvas.drawLine(100, stopY, stopX, stopY, paint);

        /*绘制方条和文字*/
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        final String[] labels = {"Hoyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
        for (int i = 0; i < 7; i++) {
            paint.setColor(Color.GREEN);
            RectF rectF = new RectF();
            int left = 130 + i * 130;
            int top = (int) (Math.random() * (stopY - 200));
            int right = left + 100;
            int bottom = stopY - 1;
            rectF.set(left, top, right, bottom);
            canvas.drawRect(rectF, paint);

            paint.setColor(Color.WHITE);
            canvas.drawText(labels[i], left + 20, stopY + 31, paint);
        }

        /*绘制底部文字*/
        paint.setTextSize(50);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("直方图", width / 2 - 100, height - 20, paint);
    }
}
