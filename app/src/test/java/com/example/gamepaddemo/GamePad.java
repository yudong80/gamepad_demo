package com.example.gamepaddemo;

import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class GamePad {
    private String mGamePadId;
    private String mPackageName;
    private String mName;
    private Uri mSnapshot; //FIXME mediastore snapshot

    private Map<String, GamePadButton> mButtonMap = new HashMap<>();

    //FIXME rectf?
    public static GamePad create(@NonNull final String id, @NonNull final String pkg, @NonNull final String name) {
        GamePad pad = new GamePad();
        pad.mGamePadId = id;
        pad.mPackageName = pkg;
        pad.mName = name;
        return pad;
    }

    private GamePad() {
        //do nothing
    }

    public String getGamePadId() {
        return mGamePadId;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public void setPackageName(String packageName) {
        this.mPackageName = packageName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void addButton(GamePadButton button) {
        mButtonMap.put(button.getButtonId(), button);
    }

    public GamePadButton getButton(String id) {
        return mButtonMap.get(id);
    }
}
