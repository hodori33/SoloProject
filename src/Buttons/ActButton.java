package Buttons;

import java.awt.Choice;
import java.awt.Desktop;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import java.net.*;

import DbMaker.*;
import Login.Login;
import Main.MainFrame;
import Panels.FunctionPanel;
import Panels.HomePanel;
import Panels.SqlPanel;
import Panels.TermPanel;

public class ActButton implements ActionListener {
	private Panel p1, p2;
	private Choice c1, c2;
	private TextArea ta;
	private String cName, name;
	private ArrayList<MemberVo> list;

	public ActButton() {
	}

	// 홈에서의 패널 선택
	public ActButton(Panel p1) {
		this.p1 = p1;
	}

	// 검색결과버튼
	public ActButton(String cName, String name, Choice c1, Panel p1, Panel p2, TextArea ta) {
		this.cName = cName;
		this.name = name;
		this.c1 = c1;
		this.p1 = p1;
		this.p2 = p2;
		this.ta = ta;
	}

	// 검색결과버튼
	public ActButton(String cName, String name, Choice c1, Choice c2, Panel p1, Panel p2, TextArea ta) {
		this.cName = cName;
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
		this.p1 = p1;
		this.p2 = p2;
		this.ta = ta;
	}

	// 컴파일 기능
	public ActButton(TextArea ta) {
		this.ta = ta;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//// 홈패널
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
		//// Function,Term,SQL 패널
		if (e.getActionCommand().equals("Home")) {
			p1.setVisible(false);
			new HomePanel();
		}
		if (e.getActionCommand().equals("Option")) {
			System.out.println("2");
		}
		if (e.getActionCommand().equals("LogOut")) {
			System.out.println("2");
			MainFrame.f.dispose();
			new Login();
		}
		//// 컴파일 관련
		if (e.getActionCommand().equals("Compile")) {	
			try {
				Desktop.getDesktop().browse(new URI("https://www.compilejava.net/"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// 검색 관련
		if (e.getActionCommand().equals(name)) {

			if (c2 == null) {
				p1.setVisible(true);
				p2.setVisible(false);
				c1.select(name);
				MemberDAO dao = new MemberDAO();
				String str = dao.contents(cName, name);
				ta.setText(str);

			} else {
				p1.setVisible(true);
				p2.setVisible(false);
				c1.select(name);
				MemberDAO dao = new MemberDAO();
				list = dao.selectDB(name);
				for (int i = 0; i < list.size(); i++) {
					MemberVo data = (MemberVo) list.get(i);
					String temp = data.getName();
					c2.add(temp);
				}
				c2.select(0);
				name = c2.getItem(0);
				System.out.println(name);
				String str = dao.contents(c1.getSelectedItem(), name);
				ta.setText(str);
			}

		}
	}
}