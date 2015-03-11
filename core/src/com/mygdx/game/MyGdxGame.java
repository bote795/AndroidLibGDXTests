package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
    private BitmapFont font;
    private int screenWidth, screenHeight;
    private String message = "Touch me!!^.^";
	@Override
	public void create () {
		batch = new SpriteBatch();
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        font = new BitmapFont();
        font.setColor(Color.GREEN);
        font.scale(4);

      Gdx.input.setInputProcessor(this);

	}

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
	public void render () {
        //0,0 is bottom left
        //white canvas
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //finish clearing

        BitmapFont.TextBounds textSize = font.getBounds(message);
        float x = screenWidth/2 - textSize.width/2;
        float y = screenHeight/2 + textSize.height/2;

        batch.begin();
        //drawing is done here
        font.draw(batch, message, x,y);

        batch.end();
	}
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        message = "Touch down @ " + screenX + ", " + screenY;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        message = "Touch up @ " + screenX + ", " + screenY;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        message = "dragging @ " + screenX + ", " + screenY;
        //with user usually gets called even when just touching
        return true;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }


    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
