package com.hikoharu.muscletrainingsw;

import android.speech.tts.Voice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hikoharu on 2017/04/17.
 */

public class VoiceDao {

    public List<VoiceVo> get() {

        List<VoiceVo> list = new ArrayList<VoiceVo>();
        list.add(new VoiceVo(R.raw.voice1, 10, "今日も頑張ろう！"));
        list.add(new VoiceVo(R.raw.voice2, 100, "腰と背中はまっすぐにね"));
        list.add(new VoiceVo(R.raw.voice3, 300, "30秒、この調子だよ♪"));
        list.add(new VoiceVo(R.raw.voice4, 450, "もうちょっとで1分だよ"));
        list.add(new VoiceVo(R.raw.voice5, 560, "できる、できる、できる、できる！！"));
        return list;

    }

    ;

}
