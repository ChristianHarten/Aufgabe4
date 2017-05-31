package de.hochschule_trier.playerservice;

import android.app.Service;
import android.util.Log;

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
            while (i < getCount()) {
                i++;
                Log.d(this.getClass().getName(), "service with thread " + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ", iteration " + i);
                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException ie) {}
            }
            if (i == getCount()) {
                service.stopSelf();
            }
        }
        catch (Exception e) {}
    }
    public synchronized void setCount(int newCount) {
        this.count = i < newCount ? newCount : 0;
    }
    public synchronized int getCount() { return this.count; }
}
