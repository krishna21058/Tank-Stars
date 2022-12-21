package com.mygdx.tankstars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.tankstars.Screens.PlayScreen;

public class TankFrost extends Tank {
    public TankFrost(){;}
    public TankFrost(PlayScreen screen,int inv) {
        this.world = screen.getWorld();
        defineTank(inv);
        setBounds(body.getPosition().x-20/TankStars.ppm,body.getPosition().y-20/TankStars.ppm, 80 / TankStars.ppm, 40 / TankStars.ppm);

        Texture texture = new Texture("tankFrost_new.png");
        if(inv==1) {
            Sprite spriteTankFrost = new Sprite(texture);
            spriteTankFrost.flip(true, false);
            setRegion(spriteTankFrost);
        }
        else{

            setRegion(texture);
        }

    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    protected void fire() {

    }

    protected void angle() {

    }

    protected void power() {

    }

    protected void moveForward() {

    }

    protected void moveBackward() {

    }

    protected void damageConceded() {

    }

    @Override
    public void update(float dt) {
        super.update(dt);
        setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);
    }
}
