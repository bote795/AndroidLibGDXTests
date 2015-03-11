package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mydx.screens.GameScreen.GameScreen;

public class ZBGame extends Game {
    @Override
    public void create() {
        Gdx.app.log("ZBGame", "Created");
        setScreen(new GameScreen());
    }
}

