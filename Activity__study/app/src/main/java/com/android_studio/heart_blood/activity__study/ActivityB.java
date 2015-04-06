package com.android_studio.heart_blood.activity__study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by heart-blood on 2015/4/5.
 */
public class ActivityB extends Activity {
    private String ClassName = "Study ActivityB ";
    //private Button startA = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        System.out.println(ClassName + "onCreate");
        /*startA = (Button)findViewById(R.id.start_A);
        startA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inToB = new Intent(ActivityB.this, ActivityA.class);
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
    protected void onPause() {
        super.onPause();
        System.out.println(ClassName + "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(ClassName + "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(ClassName + "onStart");
    }
    public void startActivityA(View v) {
        Intent inToA = new Intent(ActivityB.this, ActivityA.class);
        startActivity(inToA);
    }
}
