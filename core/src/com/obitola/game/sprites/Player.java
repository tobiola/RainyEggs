package com.obitola.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.obitola.game.RainyEggs;

/**
 * Created by obitola on 12/24/2017.
 */

public class Player {


    private Texture player;
    private Vector2 position;
    private Rectangle hitBox;
    private Animation playerAnimation;
    private Preferences scores = Gdx.app.getPreferences(RainyEggs.FILENAME);


    public Player(float x, float y){
        if (scores.getInteger("character") == 1)
            player = new Texture("greenanimation.png");
        else if (scores.getInteger("character") == 2)
            player = new Texture("memeanimation.png");
        else{
            player = new Texture("birdanimation.png");
        }
        position = new Vector2(x, y);
        playerAnimation = new Animation(new TextureRegion(player), 2, 0.4f);
        hitBox = new Rectangle(x, y + playerAnimation.getFrame().getRegionHeight(), playerAnimation.getFrame().getRegionWidth(), 1);
    }

    public void update(float x, float dt){
        playerAnimation.update(dt);

//        if (x - MARGIN > position.x)
//            position.x = position.x + (MAX_SPEED * dt);
//        else if (x + MARGIN < position.x)
//            position.x = position.x - (MAX_SPEED * dt);
        position.x = x - (playerAnimation.getFrame().getRegionWidth() / 2);
        hitBox.setPosition(position.x, hitBox.getY());
    }

    public Rectangle getHitBox(){
        return hitBox;
    }

    public TextureRegion getTexture(){
        return playerAnimation.getFrame();
    }

    public Vector2 getPosition(){
        return position;
    }

    public void dispose(){
        player.dispose();
    }
}
