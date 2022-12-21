package com.mygdx.tankstars;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.tankstars.Screens.PlayScreen;

public class Missile extends Sprite {
    //    float ppm=100;
    protected World world;
    public Texture texture;


    double xVelocity,yVelocity,totalTime,timeIncrement,xIncrement,x,y,velocity,angle,t;
    boolean remove=false;
    static float acceleration=9.81f;

    public Missile(PlayScreen screen, float x, float y) {
        this.world = screen.getWorld();
        this.x = x;
        this.y = y;

        velocity = 1;
        angle = Math.toRadians(30);
        int steps = 60;

        xVelocity = velocity * Math.cos(angle);
        yVelocity = velocity * Math.sin(angle);
        totalTime = -2.0 * yVelocity / (-9.81);
        timeIncrement = totalTime / steps;
        xIncrement = xVelocity * timeIncrement;
        t = 0.0;
        setBounds(x, y, 30 / TankStars.ppm, 30 / TankStars.ppm);
        setRegion(new Texture("missile.png"));
    }

    public void update(float dt) {
        t += timeIncrement;
        x += xIncrement;
        y = yVelocity * t + 0.5 * (-9.81) * t * t;
        setPosition((float)x,(float)y);
        }
}
