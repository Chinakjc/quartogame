package com.mygdx.game;

public class Taille_Menu_Principal {
    private int width_screen;
    private int height_screen;

    public int width_boutons;
    public int height_boutons;
    public int width_logo;
    public int height_logo;
    public int position_x_initial_boutons;
    public int position_y_initial_boutons;
    public int position_x_initial_logo;
    public int position_y_initial_logo;
    public int unite;


    public Taille_Menu_Principal(int w, int h){
        this.width_screen = w;
        this.height_screen = h;

        int a;
        int b;



        a = Math.max(w,h)/(3+9+3); //max est pour adapter les écrans horzontaux(w>h) et verticaux(w<h) !
        b = Math.min(w,h)/(1+3+1+2+1+2+1+2+1+2+1+2+1); // min est pour adapter les écrans horizontaux et verticaux !

        this.unite = Math.min(a,b);

        this.width_boutons = unite*8;  //w:h = 4:1
        this.height_boutons = unite*2;

        this.width_logo = unite*9;  //w:h = 3:1
        this.height_logo = unite*3;



        this.position_x_initial_logo= (w-this.width_logo)/2;
        this.position_y_initial_logo = h-(1+3)*unite;
        this.position_x_initial_boutons = (w-this.width_boutons)/2;
        this.position_y_initial_boutons = unite;


    }
}
