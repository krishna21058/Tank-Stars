package com.mygdx.tankstars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.tankstars.TankStars;

public class StartScreen extends InputAdapter implements Screen {

    private Skin skin_font;
    private Skin skin;
    private Stage stage;
    private TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private OrthographicCamera cam;
    private Viewport port;
    private Label myLabel;

    public static float worldHeight;
    public static float  worldWidth;

    public StartScreen(TankStars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("start3.jpg"));

        this.worldWidth=Gdx.graphics.getWidth();
        this.worldHeight=Gdx.graphics.getHeight();

        this.stage = new Stage();
        this.skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
        this.skin_font = new Skin(Gdx.files.internal("skin-freezing/freezing-ui.json"));
        initLabel();
    }

    private void initLabel() {
        Table table=new Table();
        table.setPosition(0,0);
        table.setFillParent(true);

        myLabel=new Label("Welcome  to  Tank  Stars!\nClick anywhere  to  begin!",skin_font);
//        myLabel.setColor(Color.YELLOW);
        myLabel.setFontScale(1.6f,1.6f);
        myLabel.setAlignment(Align.center);
        Label dummy=new Label("",skin);
        table.add(myLabel).center().padBottom(400);

        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        cam.update();
//        game.batch.setProjectionMatrix(cam.combined);
        game.batch.begin();
        game.batch.draw(backgroundImage, 0,0,worldWidth,worldHeight);
        game.batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        if (Gdx.input.isTouched()) {
            game.setScreen(new MenuScreen(game));
        }

    }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
