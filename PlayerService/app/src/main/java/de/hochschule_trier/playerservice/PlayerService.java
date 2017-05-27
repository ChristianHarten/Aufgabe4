package de.hochschule_trier.playerservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

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
        //player = MediaPlayer.create(this, R.raw.groove);
        //player.start();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {
        player = MediaPlayer.create(this, R.raw.groove);
        if (player.isPlaying()) {
            player.stop();
        }
        player.start();
        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy() {
        player.stop();
    }
}
