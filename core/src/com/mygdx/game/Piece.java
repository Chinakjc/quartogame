package com.mygdx.game;

public class Piece {
    public int est_blanche; // 1: blanche; 0: blonde
    public int est_ronde; // 1: ronde; 0: carrée
    public int est_grande; // 1: grande; 0: petite
    public int est_pleine; // 1: pleine; 0: creuse
    public int est_disponible; // 1: disponible; 0: déja mise au plateau
    public int est_selectionnee; //1: selectionnée; 0: pas sellectionnée

    public int ligne;
    public int colonne;



    private float[] parametre_couleur = new float[4];



    public Piece(int blanche, int ronde, int grande, int pleine, int dispo, int select){
        this.est_blanche = blanche;
        this.est_ronde = ronde;
        this.est_grande = grande;
        this.est_pleine = pleine;
        this.est_disponible = dispo;
        this.est_selectionnee = select;


        //pour afficher les pieces plus facilement; ce n'est pas la position sur le plateau !
        this.ligne = 2*(1-ronde) +(1-grande);  //(1-x) ou x seulement pour le placement plus joli !
        this.colonne = 2*(1-blanche) +pleine;
    }

    public float[] getParametre_couleur(){
        if(est_blanche == 1) {
            for (int i = 0; i < 4; i++) {
                parametre_couleur[i] = 1;
            }
        }
        else{
            // r:g:b = 145:51:34  ; a=1
            float r = 1.0f/(145.0f+51.0f+34.0f);
            parametre_couleur[0] = r*145.0f; //r
            parametre_couleur[1] = r*51.0f;  //g
            parametre_couleur[2] = r*34.0f;  //b
            parametre_couleur[3] = 1.0f; //a
        }
        return  parametre_couleur;
    }

    public float getParametre_taille(){
        if(est_grande == 1) return 0.9f;
        return 0.5f;
    }

    public int getIndice_texture(){
        if(est_ronde == 1){
            if(est_pleine == 1) return 0;
            return 1;
        }
        if(est_pleine == 1) return 2;
        return 3;
    }

    public void mettre_au_plateau(int l,int c){
        this.est_disponible=0;
        this.ligne = l;
        this.colonne = c;
        this.est_selectionnee = 0;
    }

    public void select(){
        this.est_selectionnee = 1;
    }

    public int[] position(){
        int[] pos = new int[2]; //pos[0]: position_x; pos[1]: position_y
        Taille_MainGame tailleMainGame = new Taille_MainGame(MainGame.width_0,MainGame.height_0);
        int r = tailleMainGame.width/4;
        float parametre_taille = this.getParametre_taille();
        int taille_piece = (int)((float)(r*parametre_taille));

        if(est_disponible == 0){
            int x = tailleMainGame.position_x_initial_plateau;
            int y = tailleMainGame.position_y_initial_plateau;
            pos[0] = x + (r-taille_piece)/2 + this.colonne*r;
            pos[1] = y +(r-taille_piece)/2 + this.ligne*r;
        }
        else{
            int x = tailleMainGame.position_x_initial_piece;
            int y = tailleMainGame.position_y_initial_piece;
            pos[0] = x  + (r-taille_piece)/2 + this.colonne*r;
            pos[1] = y  + (r-taille_piece)/2 + this.ligne*r;
        }
        return pos;
    }

    public int[] position_carre(){

        int[] pos = new int[2];
        Taille_MainGame tailleMainGame = new Taille_MainGame(MainGame.width_0,MainGame.height_0);
        int r = tailleMainGame.width/4;
        int x=tailleMainGame.position_x_initial_piece;
        int y=tailleMainGame.position_y_initial_piece;
        pos[0]= x+this.colonne*r;
        pos[1]= y+this.ligne*r;
        return pos;
    }





}
