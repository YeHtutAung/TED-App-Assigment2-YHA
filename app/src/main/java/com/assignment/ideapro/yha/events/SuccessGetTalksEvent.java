package com.assignment.ideapro.yha.events;

import com.assignment.ideapro.yha.data.data.vos.TalksVO;
import java.util.ArrayList;
import java.util.List;

public class SuccessGetTalksEvent {
    List<TalksVO> talksList = null;

    public SuccessGetTalksEvent(List<TalksVO> talksList) {
        this.talksList = talksList;
    }

    public List<TalksVO> getTalksList() {
        if (talksList == null) {
            talksList = new ArrayList<>();
        }
        return talksList;
    }
}
