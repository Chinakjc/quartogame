package com.mygdx.game;

public class Jouer_1v1 {
    private String[][] Joueur;
    private int fini;
    private PieceActor[] pieceActor;
    private int est_bon;
    private int[] indice_piece_dispo;
    private int[] indice_piece_pas_dispo;


    public Jouer_1v1(int compte,String[] nom_joueur1,String[] nom_jouer2,PieceActor[] pieceActors){
        this.Joueur[0] = nom_joueur1;
        this.Joueur[1] = nom_jouer2;
        this.pieceActor = pieceActors;
        this.indice_piece_dispo = get_indice_pieces_dispo();
        this.indice_piece_pas_dispo = get_indice_piece_pas_dispo();
    }

    public int[] get_indice_pieces_dispo(){
        int[] temp = new int[16];
        int len = 0;
        for(int i=0;i<16;i++){
            if(this.pieceActor[i].getPiece().est_disponible==1){
                temp[len] = i;
                len++;
            }
        }
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            res[i] = temp[i];
        }

        return res;
    }

    public int[] get_indice_piece_pas_dispo(){
        int[] temp = new int[16];
        int len = 0;
        for(int i=0;i<16;i++){
            if(this.pieceActor[i].getPiece().est_disponible==0){
                temp[len] = i;
                len++;
            }
        }
        int[] res = new int[len];
        for(int i=0; i<len; i++){
            res[i] = temp[i];
        }

        return res;
    }





}
