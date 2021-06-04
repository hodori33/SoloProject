package Buttons;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DbMaker.*;
import EtcPanels.CompilePanel;
import Panels.FunctionPanel;
import Panels.HomePanel;
import Panels.SqlPanel;
import Panels.TermPanel;

public class ActButton implements ActionListener {
	private Panel p1, p2;
	private Button b1, b2;
	private Choice c;
	private TextField tf;
	private TextArea ta;
	private CompilePanel cp;
	private String cName, name;
	
	public ActButton() {
	}
	//홈에서의 패널 선택
	public ActButton(Panel p1) {
		this.p1 = p1;
	}
	//검색결과버튼
	public ActButton(String cName, String name, Choice c, Panel p1, Panel p2, TextArea ta) {
		this.cName = cName;
		this.name = name;
		this.c = c;
		this.p1 = p1;
		this.p2 = p2;
		this.ta = ta;
		
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
			p1.setVisible(false);
			new FunctionPanel();
		}

		if (e.getActionCommand().equals("Java Term")) {
			p1.setVisible(false);
			new TermPanel();
		}

		if (e.getActionCommand().equals("SQL")) {
			p1.setVisible(false);
			new SqlPanel();
		}
		if (e.getActionCommand().equals("Function DB")) {
			FunctionDbMaker fdm = new FunctionDbMaker();
			fdm.createFunctionTable();
		}
		if (e.getActionCommand().equals("Function DB Remove")) {
			FunctionDbMaker fdm = new FunctionDbMaker();
			fdm.removeTable();
		}
		if (e.getActionCommand().equals("Term DB")) {
			TermDbMaker tdm = new TermDbMaker();
			tdm.createTermTable();		
		}
		if (e.getActionCommand().equals("Term DB Remove")) {
			TermDbMaker tdm = new TermDbMaker();
			tdm.removeTable();
		}
		if (e.getActionCommand().equals("SQL DB")) {
			SqlDbMaker sdm = new SqlDbMaker();
			sdm.createSqlTable();
		}
		if (e.getActionCommand().equals("SQL DB Remove")) {
			SqlDbMaker sdm = new SqlDbMaker();
			sdm.removeTable();
		}
		////Function,Term,SQL 패널
		if (e.getActionCommand().equals("Home")) {
			p1.setVisible(false);
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
			ta.setText("public class Test{\n\tpublic static void test(String[] args) {\n\t //내용을 입력하세요.\n\t}\n}");
		}
		//검색 관련
		if (e.getActionCommand().equals(name)) {
			p1.setVisible(true);
			p2.setVisible(false);
			c.select(name);
			name = c.getSelectedItem();
			MemberDAO dao = new MemberDAO();
			String str = dao.contents(cName, name);
			ta.setText(str);
		}
	}

}