package com.example.lab6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class second_activity extends AppCompatActivity {
    private DrawingView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_lab_activities);

        drawView = findViewById(R.id.drawing);
    }

    public void Click(View view) {
        Intent intent1 = new Intent(second_activity.this, MainActivity.class);
        startActivity(intent1);
    }

    public void Click_Draw(View view) {
        drawView.drawNew();
    }

    public void Click_Clear(View view) {
        drawView.clearAll();
    }
}