package com.mygdx.tankstars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.tankstars.Screens.PlayScreen;

public class TankStars extends Game {
	public SpriteBatch batch;
	ShapeRenderer shapeRenderer;
//	private static final float STAR_DENSITY = 0.1f;
//	Texture img;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer=new ShapeRenderer();
		setScreen(new PlayScreen(this));
//		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		super.render(); //takes render method to active screen.

	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}
