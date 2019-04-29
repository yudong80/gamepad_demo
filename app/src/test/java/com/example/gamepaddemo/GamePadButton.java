package com.example.gamepaddemo;

import android.support.annotation.NonNull;

public class GamePadButton {
    private String mButtonId;
    private String mButtonType;
    private int mTouchX;
    private int mTouchY;
    private int mLocationX;
    private int mLocationY;

    public static GamePadButton create(@NonNull final String id,
                                       @NonNull final String type,
                                       @NonNull final int touchX,
                                       @NonNull final int touchY,
                                       @NonNull final int locX,
                                       @NonNull final int locY) {
        GamePadButton button = new GamePadButton();
        button.mButtonId = id;
        button.mButtonType = type;
        button.mTouchX = touchX;
        button.mTouchY = touchY;
        button.mLocationX = locX;
        button.mLocationY = locY;
        return button;
    }

    public String getButtonId() {
        return mButtonId;
    }

    public void setButtonId(String buttonId) {
        this.mButtonId = buttonId;
    }

    public String getButtonType() {
        return mButtonType;
    }

    public void setButtonType(String type) {
        this.mButtonType = type;
    }

    public int getTouchX() {
        return mTouchX;
    }

    public int getTouchY() {
        return mTouchY;
    }

    public void setTouchXY(int touchX, int touchY) {
        mTouchX = touchX;
        mTouchY = touchY;
    }

    public int getLocationX() {
        return mLocationX;
    }

    public int getLocationY() {
        return mLocationY;
    }

    public void setLocationXY(int locationX, int locationY) {
        mLocationX = locationX;
        mLocationY = locationY;
    }
}
