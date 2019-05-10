package com.example.lab6;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonF;
    private Button buttonClean;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        buttonF = findViewById(R.id.start_btn);
        buttonF.setOnClickListener(new ClickListener(this, drawer));
        buttonClean = findViewById(R.id.delete_btn);
        buttonClean.setOnClickListener(new ClickListener(this, drawer));
    }

    final class ClickListener implements View.OnClickListener {
        private Context cont;
        private Drawer drawer;

        public ClickListener(Context cont, Drawer drawer) {
            this.cont = cont;
            this.drawer = drawer;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.start_btn:
                    drawer.drawTriangle();
                case R.id.delete_btn:
                    drawer.clearAll();
                //Drawer triangle = new Drawer(cont);
                //addContentView(triangle, new AbsListView.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
            }
        }
    }
}


