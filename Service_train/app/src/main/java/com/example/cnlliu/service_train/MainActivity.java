package com.example.cnlliu.service_train;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
    private String Class_Name = "My Activity";
    private Button start_btn = null;
    private Button bind_btn = null;
    private Button get_btn = null;
    private Button stop_btn = null;
    private MyService myservice = null;
    private boolean bindFlag = false;

    private ServiceConnection myConnect = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalBinder localBinder = (MyService.LocalBinder) service;
            myservice = localBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println(Class_Name +" onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_btn = (Button) findViewById(R.id.start_id);
        bind_btn = (Button) findViewById(R.id.bind_id);
        get_btn = (Button) findViewById(R.id.get_id);
        stop_btn = (Button) findViewById(R.id.stop_id);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        bind_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bindFlag) {
                    Intent intent = new Intent(MainActivity.this, MyService.class);
                    bindService(intent, myConnect, BIND_AUTO_CREATE);
                    bindFlag = true;
                }
            }
        });

        get_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = myservice.radomValueGet();
                Toast.makeText(MainActivity.this, "number: " + num, Toast.LENGTH_SHORT).show();
            }
        });
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (bindFlag) {
            unbindService(myConnect);
            bindFlag = false;
        }
        Intent intent = new Intent(MainActivity.this, MyService.class);
        stopService(intent);
    }
}
