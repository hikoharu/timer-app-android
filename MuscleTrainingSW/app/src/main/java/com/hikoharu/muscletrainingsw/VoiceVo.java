package com.hikoharu.muscletrainingsw;

import android.speech.tts.Voice;

/**
 * Created by hikoharu on 2017/04/17.
 */

public class VoiceVo {

    private int file;
    private int playTiming;
    private String toastText;
    private int soundLoadNumber;


    public VoiceVo(int file, int playTiming, String toastText) {
        this.file = file;
        this.playTiming = playTiming;
        this.toastText = toastText;
    }

    public int getFileName() {
        return file;
    }

    public void setFileName(int file) {
        this.file = file;
    }

    public int getPlayTiming() {
        return playTiming;
    }

    public void setPlayTiming(int playTiming) {
        this.playTiming = playTiming;
    }

    public String getToastText() {
        return toastText;
    }

    public void setToastText(String toastText) {
        this.toastText = toastText;
    }


    public int getSoundLoadNumber() {
        return soundLoadNumber;
    }

    public void setSoundLoadNumber(int soundLoadNumber) {
        this.soundLoadNumber = soundLoadNumber;
    }

}
