package com.hikoharu.muscletrainingsw;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button startBtn;
    private Timer checker = new Timer(true);
    private boolean isStarted = false;
    private TextView timerText;
    private TimerTask timerTask;
    private Switch trainingSwitch;
    private AdView adView;
    AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_SPEECH).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = (Button) findViewById(R.id.startBtn);
        timerText = (TextView) findViewById(R.id.timerText);
        trainingSwitch = (Switch) findViewById(R.id.isTrainingSwitch);
        timerTask = new SWTimerTask(timerText, getApplicationContext(), trainingSwitch.isChecked());

        MobileAds.initialize(getApplicationContext(), getResources().getString(R.string.banner_ad_unit_id));
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    private void startTimer() {
        checker = new Timer(true);
        boolean isPlayVoice = trainingSwitch.isChecked();
        timerTask = new SWTimerTask(timerText, getApplicationContext(), isPlayVoice);
        checker.schedule(timerTask, 0, 100);

    }

    private void stopTimer() {
        if (checker != null) {
            checker.cancel();
            checker = null;
            timerTask = null;
        }
    }

    @Override
    protected void onStop() {
        stopTimer();
        super.onStop();
    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    public void onClickStart(View view) {


        if (isStarted) {
            stopTimer();
            startBtn.setText("再開");
            isStarted = false;
        } else {
            startTimer();
            startBtn.setText("停止");
            isStarted = true;
        }


    }

    private void reset() {
        stopTimer();
        timerText.setText("00:00:0");
        isStarted = false;

    }

    public void onClickReset(View view) {
        reset();
        startBtn.setText("開始");

    }

}
