package de.hochschule_trier.playerservice;

import android.app.Service;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by eschs on 27.05.2017.
 */

public class ServiceThread extends Thread {
    private int count, i;
    private Service service;

    public ServiceThread (int count, Service service) {
        this.count = count;
        this.i = 0;
        this.service = service;
    }
    @Override
    public void run() {
        try {
            while (i < count) {
                i++;
                Log.d(this.getClass().getName(), "service with thread " + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ", iteration " + i);
                Thread.sleep(2000);
            }
            if (i == count) {
                service.stopSelf();
            }
        }
        catch (Exception e) {

        }
    }
    public synchronized void setCount(int newCount) {
        this.count = i < newCount ? newCount : 0;
    }
    public synchronized void setI(int newI) { this.i = newI; }
    public synchronized int getI() { return this.i; }
}
