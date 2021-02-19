package com.mygdx.game;

public class Boutons_Menu_Principal {

    private int fonction; //0: "NEW GAME" 1: "LOAD GAME" 2: "ABOUT" 3: "EXIT"
    public int est_selectionné; //0: non 1: oui



    public Boutons_Menu_Principal(int fonction, int select){
        this.fonction = fonction;
        this.est_selectionné = select;
    }

    public int get_Indice_Texture(){
        return this.fonction+5*this.est_selectionné;
    }

    public int[] position(){
        Taille_Menu_Principal taille = new Taille_Menu_Principal(MainGame.width_0,MainGame.height_0);
        int[] pos = new int[2]; //pos[0]=x pos[1]=y
        pos[0] = taille.position_x_initial_boutons;
        if(this.fonction<3){
            pos[1] = taille.position_y_initial_logo-(fonction+1)*(taille.unite+taille.height_boutons);
        }
        else {
            int i = 4-this.fonction;
            pos[1] = taille.position_y_initial_boutons + i*taille.unite + i*taille.height_boutons;
        }
        return pos;
    }

    public void select(){
        this.est_selectionné = 1;
    }

    public void pas_select(){
        this.est_selectionné = 0;
    }

}
