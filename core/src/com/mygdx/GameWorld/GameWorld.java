package com.mygdx.GameWorld;

import com.mygdx.gameobjects.Bird;
import com.mygdx.gameobjects.ScrollHandler;
import com.mygdx.zbhelpers.AssetLoader;

/**
 * Created by HULK on 3/11/2015.
 */
public class GameWorld {
    private Bird bird;
    private ScrollHandler scroller;
    private boolean isAlive = true;

    public GameWorld(int midPointY) {
        bird = new Bird(33, midPointY - 5, 17, 12);
        // The grass should start 66 pixels below the midPointY
        scroller = new ScrollHandler(midPointY + 66);
    }

    public void update(float delta){
        bird.update(delta);
        scroller.update(delta);

        if (isAlive && scroller.collides(bird)) {
            // Clean up on game over
            scroller.stop();
            AssetLoader.dead.play();
            isAlive=false;
        }

    }

    public Bird getBird() {
        return bird;
    }
    public ScrollHandler getScroller() {
        return scroller;
    }
}
