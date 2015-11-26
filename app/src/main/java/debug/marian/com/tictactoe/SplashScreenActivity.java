package debug.marian.com.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.widget.ImageView;



public class SplashScreenActivity extends AppCompatActivity {

    public final  Handler handler = new Handler();
    public ImageView img;
    public final Runnable startMain = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final int SPLASH_SCREEN_TIMEOUT = 5000;

        final int ANIMATION_START_DURATION = 1000;
        final int ANIMATION_END_DURATION = 700;
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //handler.removeCallbacks(startMain);
    }

}
