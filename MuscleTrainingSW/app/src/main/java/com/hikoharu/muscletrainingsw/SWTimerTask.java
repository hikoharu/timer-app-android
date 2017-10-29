package com.hikoharu.muscletrainingsw;

import android.content.Context;
import android.widget.TextView;

import java.util.List;
import java.util.TimerTask;

/**
 * Created by hikoharu on 2017/04/08.
 */

public class SWTimerTask extends TimerTask {

    private long count;
    private boolean isPlayVoice;
    private android.os.Handler mHandler = new android.os.Handler();
    private TextView timerText;
    private VoicePlayer voicePlayer;


    public SWTimerTask(TextView timerText, Context context, boolean isPlayVoice) {
        this.timerText = timerText;
        setCount();
        voicePlayer = new VoicePlayer(context);
        this.isPlayVoice = isPlayVoice;
    }

    private void setCount() {
        String currentTime = timerText.getText().toString();
        String[] currentTimeArray = currentTime.split(":");
        long mm = Long.valueOf(currentTimeArray[0]);
        long ss = Long.valueOf(currentTimeArray[1]);
        long ms = Long.valueOf(currentTimeArray[2]);

        count = mm * 1000 * 60 / 100;
        count = count + ss * 1000 / 100;
        count = count + ms;
    }

    @Override
    public void run() {
        mHandler.post(new Runnable() {
            public void run() {

                count++;
                long mm = count * 100 / 1000 / 60;
                long ss = count * 100 / 1000 % 60;
                long ms = (count * 100 - ss * 1000 - mm * 1000 * 60) / 100;
                timerText.setText(String.format("%1$02d:%2$02d:%3$01d", mm, ss, ms));

                if (isPlayVoice) {
                    voicePlayer.playVoice(count);
                }
            }
        });
    }


}
