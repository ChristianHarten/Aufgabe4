package de.hochschule_trier.playerservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by eschs on 27.05.2017.
 */

public class StartedService extends Service {
    private static int instanceCounter = 0;
    private int number;
    private ServiceThread serviceThread;

    public StartedService () {
        instanceCounter++;
        number = instanceCounter;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        Log.d(this.getClass().getName(), " onCreate(): " + number + " (" + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ")");
        //serviceThread = new ServiceThread(5);
        //serviceThread.start();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {
        Log.d(this.getClass().getName(), "onStartCommand() " + number + " (" + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ")");
        int count = intent.getIntExtra("Count", -1);
        if (count >= 0) {
            if (serviceThread == null) {
                serviceThread = new ServiceThread(count);
                serviceThread.start();
            }
            else {
                serviceThread.setCount(count);
            }
        }
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        Log.d(this.getClass().getName(), "onDestroy() " + number + " (" + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ")");
        serviceThread.interrupt();
    }
}
