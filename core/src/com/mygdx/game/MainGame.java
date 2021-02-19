package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MainGame extends Game {
	public static  final int fps_0 = 60;

	public static  final int width_0 = 1920;
	public static  final int height_0 = 1440;

	//pour tester
	//public static  final int width_0 = 1920;
	//public static  final int height_0 = 1440;


	//public static  final int width_0 = 1080;
	//public static  final int height_0 = 1920;



    private  Screen_Menu_Principal screen_menu_principal;


	@Override
	public void create(){
		screen_menu_principal = new Screen_Menu_Principal(this);
		setScreen(screen_menu_principal);

	}


	@Override
	public void render(){
		super.render();





	}






}
