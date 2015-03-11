package com.mygdx.GameWorld;

import com.mygdx.gameobjects.Bird;

/**
 * Created by HULK on 3/11/2015.
 */
public class GameWorld {
    private Bird bird;
    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
    }

    public void update(float delta){
        bird.update(delta);
    }

    public Bird getBird() {
        return bird;
    }
}
