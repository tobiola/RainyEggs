package com.obitola.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by obitola on 12/23/2017.
 */

public class Button {
    private Vector2 position;
    private Texture button;

    public Button(float x, float y, String path){

        button = new Texture(Gdx.files.internal(path));
        position = new Vector2(x - button.getWidth() / 2, y - button.getHeight() / 2);
    }

    public boolean within(float x, float y){
        return x > position.x && x < position.x + button.getWidth() && y > position.y && y < position.y + button.getHeight();
    }

    public Vector2 getPosition(){
        return position;
    }

    public Texture getTexture(){
        return button;
    }

    public void dispose(){
        button.dispose();
    }
}
