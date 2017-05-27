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
        player = MediaPlayer.create(this, R.raw.groove);
        player.start();
    }
    @Override
    public void onDestroy() {
        player.stop();
    }
}