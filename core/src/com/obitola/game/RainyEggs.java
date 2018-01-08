package com.obitola.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.obitola.game.states.GameStateManager;
import com.obitola.game.states.MenuState;

public class RainyEggs extends ApplicationAdapter {
    public static final int WIDTH = 432;
    public static final int HEIGHT = 720;
    public static final String TITLE = "Rainy Eggs";
    public static final String FILENAME = "DATA1";

    private GameStateManager gsm;
    private SpriteBatch batch;
    public static int best;
    public static int score;
    public static int lifetime;
    public static Music music;


    @Override
    public void create () {
        batch = new SpriteBatch();
        gsm = new GameStateManager();
        Preferences scores = Gdx.app.getPreferences(FILENAME);
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        if (scores.getBoolean("music")){
            music.setVolume(0f);
        }
        else{
            music.setVolume(0.1f);
        }
        music.play();
        Gdx.gl.glClearColor(0, 0.6f,0.9f, 1);
        gsm.push(new MenuState(gsm));
        best = scores.getInteger("best", 0);
        lifetime = scores.getInteger("lifetime", 0);
        score = 0;
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }

    @Override
    public void dispose () {
        super.dispose();
        music.dispose();
    }
}

