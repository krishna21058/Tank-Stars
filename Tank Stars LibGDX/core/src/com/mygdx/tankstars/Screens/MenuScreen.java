package com.mygdx.tankstars.Screens;

import static com.badlogic.gdx.utils.Align.center;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.tankstars.TankStars;

public class MenuScreen implements Screen {
    private final Skin skin_font;
    private PlayScreen p;
    private TextButton buttonPlay,buttonExit,buttonContinue,buttonComp;
    private Stage stage;

    private TankStars game;
    private Texture backgroundImage;
    private Texture logoImage;
    private TextureRegion backgroundTexture;
    private OrthographicCamera camera;
    private Skin skin;
    private ShapeRenderer shaperenderer;
    private TextButton.TextButtonStyle buttonStyle;
    public static float worldWidth;
    public static float worldHeight;
    private Texture TankImage;
    private ImageButton music;
    private Stage stage1;
//    private Texture Logo;

    public MenuScreen(TankStars game) {

        this.game = game;
        this.worldWidth=Gdx.graphics.getWidth();
        this.worldHeight=Gdx.graphics.getHeight();
        backgroundImage = new Texture(Gdx.files.internal("menubg.png"));
        TankImage = new Texture(Gdx.files.internal("tankCoalition.png"));
        logoImage = new Texture(Gdx.files.internal("logoEdited.png"));
//        music =new Texture(Gdx.files.internal("music.png"));
        this.stage = new Stage();
        this.skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
        this.skin_font = new Skin(Gdx.files.internal("skin-freezing/freezing-ui.json"));
        initButtons();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    private void initButtons() {
        Table table=new Table();
        table.setPosition(150,-40);
        table.setFillParent(true);

        Label dummy=new Label("",skin);

        Label label_play=new Label("Play New Game",skin);
        label_play.setFontScale(1.3f,1.3f);
        label_play.setAlignment(center);
        label_play.setColor(Color.GOLD);
        buttonPlay=new TextButton("Play New Game",skin);
        buttonPlay.setColor(Color.YELLOW);
        buttonPlay.setLabel(label_play);
        table.add(buttonPlay).width(200).height(80).padTop(50);

        table.row();

        Label label_Continue=new Label("Continue A Game",skin);

        label_Continue.setFontScale(1.3f,1.3f);
        label_Continue.setAlignment(center);
        label_Continue.setColor(Color.GOLD);
        buttonContinue=new TextButton("Continue A Game",skin,"custom");
        buttonContinue.setColor(Color.YELLOW);
        buttonContinue.setLabel(label_Continue);
        table.add(buttonContinue).width(200).height(80);
        table.row();

        Label label_Comp=new Label("vs Computer",skin);

        label_Comp.setFontScale(1.3f,1.3f);
        label_Comp.setAlignment(center);
        label_Comp.setColor(Color.GOLD);
        buttonComp=new TextButton("vs Computer",skin,"custom");
        buttonComp.setColor(Color.YELLOW);
        buttonComp.setLabel(label_Comp);
        table.add(buttonComp).width(200).height(80);
        table.row();

        Label label_Exit=new Label("Exit",skin);

        label_Exit.setFontScale(1.3f,1.3f);
        label_Exit.setAlignment(center);
        label_Exit.setColor(Color.GOLD);
        buttonExit=new TextButton("Exit",skin,"custom");
        buttonExit.setColor(Color.YELLOW);
        buttonExit.setLabel(label_Exit);
        table.add(buttonExit).width(200).height(80);

        table.row();
        buttonContinue.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new PlayScreen(game));
                return true;
            }
        });
        buttonPlay.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                game.setScreen(new ChooseTankScreen(game));
                return true;
            }
        });
        buttonExit.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                Gdx.app.exit();
                return true;
            }
        });
        stage1=new Stage();
        music = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("music.png"))));
        music.setPosition(-5,440);
        music.setSize(50,40);
        stage1.addActor(music);
        stage.addActor(table);
    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        game.batch.begin();
//        game.font.draw(game.batch, "Click anywhere  to  begin!", 32, 11);
//        game.batch.end();
        game.batch.begin();
        game.batch.draw(backgroundImage, 0,0,worldWidth,worldHeight);
        game.batch.draw(logoImage, 310,320,320,150);
        game.batch.draw(TankImage, 55,38,300,300);

        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        stage1.draw();
    }



    @Override
    public void resize(int width, int height) {
//        worldWidth=width;
//        worldHeight=height;
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
        stage.dispose();
        skin.dispose();
        skin_font.dispose();
        backgroundImage.dispose();
    }

}
