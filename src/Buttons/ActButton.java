package Buttons;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DbMaker.SqlDbMaker;
import DbMaker.TermDbMaker;
import EtcPanels.CompilePanel;
import EtcPanels.SerchPanel;
import Panels.FunctionPanel;
import Panels.HomePanel;
import Panels.SqlPanel;
import Panels.TermPanel;

public class ActButton implements ActionListener {
	private Panel p;
	private Button b1, b2;
	private Choice c;
	private TextField tf;
	private TextArea ta;
	private CompilePanel cp;
	private SerchPanel sp;
	private FunctionPanel fp;
	private String cName, name;
	
	public ActButton() {
	}
	//홈에서의 패널 선택
	public ActButton(Panel p) {
		this.p = p;
	}
	//검색결과버튼
	public ActButton(String name, Choice c) {
		this.name = name;
		this.c = c;
		
	}
	//컴파일 기능
	public ActButton(TextArea ta) {
		this.ta = ta;
	}
	//컴파일on/off
	public ActButton(Button b1, Button b2) {
		this.b1 = b1;
		this.b2 = b2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		////홈패널
		if (e.getActionCommand().equals("Java Funtion")) {
			p.setVisible(false);
			new FunctionPanel();
		}

		if (e.getActionCommand().equals("Java Term")) {
			p.setVisible(false);
			new TermPanel();
		}

		if (e.getActionCommand().equals("SQL")) {
			p.setVisible(false);
			new SqlPanel();
		}
		if (e.getActionCommand().equals("Funtion DB")) {
			
		}
		if (e.getActionCommand().equals("Funtion DB Remove")) {
			
		}
		if (e.getActionCommand().equals("Term DB")) {
			TermDbMaker tdm = new TermDbMaker();
			tdm.createTermTable();		
		}
		if (e.getActionCommand().equals("Term DB Remove")) {
			TermDbMaker tdm = new TermDbMaker();
			tdm.removeTermTable();
		}
		if (e.getActionCommand().equals("SQL DB")) {
			SqlDbMaker sdm = new SqlDbMaker();
			sdm.createSqlTable();
		}
		if (e.getActionCommand().equals("SQL DB Remove")) {
			SqlDbMaker sdm = new SqlDbMaker();
			sdm.removeSqlTable();
		}
		////Function,Term,SQL 패널
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
		////컴파일 관련
		if (e.getActionCommand().equals("Compile")) {
			CompilePanel c1 = new CompilePanel();
			b1.setLabel("Close");
			b2.setVisible(false);
			cp = c1;
		}
		if (e.getActionCommand().equals("Close")) {
			cp.closeP();
			b1.setLabel("Compile");
			b2.setVisible(true);
		}
		if (e.getActionCommand().equals("Run")) {
			System.out.println(ta.getText());
		}

		if (e.getActionCommand().equals("Clear")) {
			ta.setText("");
		}
		//검색 관련
		if (e.getActionCommand().equals(name)) {
			c.select(name);
		}
	}

}