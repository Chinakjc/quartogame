package com.mygdx.game;

public class Taille_MainGame {
    private int width_screen;
    private int height_screen;

    public int width;
    public int height;
    public int position_x_initial_plateau;
    public int position_y_initial_plateau;
    public int position_x_initial_piece;
    public int position_y_initial_piece;
    public int position_x_logo;
    public int position_y_logo;


    public Taille_MainGame(int w, int h){
        this.width_screen = w;
        this.height_screen = h;

        int a;
        int b;
        int r;


        a = Math.max(w,h)/(1+4+1+4+1)*4; //max est pour adapter les écrans horzontaux(w>h) et verticaux(w<h) !
        b = Math.min(w,h)/(1+4+1)*4; // min est pour adapter les écrans horizontaux et verticaux !

        r = Math.min(a,b);

        this.width = r;
        this.height = this.width;

        r = r/4;

        // this.position_x_initial_plateau = r*(1+4+1);
        this.position_x_initial_plateau = w-(1+4)*r;
        this.position_y_initial_plateau = h-(1+4)*r;
        this.position_x_initial_piece = r;
        this.position_y_initial_piece = r;

        this.position_x_logo = this.position_x_initial_plateau+(this.width-3*r)/2;
        this.position_y_logo = this.position_y_initial_plateau+(this.width-r)/2;




    }
}
