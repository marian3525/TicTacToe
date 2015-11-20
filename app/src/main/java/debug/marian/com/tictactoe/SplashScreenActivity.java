package debug.marian.com.tictactoe;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.Display;
import android.view.View;

import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;


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

        ImageView img = (ImageView) findViewById(R.id.imageView);
        this.img=img;
        this.img.setImageResource(R.drawable.splash_screen);

        //setContentView(img);
    }
    @Override
    protected void onResume() {
        super.onResume();

       /* AnimationSet set = new AnimationSet(true);

        Animation fadeIn = FadeIn(1000);
        fadeIn.setStartOffset(0);
        set.addAnimation(fadeIn);

        Animation fadeOut = FadeOut(1000);
        fadeOut.setStartOffset(2000);
        set.addAnimation(fadeOut);

        img.startAnimation(set);*/
    }

    private Animation FadeIn(int t)
    {
        Animation fade;
        fade = new AlphaAnimation(0.0f,1.0f);
        fade.setDuration(t);
        return fade;
    }
    private Animation FadeOut(int t)
    {
        Animation fade;
        fade = new AlphaAnimation(1.0f,0.0f);
        fade.setDuration(t);
        return fade;
    }
    @Override
    public void onPause() {
        super.onPause();
        //handler.removeCallbacks(startMain);
    }

}
