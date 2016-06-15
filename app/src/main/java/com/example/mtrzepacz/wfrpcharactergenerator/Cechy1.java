package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

public class Cechy1 extends AppCompatActivity {
    ScrollView sw;
    float x1, x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cechy1);
        sw = (ScrollView)findViewById(R.id.scrollView_c1);
    sw.setOnTouchListener(
            new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x1 = event.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = event.getX();
                    float deltaX = x2 - x1;
                    if (deltaX < 0) {
                        ApplyChanges();
                        startActivity(new Intent(Cechy1.this, Cechy2.class));
                    } else if (deltaX > 0) {
                        ApplyChanges();
                        finish();
                    }
                    break;
            }

            return false;
        }
    });
}

    void ApplyChanges(){

    }
}
