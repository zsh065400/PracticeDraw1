package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        final Paint arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arcPaint.setStyle(Paint.Style.FILL);
        final Paint whitePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        whitePaint.setStyle(Paint.Style.FILL);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStrokeWidth(2);

        final int width = getWidth();
        final int height = getHeight();

        String[] mStrings = new String[]{
                "Lollipop", "Marshmallow", "Froyo", "Gingerbread", "Ice Cream Sandwich", "Jelly Bean",
                "KitKat"
        };

        /*绘制底部文字*/
        whitePaint.setTextSize(50);
        canvas.drawText("饼图", width / 2 - 100, height - 20, whitePaint);

        /*绘制饼*/
        arcPaint.setColor(Color.RED);
        final int centerX = width / 2;
        final int centerY = height / 2;
        final int startX = centerX / 5 * 3;
        final int radius = centerX - startX;

        whitePaint.setTextSize(30);
        /*突出部分*/
        canvas.drawArc(startX - 15, 100 - 15, centerX + radius - 15, 100 + radius * 2 - 15, 180, 120, true, arcPaint);
        canvas.drawLine(startX + 50, 100 + 50, startX, 90, whitePaint);
        canvas.drawLine(startX, 90, startX - 100, 90, whitePaint);
        final int width0 = getTextWidth(whitePaint, mStrings[0]);
        canvas.drawText(mStrings[0], startX - 100 - width0, 90, whitePaint);

        arcPaint.setColor(Color.YELLOW);
        canvas.drawArc(startX, 100, centerX + radius, 100 + radius * 2, -60, 60, true, arcPaint);
        canvas.drawLine(startX + 360, 100 + 80, startX + 360 + 50, 100 + 20, whitePaint);
        canvas.drawLine(startX + 360 + 50, 100 + 20, startX + 360 + 160, 100 + 20, whitePaint);
        canvas.drawText(mStrings[1], startX + 360 + 162, 100 + 20, whitePaint);

        arcPaint.setColor(Color.rgb(255, 0, 255));
        canvas.drawArc(startX, 100, centerX + radius, 100 + radius * 2, 2, 10, true, arcPaint);
        canvas.drawLine(startX + 430, 100 + 240, startX + 430 + 50, 100 + 240, whitePaint);
        canvas.drawText(mStrings[2], startX + 430 + 50, 100 + 240, whitePaint);

        arcPaint.setColor(Color.GRAY);
        canvas.drawArc(startX, 100, centerX + radius, 100 + radius * 2, 14, 8, true, arcPaint);
        canvas.drawLine(startX + 420, 100 + 290, startX + 420 + 50, 100 + 290, whitePaint);
        canvas.drawText(mStrings[3], startX + 420 + 50, 100 + 290, whitePaint);

        arcPaint.setColor(Color.GREEN);
        canvas.drawArc(startX, 100, centerX + radius, 100 + radius * 2, 24, 70, true, arcPaint);
        canvas.drawLine(startX + 330 + 50, 460, startX + 340 + 50 + 10, 480 + 30, whitePaint);
        canvas.drawLine(startX + 340 + 50 + 10, 480 + 30, startX + 340 + 50 + 60, 480 + 30, whitePaint);
        canvas.drawText(mStrings[5], startX + 340 + 50 + 60, 480 + 30, whitePaint);

        arcPaint.setColor(Color.BLUE);
        canvas.drawArc(startX, 100, centerX + radius, 100 + radius * 2, 96, 84, true, arcPaint);
        canvas.drawLine(startX + 50, 460, startX - 10, 460 + 50, whitePaint);
        canvas.drawLine(startX - 10, 460 + 50, startX - 120, 460 + 50, whitePaint);
        final int width6 = getTextWidth(whitePaint, mStrings[0]);
        canvas.drawText(mStrings[6], startX - 120 - width6, 460 + 50, whitePaint);
    }

    @NonNull
    private int getTextWidth(Paint whitePaint, String mString) {
        final Rect rect = new Rect();
        whitePaint.getTextBounds(mString, 0, mString.length(), rect);
        return rect.width() + 10;
    }
}
