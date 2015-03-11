package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
    private Texture img;
    private Sprite sprite;
	@Override
	public void create () {
		batch = new SpriteBatch();

        img = new Texture("badlogic.jpg");
        sprite= new Sprite(img);
	}

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    @Override
	public void render () {
        //0,0 is bottom left
        //white canvas
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //finish clearing

        batch.begin();
        //drawing is done here
        sprite.draw(batch);
        batch.end();
	}
}
