package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.Toast;

public class PodstawoweInfo extends AppCompatActivity {
    private float x1, x2;
    ScrollView sw;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karta);
        sw = (ScrollView)findViewById(R.id.pi_scrollview);
         sw.setOnTouchListener(
                 new View.OnTouchListener() {
                     @Override
                     public boolean onTouch(View v, MotionEvent event) {
                         // TODO Auto-generated method stub
                         switch (event.getAction()) {
                             case MotionEvent.ACTION_DOWN:
                                 x1 = event.getX();
                                 break;
                             case MotionEvent.ACTION_UP:
                                 x2 = event.getX();
                                 float deltaX = x2 - x1;
                                 if (deltaX < 0) {
                                     Toast.makeText(PodstawoweInfo.this,
                                             "Right to Left swipe",
                                             Toast.LENGTH_SHORT).show();
                                 }else if(deltaX >0){
                                     Toast.makeText(PodstawoweInfo.this,
                                             "Left to Right swipe",
                                             Toast.LENGTH_SHORT).show();
                                 }
                                 break;
                         }

                         return false;
                     }
                 });
    }

}
