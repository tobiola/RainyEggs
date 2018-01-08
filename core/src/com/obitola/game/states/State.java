package com.obitola.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by obitola on 12/24/2017.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
