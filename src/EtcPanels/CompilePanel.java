package EtcPanels;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;

import Buttons.ActButton;
import Main.MainFrame;

public class CompilePanel {
	private Panel comP;
	private Button runB, clearB;
	private TextArea inTa, outTa;

	public CompilePanel() {
		comP = new Panel();
		runB = new Button("Run");
		clearB = new Button("Clear");
		inTa = new TextArea();
		outTa = new TextArea();

		comP.setLayout(null);
		comP.setBackground(Color.GRAY);
		comP.setBounds(695, 0, 495, 700);

		inTa.setBounds(10, 35, 475, 310);

		clearB.setBounds(50, 350, 50, 30);
		clearB.addActionListener(new ActButton(inTa));
		runB.setBounds(400, 350, 50, 30);
		runB.addActionListener(new ActButton(inTa));

		outTa.setBounds(10, 380, 475, 310);
		outTa.setEditable(false);

		comP.add(clearB);
		comP.add(runB);
		comP.add(inTa);
		comP.add(outTa);

		MainFrame.f.add(comP);
	}

	public void closeP() {
		this.comP.setVisible(false);
	}
}