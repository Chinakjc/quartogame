package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ScreenUtils;

public class Logo_Actor_MainGame extends Actor{
    private Texture texture;


    public Logo_Actor_MainGame(){
        super();
        this.texture = new Texture("logo.png");
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
        Taille_MainGame taille = new Taille_MainGame(MainGame.width_0,MainGame.height_0);
        batch.setColor(1,1,1,0.25f);
        batch.draw(texture,
                taille.position_x_logo,taille.position_y_logo,
                taille.width/4*3,taille.height/4);

    }
}
