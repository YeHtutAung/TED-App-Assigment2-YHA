package com.assignment.ideapro.yha.utils;

public class CommonUtils {

    private static CommonUtils sObjectInstance;

    public static CommonUtils getInstance() {
        if (sObjectInstance == null) {
            sObjectInstance = new CommonUtils();
        }
        return sObjectInstance;
    }

    public String getMinuteFromSec(int sec) {
        int hours = sec / 3600;
        int minutes = (sec % 3600) / 60;
        int seconds = sec % 60;
        if (hours == 0) {
            return String.format("%02d:%02d", minutes, seconds);
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
