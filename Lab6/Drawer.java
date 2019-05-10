package com.example.lab6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;

public class Drawer extends View {
    public Paint drawPaint;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private Random random = new Random();

    public Drawer(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        drawPaint = new Paint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawCanvas.drawBitmap(canvasBitmap, 0, 0, drawPaint);

        int x = random.nextInt(getRootView().getMeasuredWidth());
        int y = random.nextInt(getRootView().getMeasuredHeight());
        int x1 = random.nextInt(getRootView().getMeasuredWidth());
        int y1 = random.nextInt(getRootView().getMeasuredHeight());
        int x2 = random.nextInt(getRootView().getMeasuredWidth());
        int y2 = random.nextInt(getRootView().getMeasuredHeight());
        drawPaint.setColor(Color.RED);
        drawCanvas.drawLine(x, y, x1, y1, drawPaint);
        drawCanvas.drawLine(x1, y1, x2, y2, drawPaint);
        drawCanvas.drawLine(x2, y2, x, y, drawPaint);


    }

    protected void drawTriangle()
    {
        int x = random.nextInt(getRootView().getMeasuredWidth());
        int y = random.nextInt(getRootView().getMeasuredHeight());
        int x1 = random.nextInt(getRootView().getMeasuredWidth());
        int y1 = random.nextInt(getRootView().getMeasuredHeight());
        int x2 = random.nextInt(getRootView().getMeasuredWidth());
        int y2 = random.nextInt(getRootView().getMeasuredHeight());
        drawPaint.setColor(Color.RED);
        drawCanvas.drawLine(x, y, x1, y1, drawPaint);
        drawCanvas.drawLine(x1, y1, x2, y2, drawPaint);
        drawCanvas.drawLine(x2, y2, x, y, drawPaint);

    }

    public void clearAll() {
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }


}

