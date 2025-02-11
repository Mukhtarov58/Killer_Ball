package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;


public class SplashScreen implements Screen {
    private Texture splashTexture;
    private SpriteBatch batch;
    private long startTime;
    @Override
    public void show() {
        splashTexture = new Texture("splash.gif");
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(splashTexture,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.end();
        if (Gdx.input.justTouched() || TimeUtils.timeSinceNanos(startTime) > 2_000_000_000L){
            ((Game) Gdx.app.getApplicationListener()).setScreen((Screen) new MainMenuScreen());
        }

    }

    @Override
    public void resize(int width, int height) {
        
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        splashTexture.dispose();
        batch.dispose();
    }
}
