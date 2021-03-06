package org.egordorichev.lasttry;

import org.egordorichev.lasttry.entity.Player;
import org.egordorichev.lasttry.item.Block;
import org.egordorichev.lasttry.ui.UiButton;
import org.egordorichev.lasttry.ui.UiManager;
import org.egordorichev.lasttry.util.Assets;
import org.egordorichev.lasttry.util.Callable;
import org.egordorichev.lasttry.util.Direction;
import org.egordorichev.lasttry.world.World;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;
import org.egordorichev.lasttry.mod.*;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;

public class LastTry extends StateBasedGame {
	private static GameContainer container;

	public static Input input;
	public static Graphics graphics;
	public static World world;
	public static Player player;
	public static Camera camera;
	public static LuaState lua;
	public static ModLoader modLoader;
	public static UiManager ui;
	public static AppGameContainer app;
	public final static Random random = new Random();

	public LastTry() {
		super(new String[]{
			"LastTry: Dig Peon, Dig!",
			"LastTry: Epic Dirt",
			"LastTry: Hey Guys!",
			"LastTry: Sand is Overpowered",
			"LastTry Part 3: The Return of the Guide",
			"LastTry: A Bunnies Tale",
			"LastTry: Dr. Bones and The Temple of Blood Moon",
			"LastTry: Slimeassic Park",
			"LastTry: The Grass is Greener on This Side",
			"LastTry: Small Blocks, Not for Children Under the Age of 5",
			"LastTry: Digger T' Blocks",
			"LastTry: There is No Cow Layer",
			"LastTry: Suspicous Looking Eyeballs",
			"LastTry: Purple Grass!",
			"LastTry: Noone Dug Behind!",
			"LastTry: Shut Up and Dig Gaiden!"
		}[random.nextInt(16)]);
	}

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException {
		container = gameContainer;

		camera = new Camera();
		input = gameContainer.getInput();
		graphics = gameContainer.getGraphics();

		ui = new UiManager();

		lua = LuaStateFactory.newLuaState();
		lua.openLibs();

		graphics.setBackground(new Color(129, 207, 224));

		this.addState(new SplashState());
	}

	@Override
	public boolean closeRequested() {
		if(world != null) {
			world.save();
		}

		System.exit(0);
		return false;
	}

	public static int getWindowWidth() {
		return container.getWidth();
	}

	public static int getWindowHeight() {
		return container.getHeight();
	}

	public static void handleException(Exception exception) {
		exception.printStackTrace();
	}

	public static void main(String[] arguments) {
		try {
			LastTry.app = new AppGameContainer(new ScalableGame(new LastTry(), 800, 600, true));

			LastTry.app.setDisplayMode(800, 600, false);
			LastTry.app.setVSync(true);
			LastTry.app.setShowFPS(false);
			LastTry.app.start();
		} catch(Exception exception) {
			LastTry.handleException(exception);
		}
	}
}