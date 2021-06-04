package Panels;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;

import Buttons.ActButton;
import Main.MainFrame;

public class HomePanel {
	private Panel homeP;
	private Button[] b;
	private String[] bName = { "Java Funtion", "Java Term", "SQL", "Function DB", "Function DB Remove", "Term DB",
			"Term DB Remove", "SQL DB", "SQL DB Remove" };

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
		for(int i = 1; i <= 3 ;i++) {
			b[i-1].setBounds(i * 150, 300, 100, 80);
		}
		
		b[3].setBounds(400, 500, 110, 40);
		b[4].setBounds(530, 500, 130, 40);
		b[5].setBounds(400, 550, 110, 40);
		b[6].setBounds(530, 550, 130, 40);
		b[7].setBounds(400, 600, 110, 40);
		b[8].setBounds(530, 600, 130, 40);
		
		MainFrame.f.add(homeP);
	}
}
