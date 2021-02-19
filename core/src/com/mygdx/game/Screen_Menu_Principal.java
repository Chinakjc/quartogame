package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Screen_Menu_Principal implements Screen {
    private MainGame game;
    private Stage stage;
    private Bouton_Actor_Menu_Principal[] boutonActor;
    private Logo_Actor_Menu_Principale logo;
    private BackGroundActor bg;




    public Screen_Menu_Principal(MainGame game) {
        this.game = game;



        stage = new Stage(new StretchViewport(MainGame.width_0, MainGame.height_0));
        bg = new BackGroundActor();
        stage.addActor(bg);

        logo = new Logo_Actor_Menu_Principale();
        stage.addActor(logo);

        boutonActor = new Bouton_Actor_Menu_Principal[5];
        for (int i = 0; i < 5; i++) {
            boutonActor[i] = new Bouton_Actor_Menu_Principal(new Boutons_Menu_Principal(i,0));
            stage.addActor(boutonActor[i]);
        }

    }

    @Override
    public void render(float delta){
        ScreenUtils.clear(1,1,1,1);

        int x = Gdx.input.getX();
        int y = Gdx.input.getY();
        //System.out.println(y);
        y = MainGame.height_0-y;
        Taille_Menu_Principal taille = new Taille_Menu_Principal(MainGame.width_0,MainGame.height_0);
        int width_boutons = taille.width_boutons;
        int height_boutons = taille.height_boutons;


        for(int i=0; i<5; i++){
            Boutons_Menu_Principal bt = boutonActor[i].getBouton();

            if((x>bt.position()[0])&&(x<(bt.position()[0]+taille.width_boutons))&&
                    (y>bt.position()[1])&&(y<(bt.position()[1]+taille.height_boutons))){
                boutonActor[i].select();

            }
            else boutonActor[i].pas_select();
        }

        if((boutonActor[0].getBouton().est_selectionné==1)&&(Gdx.input.isTouched())){
            this.game.setScreen(new GameScreen(this.game));
        }




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
