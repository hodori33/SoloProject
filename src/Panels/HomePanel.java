package Panels;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;

import Buttons.ActButton;
import Main.MainFrame;

public class HomePanel {
	private Panel homeP;
	private Button[] b;
	private String[] bName = { "Java Funtion", "Java Term", "SQL" };

	public HomePanel() {
		homeP = new Panel();
		homeP.setLayout(null);
		homeP.setBackground(Color.green);
		homeP.setBounds(10, 10, 680, 700);

		b = new Button[bName.length];

		for (int i = 0; i < bName.length; i++) {
			b[i] = new Button(bName[i]);
			homeP.add(b[i]);
			b[i].addActionListener(new ActButton(homeP));
		}
		for (int i = 1; i <= 3; i++) {
			b[i - 1].setBounds(i * 150, 300, 100, 80);
		}

		MainFrame.f.add(homeP);
	}
}
