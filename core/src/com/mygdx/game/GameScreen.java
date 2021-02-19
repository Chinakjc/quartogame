package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameScreen implements Screen {
    private MainGame game;
    private Stage stage;
    private PieceActor[] pieceActor;
    private PlateauActor plateauActor;
    private BackGroundActor bg;
    private Piece[] piece;
    private Logo_Actor_MainGame logo;
    private Taille_MainGame taille;


    public GameScreen(MainGame game){
        this.game = game;
        taille = new Taille_MainGame(MainGame.width_0,MainGame.height_0);

        stage = new Stage(new StretchViewport(MainGame.width_0,MainGame.height_0));
        bg = new BackGroundActor();
        stage.addActor(bg);

        logo= new Logo_Actor_MainGame();
        stage.addActor(logo);

        plateauActor = new PlateauActor();
        pieceActor = new PieceActor[16];

        piece=new Piece[16];
        int indice_piece=0;
        for(int branche=0; branche<2; branche++){
            for(int ronde=0; ronde <2; ronde++){
                for(int grande=0; grande<2; grande++){
                    for (int plaine=0; plaine<2; plaine++){
                        piece[indice_piece] = new Piece(branche,ronde,grande,plaine,1,0);
                        indice_piece++;
                    }
                }
            }
        }

        pieceActor = new PieceActor[16];
        plateauActor = new PlateauActor();
        stage.addActor(plateauActor);
        for(int i=0; i<16; i++){
            pieceActor[i] = new PieceActor(piece[i]);
            stage.addActor(pieceActor[i]);
        }
    }
    private int trans_binaire(int n){
        if(n<2) return n;
        return 10*(this.trans_binaire(n/2))+n%2;
    }

    private int get_Indice_piece_dispo_par_ligne_colonne(int l, int c){
        int x,y;
        int a1,a2,a3,a4;
        x=this.trans_binaire(l);
        y=this.trans_binaire(c);
        a1=x/10;
        a2=x%10;
        a3=y/10;
        a4=y%10;
        return (1-a3)*8+(1-a1)*4+(1-a2)*2+a4;
    }


    @Override
    public void render(float delta){
        ScreenUtils.clear(1,1,1,1);

        int x= Gdx.input.getX();
        int y= Gdx.input.getY();
        y = MainGame.height_0-y;
        /*if(Gdx.input.isTouched()) {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            int l;
            int c;
            int r = taille.width/4;
            l=(x-taille.position_x_initial_piece)/r;
            c=(y-taille.position_y_initial_piece)/r;
            System.out.println("l = "+l);
            System.out.println("C = "+c);
        }*/


        int k=0;
        int i=-1;
        while(k==0&&i<15){
            i++;
            if((piece[i].est_disponible == 1) && (piece[i].est_selectionnee ==1)) k=1;
        }

        if((k==0)&&
                (x>taille.position_x_initial_piece)&&(x<taille.position_x_initial_piece+taille.width)&&
                (y>taille.position_y_initial_piece)&&(y<taille.position_y_initial_piece+taille.height)&&
                (Gdx.input.isTouched())){
            int l;
            int c;
            int r = taille.width/4;
            c=(x-taille.position_x_initial_piece)/r;
            l=(y-taille.position_y_initial_piece)/r;
            if(pieceActor[this.get_Indice_piece_dispo_par_ligne_colonne(l,c)].getPiece().est_disponible == 1){
                pieceActor[this.get_Indice_piece_dispo_par_ligne_colonne(l,c)].select();
            }

        }

        if((k==1)&&
                (x>taille.position_x_initial_plateau)&&(x<taille.position_x_initial_plateau+taille.width)&&
                (y>taille.position_y_initial_plateau)&&(y<taille.position_y_initial_plateau+taille.height)&&
                (Gdx.input.isTouched())){
                int l;
                int c;
                int r = taille.width/4;
                c=(x-taille.position_x_initial_plateau)/r;
                l=(y-taille.position_y_initial_plateau)/r;
                pieceActor[i].mettre_au_plateau(l,c);
        }

        /*int i=15;
        System.out.println("i="+i);
        System.out.println(this.get_Indice_piece_dispo_par_ligne_colonne(piece[i].ligne,piece[i].colonne));

         */







        stage.act(delta);
        stage.draw();
    }

    @Override
    public void show(){

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {


        if (stage != null) {
            stage.dispose();
        }

    }


}
