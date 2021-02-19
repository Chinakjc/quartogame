package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlateauActor extends Actor {
    private Texture texture;


    public PlateauActor(){
        super();
        this.texture = new Texture("plateau.png");
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
        Taille_MainGame tailleMainGame = new Taille_MainGame(MainGame.width_0,MainGame.height_0);
        int r = tailleMainGame.width/4;
        int y = tailleMainGame.position_y_initial_plateau;
        batch.setColor(1,1,1,1);
        for(int i=0; i<4; i++){
            int x = tailleMainGame.position_x_initial_plateau;
            for(int j=0; j<4; j++){
                batch.draw(texture,x,y,r,r);
                x += r;
            }
            y += r;
        }
    }

}
