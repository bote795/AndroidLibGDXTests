package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mydx.screens.GameScreen.SplashScreen;
import com.mygdx.zbhelpers.AssetLoader;

public class ZBGame extends Game {
    @Override
    public void create() {
        Gdx.app.log("ZBGame", "Created");
        AssetLoader.load();
        setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}

