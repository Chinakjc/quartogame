package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ScreenUtils;

public class BackGroundActor extends Actor {
    private Texture texture;


    public BackGroundActor(){
        super();
        this.texture = new Texture("bg.jpg");
    }


    @Override
    public void act(float delta){
        super.act(delta);
    }

    @Override
    public void draw(Batch batch,float parentAlpha){
        super.draw(batch, parentAlpha);
        if(!isVisible()){
            return;
        }
        batch.setColor(1,1,1,1);
        batch.draw(texture,0,0,MainGame.width_0,MainGame.height_0);
    }

}

