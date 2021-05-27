package Main;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Panels.HomePanel;

public class MainFrame extends WindowAdapter {
	public static Frame f;

	MainFrame() {
		f = new Frame();
		f.setLayout(null);
		f.setBounds(0, 0, 1200, 700);

		Toolkit tt = Toolkit.getDefaultToolkit();
		Dimension screenSize = tt.getScreenSize();
		f.setLocation(screenSize.width / 2 - (1200 / 2), screenSize.height / 2 - (700 / 2));
		f.addWindowListener(this);
		f.setVisible(true);
		new HomePanel();
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

}
