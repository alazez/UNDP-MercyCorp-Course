package com.app.servicesexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //String name = intent.getStringExtra("name");
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        //stopSelf();

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean i = true;
                while(i){
                    Log.d("i","We HATE Android Development");
                }
            }
        }).start();


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
