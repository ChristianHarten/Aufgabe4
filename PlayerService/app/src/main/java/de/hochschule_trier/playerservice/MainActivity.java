package de.hochschule_trier.playerservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startService(View v) {
        startService(new Intent(this, PlayerService.class));
    }
    public void stopService(View v) {
        stopService(new Intent(this, PlayerService.class));
    }
    public void startServiceWithThread(View v) {
        Log.d(this.getClass().getName(), "starting service (" + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ")");
        startService(new Intent(this, StartedService.class));
    }
    public void stopServiceWithThread(View v) {
        Log.d(this.getClass().getName(), "stopping service (" + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ")");
        stopService(new Intent(this, StartedService.class));
    }
    public void startServiceWithCount(View v) {
        Log.d(this.getClass().getName(), "starting service with count (" + android.os.Process.myPid() + " - " + Thread.currentThread().getName() + ")");
        EditText editText = (EditText) findViewById(R.id.user_input);
        String input = editText.getText().toString();
        try {
            int count = Integer.parseInt(input);
            startService(new Intent(this, StartedService.class).putExtra("Count", count));
        }
        catch (NumberFormatException e) {}
    }
}
