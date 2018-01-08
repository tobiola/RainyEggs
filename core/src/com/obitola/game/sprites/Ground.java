package com.obitola.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by obitola on 12/24/2017.
 */

public class Ground {

    private Texture ground;
    private Rectangle hitbox;

    public Ground(){
        ground = new Texture("ground.png");
        hitbox = new Rectangle(0, 0, ground.getWidth(), ground.getHeight());
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    public Texture getTexture(){
        return ground;
    }

    public void dispose(){
        ground.dispose();
    }
}
