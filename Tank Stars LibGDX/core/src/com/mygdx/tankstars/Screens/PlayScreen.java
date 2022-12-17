package com.mygdx.tankstars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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
    private Texture tankHelios;
    private Texture tankCoalition;
    private Texture tankFrost;
    public static float worldHeight;
    public static float  worldWidth;
    private Sprite spriteTankFrost;
    private Texture healthBar;
    private ImageButton pause;
    private TiledMap map;
    private TmxMapLoader mapLoader;
    private OrthogonalTiledMapRenderer renderer;
    private Texture fuel;
    private Stage stage;
    private ImageButton fire;
    private ImageButton chosemis;

    public TankStars getGame() {
        return game;
    }

    public PlayScreen(TankStars game) {

        this.game=game;
        this.worldWidth=Gdx.graphics.getWidth();
        this.worldHeight=Gdx.graphics.getHeight();
        stage=new Stage();
        cam = new OrthographicCamera();
        port=new StretchViewport(worldWidth,worldHeight,cam);
        tankHelios=new Texture("tankHelios.png");
        this.mapLoader = new TmxMapLoader();
        this.map = this.mapLoader.load("maps/tileMap.tmx");
        this.renderer = new OrthogonalTiledMapRenderer(map);
        tankFrost = new Texture("tankFrost.png");
        healthBar= new Texture("healthbar.png");
        fuel = new Texture("fuel.png");
        spriteTankFrost = new Sprite(tankFrost);
        spriteTankFrost.flip(true, false);
        pause = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("pause.png"))));
        pause.setPosition(-10,420);
        pause.setSize(60,60);
        stage.addActor(pause);
        fire= new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("fire.png"))));
        fire.setPosition(200,100);
        fire.setSize(70,60);
        stage.addActor(fire);
        chosemis= new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("chosemis.png"))));
        chosemis.setPosition(120,100);
        chosemis.setSize(70,60);
        stage.addActor(chosemis);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        renderer.setView(cam);
        renderer.render();
        game.batch.begin();
        game.batch.draw(tankHelios,160,179,100,100);
        game.batch.draw(spriteTankFrost,530,135,100,100);
        game.batch.draw(healthBar,120,420,400,60);

        game.batch.draw(fuel,140,400,100,30);
        game.batch.draw(fuel,400,400,100,30);

        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (this.cam.position.x < 880) {
                this.cam.position.x += 300*delta;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (this.cam.position.x > 330) {
                this.cam.position.x -= 300*delta;
            }
        }




        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            dispose();
            game.setScreen(new PauseScreen(this));
        }

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
        stage.dispose();
        renderer.dispose();
    }
}
