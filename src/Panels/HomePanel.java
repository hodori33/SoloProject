package Panels;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;

import Buttons.ActButton;
import Main.MainFrame;

public class HomePanel {
	private Panel homeP;
	private Button[] b;
	private String[] bName = { "Java API", "Java Term", "SQL" };

	public HomePanel() {
		homeP = new Panel();
		homeP.setLayout(null);
		homeP.setBackground(Color.green);
		homeP.setBounds(10, 10, 680, 700);

		b = new Button[3];

		for (int i = 0; i < 3; i++) {
			b[i] = new Button(bName[i]);
			homeP.add(b[i]);
			b[i].addActionListener(new ActButton(homeP));
			b[i].setBounds((i + 1) * 155, 300, 70, 70);
		}

		MainFrame.f.add(homeP);
	}
}
