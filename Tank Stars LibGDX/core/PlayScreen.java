package com.mygdx.tankstars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.tankstars.TankStars;

public class PlayScreen implements Screen {
    private final TankStars game;
    private Texture bg;
    private TextureRegion bgTexture;
    private Texture tank;
    private Texture ground;
    private OrthographicCamera cam;
    private Viewport port;

    public static final float MAX_HEIGHT = 100.0f;
    public static final float  MAX_WIDTH = 100.0f;

    public PlayScreen(TankStars game) {
        this.game=game;
        cam = new OrthographicCamera();
        port=new StretchViewport(MAX_WIDTH,MAX_HEIGHT,cam);

        bg=new Texture("bluebg.png");
        ground=new Texture("ground.png");
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();

        game.batch.begin();
        game.batch.draw(bg, 0,0,MAX_WIDTH,MAX_HEIGHT);

        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height,true);
        game.batch.setProjectionMatrix(cam.combined);
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

    }
}
