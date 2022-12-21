package com.mygdx.tankstars;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;


public class MusicManager {
    private static AssetManager manager;

    public static AssetManager getManager() {
        return manager;
    }

    public static void setManager(AssetManager manager) {
        MusicManager.manager = manager;
    }

    private static MusicManager musicManager = null;
    private MusicManager(){
        ;
    }
    public static MusicManager getInstance(){
        if (musicManager == null){
            manager=new AssetManager();
            manager.load("this-is-war.mp3", Music .class);
            manager.load("Roll out!.mp3", Music.class);
            manager.load("New Victories Await.mp3", Music.class);
            manager.load("New Victories Await - Copy.mp3", Music.class);
            manager.load("tankshot.mp3", Music.class);
            manager.finishLoading();
        }

        return musicManager;
    }


}
