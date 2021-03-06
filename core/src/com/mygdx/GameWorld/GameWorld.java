package com.mygdx.GameWorld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gameobjects.Bird;
import com.mygdx.gameobjects.ScrollHandler;
import com.mygdx.zbhelpers.AssetLoader;

/**
 * Created by HULK on 3/11/2015.
 */
public class GameWorld {
    public enum GameState {

        MENU, READY, RUNNING, GAMEOVER, HIGHSCORE

    }
    private GameState currentState;
    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;
    private int score=0;
    private float runTime = 0;
    public int midPointY;
    private GameRenderer renderer;

    public GameWorld(int midPointY) {
        currentState = GameState.MENU;
        this.midPointY = midPointY;
        bird = new Bird(33, midPointY - 5, 17, 12);
        // The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(this, midPointY + 66);
        ground = new Rectangle(0, midPointY + 66, 136, 11);

    }

    public void update(float delta){
        runTime += delta;

        switch (currentState) {
            case READY:
            case MENU:
                updateReady(delta);
                break;

            case RUNNING:
                updateRunning(delta);
                break;
            default:
                break;
        }

    }
    public void updateReady(float delta){
        bird.updateReady(runTime);
        scroller.updateReady(delta);
    }
    public void updateRunning(float delta){
        // Add a delta cap so that if our game takes too long
        // to update, we will not break our collision detection.

        if (delta > .15f) {
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
            renderer.prepareTransition(255, 255, 255, .3f);

            AssetLoader.fall.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            if (bird.isAlive()) {
                AssetLoader.dead.play();
                renderer.prepareTransition(255, 255, 255, .3f);

                bird.die();
            }

            scroller.stop();
            bird.decelerate();
            currentState = GameState.GAMEOVER;

            if (score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
        }
    }


    public void start(){
         currentState = GameState.RUNNING;
    }

    public void restart() {
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
        ready();
    }
    public void ready() {
        currentState = GameState.READY;
        renderer.prepareTransition(0, 0, 0, 1f);
    }
    public Bird getBird() {
        return bird;
    }
    public int getMidPointY() {
        return midPointY;
    }
    public ScrollHandler getScroller() {
        return scroller;
    }
    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }
    public boolean isReady(){
        return currentState == GameState.READY;
    }
    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }
    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }
    public boolean isMenu() {
        return currentState == GameState.MENU;
    }
    public void setRenderer(GameRenderer renderer) {
        this.renderer = renderer;
    }
}
