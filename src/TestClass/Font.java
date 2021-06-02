package TestClass;

import java.awt.*;

public class Font {

	public static void main(String[] args) {
//		GraphicsEnvironment ge = null;
//		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		java.awt.Font[] fonts = ge.getAllFonts();
//		for (int i = 0; i < fonts.length; i++) {
//			System.out.println(fonts[i].getFontName());
//			}
		Frame f = new Frame();
		Panel p = new Panel();
		Choice c = new Choice();
		List l = new List();
		f.setSize(500, 500);
		f.setLayout(null);
		p.setLayout(null);
		p.setBackground(Color.black);
		p.setBounds(10, 10, 480, 480);
		c.setBounds(20, 20, 100, 100);
		l.setBounds(200, 200, 100, 100);
		c.add("안녕하세요");
		l.add("하이");
		p.add(l);
		p.add(c);
		f.add(p);
		
		f.setVisible(true);
		
		
	}

}