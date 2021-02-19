package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bouton_Actor_Menu_Principal extends Actor {

    private Texture texture;
    private Boutons_Menu_Principal bouton;

    public Bouton_Actor_Menu_Principal(Boutons_Menu_Principal bouton){
        super();
        this.bouton = bouton;
        this.texture = new Texture("bouton"+this.bouton.get_Indice_Texture()+".png");
    }

    public  Boutons_Menu_Principal getBouton(){
        return this.bouton;
    }

    public void select(){
        this.bouton.select();
        this.texture = new Texture("bouton" + this.bouton.get_Indice_Texture()+".png");
    }

    public void pas_select(){
        this.bouton.pas_select();
        this.texture = new Texture("bouton"+this.bouton.get_Indice_Texture()+".png");
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

        batch.draw(this.texture,
                this.bouton.position()[0],this.bouton.position()[1],
                taille.width_boutons,taille.height_boutons);
    }

}
