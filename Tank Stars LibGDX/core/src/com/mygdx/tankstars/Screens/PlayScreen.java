package com.mygdx.tankstars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.tankstars.Missile;
import com.mygdx.tankstars.MusicManager;
import com.mygdx.tankstars.Tank;
import com.mygdx.tankstars.TankCoalition;
import com.mygdx.tankstars.TankFrost;
import com.mygdx.tankstars.TankHelios;
import com.mygdx.tankstars.TankStars;

import java.util.Vector;

public class PlayScreen implements Screen {
    private final TankStars game;
    private Texture bg;
    private TextureRegion bgTexture;
    private Texture ground;
    private OrthographicCamera cam;
    private Viewport port;
    private Texture tankHelios;
    private Texture tankCoalition;
    private Texture tankFrost;
    public static float worldHeight;
    public static float worldWidth;
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
    private Music music;
    private Music music_shot;
    private Missile missile;
    //    private float ppm=100;
    private Tank p1;
    private Tank p2;
    private Missile mis;
    private boolean fired = false;
    private Tank tank;
    private World world;
    private Box2DDebugRenderer b2dr;

    public TankStars getGame() {
        return game;
    }


    public PlayScreen(TankStars game, String p1_tank, String p2_tank) {

        this.game = game;
        this.worldWidth = Gdx.graphics.getWidth();
        this.worldHeight = Gdx.graphics.getHeight();
        stage = new Stage();
        cam = new OrthographicCamera();
        port = new StretchViewport(1100 / TankStars.ppm, 600 / TankStars.ppm, cam);
        tankHelios = new Texture("tankHelios.png");
        this.mapLoader = new TmxMapLoader();
        this.map = this.mapLoader.load("maps/tileMap_plain.tmx");
        this.renderer = new OrthogonalTiledMapRenderer(map, 1 / (TankStars.ppm));

        world = new World(new Vector2(0, 0), true);
        b2dr = new Box2DDebugRenderer();
//        music = MusicManager.getManager().get("Roll out!.mp3", Music.class);
//        music.setLooping(true);
//        music.play();
        music_shot = MusicManager.getManager().get("tankshot.mp3", Music.class);
        music_shot.setLooping(true);
        music_shot.play();


        BodyDef bd = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fd = new FixtureDef();
        Body body;


        for (MapObject obj : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle r = ((RectangleMapObject) obj).getRectangle();
            bd.type = BodyDef.BodyType.StaticBody;
            bd.position.set((r.getX() + r.getWidth() / 2) / TankStars.ppm, (r.getY() + r.getHeight() / 2) / TankStars.ppm);
            body = world.createBody(bd);
            shape.setAsBox((r.getWidth() / 2) / TankStars.ppm, (r.getHeight() / 2) / TankStars.ppm);
            fd.shape = shape;
            body.createFixture(fd);
        }

        tankFrost = new Texture("tankFrost.png");
        tank = makeTank(p1_tank, p2_tank);
        tank=makeTank2(p1_tank, p2_tank);
        missile = new Missile(this, p1.body.getPosition().x, p1.body.getPosition().y);


        healthBar = new Texture("healthbar.png");
        fuel = new Texture("fuel.png");
        spriteTankFrost = new Sprite(tankFrost);
        spriteTankFrost.flip(true, false);

        pause = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("pause.png"))));
        pause.setPosition(-10, 420);
        pause.setSize(60, 60);
        stage.addActor(pause);
        fire = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("fire.png"))));
        fire.setPosition(200, 50);
        fire.setSize(70, 60);
        stage.addActor(fire);
        chosemis = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("chosemis.png"))));
        chosemis.setPosition(120, 50);
        chosemis.setSize(70, 60);
        stage.addActor(chosemis);
    }

    @Override
    public void show() {

    }

    public Tank makeTank(String p1_tank, String p2_tank) {
        if (p1_tank.equals("tankFrost")) {
            p1 = new TankFrost(this, 0);

            return p1;
//            p1.defineTank(0);
        } else if (p1_tank.equals("tankCoalition")) {
            p1 = new TankCoalition(this, 0);
            return p1;
//            p1.defineTank(0);
        } else if (p1_tank.equals("tankHelios")) {
            p1 = new TankHelios(this, 0);
            return p1;
//            p1.defineTank(0);
        } else {
            return tank;
        }

    }

    public Tank makeTank2(String p1_tank, String p2_tank) {


        if (p2_tank.equals("tankFrost")) {
            p2 = new TankFrost(this, 1);
            return p2;
//            p2.defineTank(1);
        } else if (p2_tank.equals("tankCoalition")) {
            p2 = new TankCoalition(this, 1);
            return p2;
//            p2.defineTank(1);
        } else if (p2_tank.equals("tankHelios")) {
            p2 = new TankHelios(this, 1);
            return p2;
//            p2.defineTank(1);
        } else {

            return tank;
        }

    }


    @Override
    public void render(float delta) {
        update(delta);
        if (fired == true) {

        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        renderer.setView(cam);
        renderer.render();
        b2dr.render(world, cam.combined);
        game.batch.setProjectionMatrix(cam.combined);
        game.batch.begin();

//        tank.defineTank();

        p2.draw(game.batch);
        p1.draw(game.batch);
        missile.draw(game.batch);
//        game.batch.draw(tankHelios, 160/TankStars.ppm, 179/TankStars.ppm, 100/TankStars.ppm, 100/TankStars.ppm);
//        game.batch.draw(spriteTankFrost, 530, 135, 100, 100);
        game.batch.draw(healthBar, 400 / TankStars.ppm, 500 / TankStars.ppm, 600 / TankStars.ppm, 80 / TankStars.ppm);

        game.batch.draw(fuel, 400 / TankStars.ppm, 475 / TankStars.ppm, 250 / TankStars.ppm, 40 / TankStars.ppm);
        game.batch.draw(fuel, 750 / TankStars.ppm, 475 / TankStars.ppm, 250 / TankStars.ppm, 40 / TankStars.ppm);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        if (Gdx.input.isKeyPressed(Input.Keys.UP) && p2.body.getLinearVelocity().x >= -2 && this.cam.position.x > 330 / TankStars.ppm) {
            p2.body.applyLinearImpulse(new Vector2(-0.1f, 0), p2.body.getWorldCenter(), true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && p2.body.getLinearVelocity().x <= 2 && this.cam.position.x < 880 / TankStars.ppm) {
            p2.body.applyLinearImpulse(new Vector2(0.1f, 0), p2.body.getWorldCenter(), true);
        }


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank.body.getLinearVelocity().x >= -2 && this.cam.position.x > 330 / TankStars.ppm) {
            p1.body.applyLinearImpulse(new Vector2(-0.1f, 0), tank.body.getWorldCenter(), true);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank.body.getLinearVelocity().x <= 2 && this.cam.position.x < 880 / TankStars.ppm) {
            p1.body.applyLinearImpulse(new Vector2(0.1f, 0), tank.body.getWorldCenter(), true);
        }

        fire.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                fired = true;

            }
        });

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            dispose();
            game.setScreen(new PauseScreen(this));
        }

    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height, true);
        game.batch.setProjectionMatrix(cam.combined);
    }

    @Override
    public void pause() {

    }

    public void update(float dt) {
        world.step(1 / 60f, 6, 2);
        p1.update(dt);
        p2.update(dt);
        missile.update(dt);
        cam.position.x = tank.body.getPosition().x;
        cam.update();
        renderer.setView(cam);
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
        world.dispose();
        b2dr.dispose();
    }

    public World getWorld() {
        return (this.world);
    }
}
