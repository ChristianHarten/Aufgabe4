package de.hochschule_trier.playerservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by eschs on 27.05.2017.
 */

public class PlayerService extends Service {
    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
        Toast.makeText(this, "YO", Toast.LENGTH_SHORT).show();
        player = MediaPlayer.create(this, R.raw.groove);
        player.start();
        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy() {
        player.stop();
    }
}
