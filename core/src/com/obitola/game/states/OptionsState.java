package com.obitola.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.obitola.game.RainyEggs;
import com.obitola.game.sprites.Button;

/**
 * Created by obitola on 12/31/2017.
 */

public class OptionsState extends State{
    private Button on;
    private Button off;
    private Button back;
    private Button bird;
    private Button green;
    private Button meme;
    private float scaleX;
    private float scaleY;
    private BitmapFont font;
    private BitmapFont font2;
    private Preferences scores = Gdx.app.getPreferences(RainyEggs.FILENAME);

    public OptionsState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, RainyEggs.WIDTH, RainyEggs.HEIGHT);
        //background = new Texture("bg.png");
        on = new Button((cam.viewportWidth * 4 / 11), (cam.viewportHeight * 11 /16),"onbutton.png");
        off = new Button((cam.viewportWidth * 7 / 11), (cam.viewportHeight * 11 / 16),"offbutton.png");
        back = new Button((cam.viewportWidth * 1 / 2), (cam.viewportHeight * 1 / 4), "backbutton.png");
        bird = new Button((cam.viewportWidth * 2 / 8), (cam.viewportHeight * 7 / 16), "bird.png");
        green = new Button((cam.viewportWidth * 4 / 8), (cam.viewportHeight * 7 / 16), "green.png");
        meme = new Button((cam.viewportWidth * 6 / 8), (cam.viewportHeight * 7 / 16), "meme.png");
        scaleX = cam.viewportWidth / Gdx.graphics.getWidth();
        scaleY = cam.viewportHeight / Gdx.graphics.getHeight();
        font = new BitmapFont(Gdx.files.internal("hehe.fnt"));
        font2 = new BitmapFont(Gdx.files.internal("hehe2.fnt"));
    }

    @Override
    protected void handleInput() {
        float x = Gdx.input.getX() * scaleX;
        float y = RainyEggs.HEIGHT - Gdx.input.getY() * scaleY;
        if (Gdx.input.justTouched()) {
            if (back.within(x, y)){
                gsm.set(new MenuState(gsm));
            }
            else if(on.within(x, y)){

                scores.putBoolean("music", false);
                RainyEggs.music.setVolume(0.1f);
            }
            else if(off.within(x, y)){
                scores.putBoolean("music", true);
                RainyEggs.music.setVolume(0.0f);
            }
            else if(bird.within(x, y)){
                scores.putInteger("character", 0);
            }
            else if(green.within(x, y)){
                scores.putInteger("character", 1);
            }
            else if(meme.within(x, y)){
                scores.putInteger("character", 2);
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        //sb.draw(background, 0, 0, FallingEggs.WIDTH, FallingEggs.HEIGHT);
        sb.draw(on.getTexture(), on.getPosition().x, on.getPosition().y);
        sb.draw(off.getTexture(), off.getPosition().x, off.getPosition().y);
        sb.draw(back.getTexture(), back.getPosition().x, back.getPosition().y);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.draw(green.getTexture(), green.getPosition().x, green.getPosition().y);
        sb.draw(meme.getTexture(), meme.getPosition().x, meme.getPosition().y);
        font2.draw(sb, "OPTIONS",RainyEggs.WIDTH / 2 , RainyEggs.HEIGHT * 15 / 16, Align.center, Align.center, true);
        //font.draw(sb, "TOTAL EGGS CAUGHT: " + RainyEggs.lifetime, RainyEggs.WIDTH / 2, RainyEggs.HEIGHT * 12 / 16, Align.center, Align.center, true);
        //font.draw(sb, "BEST: " + RainyEggs.best, RainyEggs.WIDTH / 2, RainyEggs.HEIGHT * 11 / 16, Align.center, Align.center, true);
        font.draw(sb, "SOUND", RainyEggs.WIDTH / 2, RainyEggs.HEIGHT * 13 / 16, Align.center, Align.center, true);
        font.draw(sb, "CHARACTER", RainyEggs.WIDTH / 2, RainyEggs.HEIGHT * 9 / 16, Align.center, Align.center, true);
        sb.end();

    }

    @Override
    public void dispose() {
        //background.dispose();
        on.dispose();
        off.dispose();
        back.dispose();
        bird.dispose();
        green.dispose();
        meme.dispose();
        font.dispose();
        font2.dispose();
        System.out.println("Menu State Disposed");
    }
}
