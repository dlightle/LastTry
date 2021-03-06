package org.egordorichev.lasttry.util;

import org.newdawn.slick.*;
import org.newdawn.slick.Font;
import org.newdawn.slick.Image;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;
import java.io.IOException;

public class Assets {
	public static Image dirtTileTexture = loadImage("DirtTile.png");
	public static Image dirtWallTexture = loadImage("DirtWall.png");
	public static Image greenSlimeTexture = loadImage("GreenSlime.png");
	public static Image playerTexture = loadImage("Player.png");

	public static UnicodeFont font = loadFont("font.ttf");

	public static Image loadImage(String path) {
		try {
			Image image = new Image("assets/images/" + path);
			image.setFilter(Image.FILTER_NEAREST);

			return image;
		} catch(SlickException exception) {
			System.out.println(path + " not found.");
			System.exit(-1);
		}

		return null;
	}

	public static UnicodeFont loadFont(String path) {
		try {
			UnicodeFont font = new UnicodeFont(java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream("assets/fonts/" + path)));
			font.addAsciiGlyphs();
			font.getEffects().add(new ColorEffect());

			return font;
		} catch(FontFormatException exception) {
			exception.printStackTrace();
		} catch(IOException exception) {
			exception.printStackTrace();
		}

		return null;
	}

	public static void preload() {

	}
}