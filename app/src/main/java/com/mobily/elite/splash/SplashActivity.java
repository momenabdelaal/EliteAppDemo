package com.mobily.elite.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.mobily.elite.R;
import com.mobily.elite.appUtils.Constants;
import com.mobily.elite.appUtils.Localization.LocaleHelper;
import com.mobily.elite.appUtils.Localization.LocalizationUtils;
import com.mobily.elite.appUtils.MovementHelper;


public class SplashActivity extends AppCompatActivity {

    Handler handler ;
    Runnable runnable ;
    CoordinatorLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        //changeLanguage(  SplashActivity.this);
        LocaleHelper.setLocale(this, LocaleHelper.getLanguage(this));


        container = findViewById(R.id.container);
        setDisplayedTime();
    }

   /* private  void changeLanguage(Context context){
        UserPreferenceHelper.setLanguage("ar");
         MessagesManager.changeLanguage(context, UserPreferenceHelper.getCurrentLanguage());
    }*/


    public void setDisplayedTime(){
        Animation animFadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
//        container.setVisibility(View.VISIBLE);
        animFadeIn.setDuration(2000);
        container.startAnimation(animFadeIn);

        Animation.AnimationListener listener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                MovementHelper.startMainActivity( SplashActivity.this,
                        Constants.HOME_PAGE);

                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };


        animFadeIn.setAnimationListener(listener);
    }




    @Override
    protected void onStart() {
        super.onStart();
        LocalizationUtils.setDefaultFontConfiguration(SplashActivity.this);
    }

    @Override
    protected void onStop() {
//        handler.removeCallbacks(runnable);
        super.onStop();
    }



    @Override
    protected void onDestroy() {
//        handler.removeCallbacks(runnable);
        super.onDestroy();
    }



}
