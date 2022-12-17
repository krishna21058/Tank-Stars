package com.mygdx.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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

//	Texture img;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.getData().setScale(0.2f);
		// Set the filter
		font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		this.setScreen(new StartScreen(this));
	}



	@Override
	public void render () {
		super.render(); //takes render method to active screen.
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();

//		img.dispose();
	}
}
