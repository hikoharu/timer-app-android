package com.hikoharu.muscletrainingsw;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hikoharu on 2017/04/09.
 */

public class VoicePlayer {

    AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_SPEECH).build();

    SoundPool soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(2).build();

    private int voice;
    private Context context;
    private List<VoiceVo> voices;

    public VoicePlayer(Context context) {
        voice = soundPool.load(context
                , R.raw.voice1, 1);
        this.context = context;
        VoiceDao voiceDao = new VoiceDao();
        voices = voiceDao.get();
        decorateVoice(voices,context);

    }
    public void decorateVoice(List<VoiceVo> voices,Context context){
        for(VoiceVo voice:voices){
            voice.setSoundLoadNumber(soundPool.load(context,voice.getFileName(),1));
        }
    }


    public void playVoice(long count){


        for(VoiceVo vo:voices){
            if(count == vo.getPlayTiming()){
                soundPool.play(vo.getSoundLoadNumber(), 3.0f, 3.0f, 0, 0, 1.0f);
                Toast.makeText(context,vo.getToastText(),Toast.LENGTH_LONG).show();
                break;
            }
        }

    }


}
