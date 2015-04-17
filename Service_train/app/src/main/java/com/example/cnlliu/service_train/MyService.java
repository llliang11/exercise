package com.example.cnlliu.service_train;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Random;

public class MyService extends Service {
    private static String Class_Name = "My Service";
    private Random generator = null;
    private IBinder localBinder = null;
    public MyService() {
        generator = new Random();
        localBinder = new LocalBinder();
    }

    @Override
    public void onCreate() {
        System.out.println(Class_Name + " onCreate");
    }

    @Override
    public void onDestroy() {
        generator = null;
        localBinder = null;
        System.out.println(Class_Name + " onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println(Class_Name + " onStartCommand");
        String text = Class_Name + " onStartCommand and the random value is" + radomValueGet();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        System.out.println(Class_Name + " onBind");
        return localBinder;
    }

    public int radomValueGet() {
        return generator.nextInt(100);
    }

    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
}
