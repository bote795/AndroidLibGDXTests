package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private Animation animation;
    private float elapsedTime = 0;
	@Override
	public void create () {
		batch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("data/spritesheet.atlas"));
        animation = new Animation(1/15f, textureAtlas.getRegions());
	}

    @Override
    public void dispose() {
        batch.dispose();
        textureAtlas.dispose();
    }

    @Override
	public void render () {
        //0,0 is bottom left
        //white canvas
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //finish clearing

        batch.begin();
        //drawing is done here
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
        batch.end();
	}
}
