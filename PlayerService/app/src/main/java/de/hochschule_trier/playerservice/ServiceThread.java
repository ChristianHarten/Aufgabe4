package de.hochschule_trier.playerservice;

import android.os.Process;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by eschs on 27.05.2017.
 */

public class ServiceThread extends Thread {
    private int count, i;

    public ServiceThread (int count) {
        this.count = count;
        this.i = 0;
    }
    @Override
    public void run() {
        try {
            while (i < count) {
                i++;
                Log.d(this.getClass().getName(), "service with thread " + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ", iteration " + i);
                Thread.sleep(Toast.LENGTH_LONG);
            }
        }
        catch (Exception e) {

        }
    }
    public synchronized void setCount(int newCount) {
        this.count = i < newCount ? newCount : 0;
    }
}
