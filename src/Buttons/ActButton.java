package Buttons;

import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EtcPanels.CompilePanel;
import Panels.ApiPanel;
import Panels.HomePanel;
import Panels.SqlPanel;
import Panels.TermPanel;

public class ActButton implements ActionListener {
	private Panel p;
	private Button b1, b2;
	private TextArea ta;
	private CompilePanel cp;
	private String str = "";

	public ActButton() {
	}
	
	public ActButton(Panel p) {
		this.p = p;
	}

	
	public ActButton(TextArea ta) {
		this.ta = ta;
	}

	
	public ActButton(Button b1, Button b2) {
		this.b1 = b1;
		this.b2 = b2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Home")) {
			p.setVisible(false);
			new HomePanel();
		}
		if (e.getActionCommand().equals("Option")) {

			System.out.println("2");
		}
		if (e.getActionCommand().equals("LogOut")) {

			System.out.println("3");
		}
		if (e.getActionCommand().equals("Compile")) {
			CompilePanel c1 = new CompilePanel();
			b1.setLabel("Close");
			b2.setVisible(false);
			;
			cp = c1;
		}
		if (e.getActionCommand().equals("Close")) {
			cp.closeP();
			b1.setLabel("Compile");
			b2.setVisible(true);
		}

		if (e.getActionCommand().equals("Java API")) {
			p.setVisible(false);
			new ApiPanel();
		}

		if (e.getActionCommand().equals("Java Term")) {
			p.setVisible(false);
			new TermPanel();
		}

		if (e.getActionCommand().equals("SQL")) {
			p.setVisible(false);
			new SqlPanel();
		}

		if (e.getActionCommand().equals("Run")) {
			str = ta.getText();
			System.out.println(str);
		}

		if (e.getActionCommand().equals("Clear")) {
			ta.setText("");
		}

	}
}