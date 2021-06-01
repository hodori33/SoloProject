package TestClass;

import java.awt.*;

public class Font {

	public static void main(String[] args) {
		GraphicsEnvironment ge = null;
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.Font[] fonts = ge.getAllFonts();
		for (int i = 0; i < fonts.length; i++) {
			System.out.println(fonts[i].getFontName());

		}

	}

}