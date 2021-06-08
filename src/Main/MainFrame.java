package Main;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Panels.HomePanel;

public class MainFrame extends WindowAdapter {
	public static Frame f;
	
	public MainFrame(String user) {
		f = new Frame(user);
		f.setLayout(null);
		f.setBounds(0, 0, 700, 700);
		

		Toolkit tt = Toolkit.getDefaultToolkit();
		Dimension screenSize = tt.getScreenSize();
		f.setLocation(screenSize.width / 2 - (700 / 2), screenSize.height / 2 - (700 / 2));
		f.addWindowListener(this);
		f.setVisible(true);
		new HomePanel();
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

}
