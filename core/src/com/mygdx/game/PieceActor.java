package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PieceActor extends Actor {
    private Texture texture;
    private Piece piece;

    public PieceActor(Piece piece){
        super();
        this.texture = new Texture(piece.getIndice_texture()+".png");
        this.piece = piece;
    }

    public void select(){
        this.piece.select();
    }

    public void mettre_au_plateau(int l,int c){
        this.piece.mettre_au_plateau(l,c);
    }

    public Piece getPiece(){
        return this.piece;
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
        if(piece.est_selectionnee == 1) {
            batch.setColor(1, 1, 1, 0.5f);
            batch.draw(
                    new Texture("carre.png"),
                    piece.position_carre()[0], piece.position_carre()[1],
                     r,  r
            );
        }
        batch.setColor(piece.getParametre_couleur()[0],piece.getParametre_couleur()[1],piece.getParametre_couleur()[2],1);
        batch.draw(
                texture,
                piece.position()[0],piece.position()[1],
                piece.getParametre_taille()*r,piece.getParametre_taille()*r
        );



    }

}
