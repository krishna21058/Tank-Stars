package com.mygdx.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.tankstars.Screens.ChooseTankScreen;
import com.mygdx.tankstars.Screens.MenuScreen;
import com.mygdx.tankstars.Screens.PauseScreen;
import com.mygdx.tankstars.Screens.PlayScreen;
import com.mygdx.tankstars.Screens.StartScreen;


public class TankStars extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public static final float ppm=100;
	public static MusicManager mmanager;

	public static PlayScreen savedgame=null;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
//		manager=new AssetManager();
//		manager.load("this-is-war.mp3", Music.class);
//		manager.load("Roll out!.mp3", Music.class);
//		manager.load("New Victories Await.mp3", Music.class);
//		manager.load("New Victories Await - Copy.mp3", Music.class);
//		manager.finishLoading();
		mmanager=MusicManager.getInstance();

		font.getData().setScale(0.2f);
		// Set the filter
		font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		this.setScreen(new MenuScreen(this));
	}



	@Override
	public void render () {
		super.render(); //takes render method to active screen.
		mmanager.getManager().update();
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		mmanager.getManager().dispose();

//		img.dispose();
	}
}
