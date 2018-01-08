package com.obitola.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.obitola.game.RainyEggs;

import java.util.Random;


/**
 * Created by obitola on 12/24/2017.
 */

public class Egg {
    public static final int GAP = 75;
    public static final int EGG_COUNT = Math.round(RainyEggs.HEIGHT / (GAP * 4 / 3));
    private static final int START_SPEED = 300;
    private static final int SPEED_INCREASE_MARGIN = 1;
    private static final int INCREMENT_SPEED = 30;
    private static final int MAX_SPEED = 3000;
    private static final int MARGIN = 30;

    private Texture egg;
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle hitBox;
    private Random rand;
    private int speed;

    public Egg(float y){
        egg = new Texture("egg.png");
        rand = new Random();
        position = new Vector2(rand.nextInt(RainyEggs.WIDTH - (2 * MARGIN)) + MARGIN - (egg.getWidth() / 2), y);
        velocity = new Vector2(0, START_SPEED);
        hitBox = new Rectangle(position.x,position.y,egg.getWidth(),egg.getHeight());
        speed = START_SPEED;
    }

    public void update(float dt){
        position.add(0, -1 * speed * dt);
        if (position.y < 0){
            this.reposition();
        }

        hitBox.setPosition(position.x, position.y);

    }

    public void reposition(){
        position.x = rand.nextInt(RainyEggs.WIDTH - (2 * MARGIN)) + MARGIN - (egg.getWidth() / 2);
        if (speed >= MAX_SPEED)
            position.y = position.y + (EGG_COUNT * GAP * speed) / START_SPEED;
        else{
            speed = speed + INCREMENT_SPEED;
            Double yeet = 0.0;//SPEED_INCREASE_MARGIN * speed * 0.3;
            position.y = position.y + (EGG_COUNT * GAP * (speed) / (START_SPEED)) + yeet.intValue();

        }

    }

    public Texture getTexture(){
        return egg;
    }

    public Vector2 getPosition(){
        return position;
    }

    public boolean isTouching(Rectangle object){
        return object.overlaps(hitBox);
    }

    public void dispose(){
        egg.dispose();
    }

}
