package de.hochschule_trier.playerservice;

import android.util.Log;

/**
 * Created by eschs on 27.05.2017.
 */

public class ServiceThread extends Thread {
    private int count;

    public ServiceThread (int count) {
        this.count = count;
    }
    @Override
    public void run() {
        int i = 0;
        try {
            while (i < count) {
                i++;
                Log.d(this.getClass().getName(), "service with thread " + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ", iteration " + i);
                Thread.sleep(2000);
            }
        }
        catch (Exception e) {

        }
    }
}
