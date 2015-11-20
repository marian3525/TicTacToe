package debug.marian.com.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    boolean soundEnabled;
    boolean vibrateEnabled;
    final String VIBRATE_SETTING_KEY = "isVibrateAllowed";
    final String SOUND_SETTING_KEY = "isSoundAllowed";
    Log l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        SharedPreferences prefs = getSharedPreferences("debug.marian.com.tictactoe", Context.MODE_PRIVATE);

        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        final MediaPlayer buttonSound = MediaPlayer.create(getApplicationContext(), R.raw.button_click);
        final MediaPlayer backgroundMusic = MediaPlayer.create(getApplicationContext(), R.raw.background_music);
        backgroundMusic.setLooping(true);

        final AsyncSoundPlayer backgroundPlayer = new AsyncSoundPlayer(getApplicationContext(), backgroundMusic); //not playing!

        updatePrefs(prefs, true, true);

        getAudioPrefs(prefs);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something important with the fab
                if(soundEnabled == true) {
                    buttonSound.start();
                }
                if(vibrateEnabled == true) {
                    vibrator.vibrate(25);
                }
            }
        });

        if(soundEnabled == true) {
            //backgroundPlayer.execute();
            l.e("tag", "started async");
            backgroundMusic.start();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //start the settings activity on setting button click
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void updatePrefs(SharedPreferences prefs, boolean vibrate, boolean sound) {
        SharedPreferences.Editor editor = prefs.edit();

        editor.putBoolean(VIBRATE_SETTING_KEY, vibrate);
        editor.putBoolean(SOUND_SETTING_KEY, sound);

        editor.apply();

    }

    void setAudioPrefs(SharedPreferences prefs) {
        SharedPreferences.Editor editor = prefs.edit();

        editor.putBoolean(VIBRATE_SETTING_KEY, vibrateEnabled);
        editor.putBoolean(SOUND_SETTING_KEY, soundEnabled);

        editor.apply();
    }

    void getAudioPrefs(SharedPreferences prefs) {
        //configure the saved audio prefs, should be called at the beginning of onCreate
        if(prefs.getBoolean(VIBRATE_SETTING_KEY, false) == true) {  //return -1 if the key does not exist
            vibrateEnabled = true;
        }
        else
            vibrateEnabled = false;
        if(prefs.getBoolean(SOUND_SETTING_KEY, false) == true) {
            soundEnabled = true;
        }
    }
}
