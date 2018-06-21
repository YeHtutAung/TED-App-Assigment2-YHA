package com.assignment.ideapro.yha.delegates;

import com.assignment.ideapro.yha.data.data.vos.TalksVO;

public interface ITedTalkDelegate {
   void onTapImage(TalksVO talk);
   void onTapFavorite(TalksVO talk);
   void onTapComments(TalksVO talk);
   void onTapSendTo(TalksVO talk);
   void onTapStatistics(TalksVO talk);
}
