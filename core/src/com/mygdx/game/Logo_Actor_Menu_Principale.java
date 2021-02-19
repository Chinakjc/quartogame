package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ScreenUtils;

public class Logo_Actor_Menu_Principale extends Actor{
    private Texture texture;


    public Logo_Actor_Menu_Principale(){
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
        Taille_Menu_Principal taille = new Taille_Menu_Principal(MainGame.width_0,MainGame.height_0);

        batch.draw(texture,
                taille.position_x_initial_logo,taille.position_y_initial_logo,
                taille.width_logo,taille.height_logo);
    }
}
