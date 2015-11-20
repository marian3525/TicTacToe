package debug.marian.com.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final int SPLASH_SCREEN_TIMEOUT = 5000;

        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        Runnable startMain = new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(startMain, SPLASH_SCREEN_TIMEOUT);


    }

}
