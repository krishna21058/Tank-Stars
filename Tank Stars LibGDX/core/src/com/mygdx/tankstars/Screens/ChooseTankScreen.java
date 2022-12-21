package com.mygdx.tankstars.Screens;

import static com.badlogic.gdx.utils.Align.center;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.tankstars.MusicManager;
import com.mygdx.tankstars.Tank;
import com.mygdx.tankstars.TankCoalition;
import com.mygdx.tankstars.TankFrost;
import com.mygdx.tankstars.TankHelios;
import com.mygdx.tankstars.TankStars;

public class ChooseTankScreen implements Screen {
    private PlayScreen p;
    private TextButton buttonNext, buttonBack;
    private TextButton buttonSelect;
    private TextButton buttonPlayer1;
    private TextButton buttonPlayer2;
    private Stage stage;

    private TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private OrthographicCamera camera;
    private Label myLabel;
    private Skin skin;
    private Skin skin_font;
    private ShapeRenderer shaperenderer;
    private TextButton.TextButtonStyle buttonStyle;
    public static float worldWidth;
    public static float worldHeight;
    private Texture tankHelios_Image;
    private ImageButton tankHelios_Button;
    private TextButton Tb_tank1;
    private TextButton Tb_tank2;
    private TextButton Tb_tank3;

    private String P1_tank;
    private String P2_tank;


    private int currentPlayer;
    private int tankL;
    private int currTank;
    private Music music_m;

    public PlayScreen getP() {
        return p;
    }

    public void setP(PlayScreen p) {
        this.p = p;
    }

    public TextButton getButtonNext() {
        return buttonNext;
    }

    public void setButtonNext(TextButton buttonNext) {
        this.buttonNext = buttonNext;
    }

    public TextButton getButtonBack() {
        return buttonBack;
    }

    public void setButtonBack(TextButton buttonBack) {
        this.buttonBack = buttonBack;
    }

    public TextButton getButtonSelect() {
        return buttonSelect;
    }

    public void setButtonSelect(TextButton buttonSelect) {
        this.buttonSelect = buttonSelect;
    }

    public TextButton getButtonPlayer1() {
        return buttonPlayer1;
    }

    public void setButtonPlayer1(TextButton buttonPlayer1) {
        this.buttonPlayer1 = buttonPlayer1;
    }

    public TextButton getButtonPlayer2() {
        return buttonPlayer2;
    }

    public void setButtonPlayer2(TextButton buttonPlayer2) {
        this.buttonPlayer2 = buttonPlayer2;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TankStars getGame() {
        return game;
    }

    public void setGame(TankStars game) {
        this.game = game;
    }

    public Texture getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Texture backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public TextureRegion getBackgroundTexture() {
        return backgroundTexture;
    }

    public void setBackgroundTexture(TextureRegion backgroundTexture) {
        this.backgroundTexture = backgroundTexture;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Label getMyLabel() {
        return myLabel;
    }

    public void setMyLabel(Label myLabel) {
        this.myLabel = myLabel;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public Skin getSkin_font() {
        return skin_font;
    }

    public void setSkin_font(Skin skin_font) {
        this.skin_font = skin_font;
    }

    public ShapeRenderer getShaperenderer() {
        return shaperenderer;
    }

    public void setShaperenderer(ShapeRenderer shaperenderer) {
        this.shaperenderer = shaperenderer;
    }

    public TextButton.TextButtonStyle getButtonStyle() {
        return buttonStyle;
    }

    public void setButtonStyle(TextButton.TextButtonStyle buttonStyle) {
        this.buttonStyle = buttonStyle;
    }

    public Texture getTankHelios_Image() {
        return tankHelios_Image;
    }

    public void setTankHelios_Image(Texture tankHelios_Image) {
        this.tankHelios_Image = tankHelios_Image;
    }

    public ImageButton getTankHelios_Button() {
        return tankHelios_Button;
    }

    public void setTankHelios_Button(ImageButton tankHelios_Button) {
        this.tankHelios_Button = tankHelios_Button;
    }

    public TextButton getTb_tank1() {
        return Tb_tank1;
    }

    public void setTb_tank1(TextButton tb_tank1) {
        Tb_tank1 = tb_tank1;
    }

    public TextButton getTb_tank2() {
        return Tb_tank2;
    }

    public void setTb_tank2(TextButton tb_tank2) {
        Tb_tank2 = tb_tank2;
    }

    public TextButton getTb_tank3() {
        return Tb_tank3;
    }

    public void setTb_tank3(TextButton tb_tank3) {
        Tb_tank3 = tb_tank3;
    }

    public String getP1_tank() {
        return P1_tank;
    }

    public void setP1_tank(String p1_tank) {
        P1_tank = p1_tank;
    }

    public String getP2_tank() {
        return P2_tank;
    }

    public void setP2_tank(String p2_tank) {
        P2_tank = p2_tank;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getTankL() {
        return tankL;
    }

    public void setTankL(int tankL) {
        this.tankL = tankL;
    }

    public int getCurrTank() {
        return currTank;
    }

    public void setCurrTank(int currTank) {
        this.currTank = currTank;
    }

    public Music getMusic_m() {
        return music_m;
    }

    public void setMusic_m(Music music_m) {
        this.music_m = music_m;
    }

    public ChooseTankScreen(TankStars game) {

        this.game = game;
        this.worldWidth = Gdx.graphics.getWidth();
        this.worldHeight = Gdx.graphics.getHeight();
        this.shaperenderer = new ShapeRenderer();
        music_m= MusicManager.getManager().get("New Victories Await - Copy.mp3", Music.class);
        music_m.setLooping(true);
        music_m.play();
        this.stage = new Stage();

        backgroundImage = new Texture(Gdx.files.internal("greenbg.png"));
        this.skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));
        this.skin_font = new Skin(Gdx.files.internal("skin-freezing/freezing-ui.json"));
        initButtons();
        Gdx.input.setInputProcessor(stage);
        this.currentPlayer = 1;
    }


    @Override
    public void show() {

    }

    private void initButtons() {

        Table table = new Table();
        table.setPosition(0, 0);
        table.setFillParent(true);
//
        myLabel = new Label("Choose Tank", skin_font);
        Label dummyLabel = new Label("", skin);
        myLabel.setColor(Color.GOLD);
        myLabel.setFontScale(2.6f, 2.6f);
        myLabel.setAlignment(center);

        table.add(dummyLabel);
        table.add(myLabel).center();

        table.row();

        Label labelPlayer1 = new Label("PLAYER-1", skin);
        labelPlayer1.setFontScale(1.4f, 1.4f);
        labelPlayer1.setAlignment(center);
        labelPlayer1.setColor(Color.GOLD);
        buttonPlayer1 = new TextButton("PLAYER-1", skin);
        buttonPlayer1.setColor(Color.GREEN);
        buttonPlayer1.setLabel(labelPlayer1);
        table.add(buttonPlayer1).width(130).height(70);

        table.add(dummyLabel);

        Label labelPlayer2 = new Label("PLAYER-2", skin);
        labelPlayer2.setFontScale(1.4f, 1.4f);
        labelPlayer2.setAlignment(center);
        labelPlayer2.setColor(Color.GOLD);
        buttonPlayer2 = new TextButton("PLAYER-2", skin);
        buttonPlayer2.setColor(Color.GREEN);
        buttonPlayer2.setLabel(labelPlayer2);
        table.add(buttonPlayer2).width(130).height(70);

        table.row();

        ImageButton imageButton1 = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("tankHelios.png"))));
        ImageButton imageButton2 = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("tankCoalition.png"))));
        ImageButton imageButton3 = new ImageButton(new TextureRegionDrawable(new Texture(Gdx.files.internal("tankFrost.png"))));
        imageButton1.setPosition(100, 100);
        table.add(imageButton1).width(175).height(175).center();
        imageButton2.setPosition(100, 100);
        table.add(imageButton2).width(175).height(175).center();
        imageButton3.setPosition(100, 100);
        table.add(imageButton3).width(175).height(175).center();
        table.row();

        Label label_tank1 = new Label("Helios", skin);
        Label label_tank2 = new Label("Coalition", skin);
        Label label_tank3 = new Label("Frost", skin);
        label_tank1.setFontScale(1.4f, 1.4f);
        label_tank2.setFontScale(1.4f, 1.4f);
        label_tank3.setFontScale(1.4f, 1.4f);
        label_tank3.setAlignment(center);
        label_tank2.setAlignment(center);
        label_tank1.setAlignment(center);
        label_tank1.setColor(Color.GOLD);
        label_tank2.setColor(Color.GOLD);
        label_tank3.setColor(Color.GOLD);

        Tb_tank1 = new TextButton("Helios", skin);
        Tb_tank2 = new TextButton("Coalition", skin);
        Tb_tank3 = new TextButton("Frost", skin);
        Tb_tank1.setColor(Color.GREEN);
        Tb_tank2.setColor(Color.GREEN);
        Tb_tank3.setColor(Color.GREEN);
        Tb_tank1.setLabel(label_tank1);
        Tb_tank2.setLabel(label_tank2);
        Tb_tank3.setLabel(label_tank3);


        table.add(Tb_tank1).padBottom(40).width(120).height(60).center();
        table.add(Tb_tank2).padBottom(40).width(120).height(60).center();
        table.add(Tb_tank3).padBottom(40).width(120).height(60).center();
        table.row();

        Label LabelBack = new Label("BACK", skin);
        LabelBack.setFontScale(1.4f, 1.4f);
        LabelBack.setAlignment(center);
        LabelBack.setColor(Color.GOLD);
        buttonBack = new TextButton("BACK", skin);
        buttonBack.setColor(Color.YELLOW);
        buttonBack.setLabel(LabelBack);
        table.add(buttonBack).padBottom(10).width(120).height(60).left();

        Label labelSelect = new Label("SELECT", skin);
        labelSelect.setFontScale(1.4f, 1.4f);
        labelSelect.setAlignment(center);
        labelSelect.setColor(Color.GOLD);
        buttonSelect = new TextButton("SELECT", skin);
        buttonSelect.setColor(Color.YELLOW);
        buttonSelect.setLabel(labelSelect);
        table.add(buttonSelect).padBottom(10).width(120).height(60).center();

        Label LabelNext = new Label("PLAY", skin);
        LabelNext.setFontScale(1.6f, 1.6f);
        LabelNext.setAlignment(center);
        LabelNext.setColor(Color.GOLD);
        buttonNext = new TextButton("PLAY", skin);
        buttonNext.setColor(Color.YELLOW);
        buttonNext.setLabel(LabelNext);
        table.add(buttonNext).padBottom(10).width(120).height(60).right();
        this.buttonPlayer1.setColor(Color.YELLOW);

        stage.addActor(table);

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundImage, 0, 0, worldWidth, worldHeight);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        this.buttonPlayer1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (currentPlayer != 1) {
                    currentPlayer = 1;
                    buttonPlayer1.setColor(Color.YELLOW);
                    buttonPlayer2.setColor(Color.GREEN);
                }
            }
        });

        this.buttonPlayer2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (currentPlayer != 2) {
                    currentPlayer = 2;
                    buttonPlayer1.setColor(Color.GREEN);
                    buttonPlayer2.setColor(Color.YELLOW);
                }
            }
        });


        Tb_tank1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Tb_tank1.setColor(Color.YELLOW);
                Tb_tank2.setColor(Color.GREEN);
                Tb_tank3.setColor(Color.GREEN);
                currTank=1;
            }
        });
        Tb_tank2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Tb_tank2.setColor(Color.YELLOW);
                Tb_tank3.setColor(Color.GREEN);
                Tb_tank1.setColor(Color.GREEN);
                currTank=2;

            }
        });
        Tb_tank3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Tb_tank3.setColor(Color.YELLOW);
                Tb_tank2.setColor(Color.GREEN);
                Tb_tank1.setColor(Color.GREEN);
                currTank=3;
            }
        });
        buttonSelect.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(currentPlayer==1){
                    if(currTank==1){
                        P1_tank="tankHelios";
                    }else if(currTank==2){
                        P1_tank="tankCoalition";
                    }else if(currTank==3){
                        P1_tank="tankFrost";
                    }
                }
                else{
                    if(currTank==1){
                        P2_tank="tankHelios";
                    }else if(currTank==2){
                        P2_tank="tankCoalition";
                    }else if(currTank==3){
                        P2_tank="tankFrost";
                    }
                }
            }
        });
        buttonNext.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new PlayScreen(game,P1_tank,P2_tank));
            }
        });
        buttonBack.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                dispose();
                game.setScreen(new MenuScreen(game));
            }
        });
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
        stage.dispose();
        skin.dispose();
        skin_font.dispose();
        backgroundImage.dispose();
    }

}
