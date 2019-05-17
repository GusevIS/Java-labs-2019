package com.example.lab6;

import android.content.Context;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class DrawingView extends View {
    private Paint drawPaint, canvasPaint;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private Random random;


    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawPaint = new Paint();
        canvasPaint = new Paint(Paint.DITHER_FLAG);
        random = new Random();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
    }

    public void drawNew() {
        Path newPath = new Path();
        setupDrawing(random.nextInt(12) + 3);

        int x = random.nextInt(drawCanvas.getWidth());
        int y = random.nextInt(drawCanvas.getHeight());
        int x1 = random.nextInt(drawCanvas.getWidth());
        int y1 = random.nextInt(drawCanvas.getHeight());
        int x2 = random.nextInt(drawCanvas.getWidth());
        int y2 = random.nextInt(drawCanvas.getHeight());

        newPath.moveTo(x, y);
        newPath.lineTo(x1, y1);
        newPath.lineTo(x2, y2);
        newPath.close();

        drawCanvas.drawPath(newPath, drawPaint);
    }

    public void clearAll() {
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    private void setupDrawing(float randStrokeWidth) {
        drawPaint.setARGB(255, random.nextInt(255 - 1) + 1, random.nextInt(255 - 1) + 1,random.nextInt(255 - 1) + 1);
        drawPaint.setStrokeWidth(randStrokeWidth);
        drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }
}