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
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.tankstars.TankStars;

public class PauseScreen implements Screen {
    private Skin skin_font;
    private PlayScreen p;
    private TextButton buttonPlay,buttonExit;
    private Stage stage;

    private TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
    private Label myLabel;
    private Skin skin;
    private ShapeRenderer shaperenderer;
    TextButton.TextButtonStyle buttonStyle;
    public static float worldWidth;
    public static float worldHeight;
    private TextButton buttonResume;
    private TextButton buttonRestart;
    private TextButton buttonQuit;
    private TextButton buttonSave;


    public PauseScreen(PlayScreen playScreen) {

        this.game = playScreen.getGame();
        this.p = playScreen;
        this.worldWidth=Gdx.graphics.getWidth();
        this.worldHeight=Gdx.graphics.getHeight();
        backgroundImage = new Texture(Gdx.files.internal("redbg.jpeg"));
        this.shaperenderer=new ShapeRenderer();
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
        table.setPosition(0,0);
        table.setFillParent(true);

        myLabel=new Label("GAME PAUSED",skin_font);
        myLabel.setColor(Color.WHITE);
        myLabel.setFontScale(2.8f,2.8f);
        myLabel.setAlignment(Align.center);

        table.add(myLabel).padBottom(30);

        table.row();

        Label label_resume=new Label("Resume",skin);
        label_resume.setFontScale(1.3f,1.3f);
        label_resume.setAlignment(center);
        label_resume.setColor(Color.SKY);
        buttonResume=new TextButton("Resume",skin);
        buttonResume.setLabel(label_resume);
        buttonResume.setColor(Color.YELLOW);
        table.add(buttonResume).width(200).height(80).padBottom(10);

        table.row();

        Label label_Restart=new Label("Restart",skin);

        label_Restart.setFontScale(1.3f,1.3f);
        label_Restart.setAlignment(center);
        label_Restart.setColor(Color.SKY);
        buttonRestart=new TextButton("Restart",skin);
        buttonRestart.setLabel(label_Restart);
        buttonRestart.setColor(Color.YELLOW);
        table.add(buttonRestart).width(200).height(80).padBottom(10);
        table.row();

        Label label_Save=new Label("Save & Quit",skin);
        label_Save.setFontScale(1.3f,1.3f);
        label_Save.setAlignment(center);
        label_Save.setColor(Color.SKY);
        buttonSave = new TextButton("Save & Quit", skin);
        buttonSave.setColor(Color.YELLOW);
        buttonSave.setLabel(label_Save);
        table.add(buttonSave).width(200).height(80).padBottom(10);
        table.row();

        Label label_Quit=new Label("Quit Game",skin);

        label_Quit.setFontScale(1.3f,1.3f);
        label_Quit.setAlignment(center);
        label_Quit.setColor(Color.SKY);
        buttonQuit=new TextButton("Quit Game",skin);
        buttonQuit.setLabel(label_Quit);
        buttonQuit.setColor(Color.YELLOW);
        table.add(buttonQuit).width(200).height(80);

        table.row();
        buttonResume.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ChooseTankScreen(game));
                return true;
            }
        });
        buttonRestart.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ChooseTankScreen(game));
                return true;
            }
        });
        buttonSave.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                TankStars.savedgame=p;
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });
        buttonQuit.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });

        stage.addActor(table);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundImage, 0,0,worldWidth,worldHeight);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
