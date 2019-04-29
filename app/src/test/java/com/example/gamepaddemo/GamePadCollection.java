package com.example.gamepaddemo;

import android.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class GamePadCollection {
    private static String GAMEPAD_ID_PREFIX = "gamepad-";
    private static String GAMEPAD_BUTTON_ID_PREFIX = "gamepad-button-";

    private Map<String, GamePad> mGamePadMap = new HashMap<>();

    private static GamePadCollection mInstance;

    public static GamePadCollection getInstance() {
        if (mInstance == null) {
            mInstance = new GamePadCollection();
        }

        return mInstance;
    }

    private GamePadCollection() {
        //do nothing
    }

    public int load() {
        //load from file
        return mGamePadMap.keySet().size();
    }

    public void save() {
        if (mGamePadMap.keySet().isEmpty()) return;

        //do save
    }

    public String createNewGamePad(String packageName, String name) {
        String id = generateGamePadId();
        GamePad pad = GamePad.create(id, packageName, name);
        mGamePadMap.put(id, pad);
        return id;
    }

    public String addButton(String padId, String buttonType) {
        GamePad pad = mGamePadMap.get(padId);
        Pair<Integer, Integer> touchXY = createDefaultTouchXY();
        Pair<Integer, Integer> locationXY = createDefaultLocationXY();

        String buttionId = generateGamePadButtonId();
        GamePadButton btn = GamePadButton.create(
                buttionId,
                buttonType,
                touchXY.first, touchXY.second,
                locationXY.first, locationXY.second
        );
        pad.addButton(btn);
        return buttionId;
    }

    public void updateButtonTouchXY(String padId, String buttonId, int x, int y) {
        GamePadButton button = getButton(padId, buttonId);
        button.setTouchXY(x, y);
    }

    //FIXME size?
    public void updateButtonLocationXY(String padId, String buttonId, int x, int y) {
        GamePadButton button = getButton(padId, buttonId);
        button.setLocationXY(x, y);
    }

    public void setGamePadName(String padId, String name) {
        GamePad pad = mGamePadMap.get(padId);
        pad.setName(name);
    }

    public void setGamePadPackage(String padId, String pkg) {
        GamePad pad = mGamePadMap.get(padId);
        pad.setPackageName(pkg);
    }

    private GamePadButton getButton(String padId, String buttonId) {
        return mGamePadMap.get(padId).getButton(buttonId);
    }

    private Pair<Integer, Integer> createDefaultTouchXY() {
        return Pair.create(100, 100);
    }

    private Pair<Integer, Integer> createDefaultLocationXY() {
        return Pair.create(100, 100);
    }

    private String generateGamePadId() {
        return generateIdCarefully(GAMEPAD_ID_PREFIX);
    }

    private String generateGamePadButtonId() {
        return generateIdCarefully(GAMEPAD_BUTTON_ID_PREFIX);
    }

    private String generateIdCarefully(String prefix) {
        String id = prefix + Long.toString(System.currentTimeMillis());
        if (ensureIdUniqueness()) return id;

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            //do nothing
        } finally {
            return prefix + Long.toString(System.currentTimeMillis());
        }
    }

    private boolean ensureIdUniqueness() {
        return true;
    }
}
