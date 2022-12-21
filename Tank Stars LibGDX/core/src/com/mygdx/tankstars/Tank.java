package com.mygdx.tankstars;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.tankstars.Screens.PlayScreen;

public class Tank extends Sprite {
//    float ppm=100;
    protected World world;
    public Body body;
    public Texture texture;

    protected float fuel;
    protected float health;
    protected int currentPosition;

    public Tank(){;}
    public Tank(PlayScreen screen,Tank t1) {
        this.world = screen.getWorld();
        setBounds(0,0,70/TankStars.ppm,40/TankStars.ppm);
        setRegion(new Texture("tankFrost_new.png"));

    }

    public void defineTank(int inv) {
        BodyDef bdf = new BodyDef();
        if(inv==1){
            bdf.position.set(650/TankStars.ppm,180/TankStars.ppm);

        }
        else{
            bdf.position.set(150/TankStars.ppm,180/TankStars.ppm);
        }

        bdf.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdf);
        FixtureDef fdf = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/TankStars.ppm);
        fdf.shape=shape;
        body.createFixture(fdf);

    }

//        @Override
        public void update(float dt) {
            setPosition(body.getPosition().x-getWidth()/2,body.getPosition().y-getHeight()/2+0.1f);
        }
//    }
//    public void draw(Batch batch){
//        super.draw(batch);
//    }

}
