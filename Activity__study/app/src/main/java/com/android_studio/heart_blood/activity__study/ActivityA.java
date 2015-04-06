package com.android_studio.heart_blood.activity__study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ActivityA extends Activity {
    private String ClassName = "Study ActivityA ";
    //private Button startB = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        System.out.println(ClassName + "onCreate");
        /*startB = (Button)findViewById(R.id.start_B);
        startB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToB = new Intent(ActivityA.this, ActivityB.class);
                startActivity(inToB);
            }
        });*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(ClassName + "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(ClassName + "onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(ClassName + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(ClassName + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(ClassName + "onPause");
    }

    public void startActivityB(View v) {
        Intent inToB = new Intent(ActivityA.this, ActivityB.class);
        startActivity(inToB);
    }
}
