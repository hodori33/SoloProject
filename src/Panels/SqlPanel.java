package Panels;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.ArrayList;

import Buttons.ActButton;
import Buttons.ChoiceHandler;
import DbMaker.MemberDAO;
import DbMaker.MemberVo;
import Main.MainFrame;

public class SqlPanel extends BasePanel {
	private Panel sqlP;
	private ArrayList<MemberVo> list;
	private final String className = "Sql";
	
	public SqlPanel() {
		sqlP = new Panel();
		sqlP.setLayout(null);
		sqlP.setBackground(Color.green);
		sqlP.setBounds(10, 10, 680, 700);

		newSql();
		setSql();
		addSql();
		
		
		MemberDAO dao = new  MemberDAO();
		list = dao.selectDB(className);
		for(int i = 0 ; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String name = data.getName();
			c1.add(name);
		}
		MainFrame.f.add(sqlP);
	}

	// 객체 생성
	private void newSql() {
		nameP = new Panel();
		contentsP = new Panel();
		conTa = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		lb = new Label("ccccccccccccc");
		c1 = new Choice();
		serchTf = new TextField();
		homeB = new Button("Home");
		optionB = new Button("Option");
		logoutB = new Button("Logout");
		font1 = new Font(null, Font.BOLD, 15);
		font2 = new Font("고딕", Font.BOLD, 18);
	}

	// 객체 설정
	private void setSql() {
		namePanel();
		contentsP();
		textarea();
		label();
		choice1();
		c1.addItemListener(new ChoiceHandler(conTa, className, c1));
		textField();
		homeButton();
		homeB.addActionListener(new ActButton(sqlP));
		optionButton();
		logoutButton();
	}

	// 패널에 추가
	private void addSql() {
		nameP.add(lb);
		contentsP.add(conTa);
		sqlP.add(nameP);
		sqlP.add(contentsP);
		sqlP.add(c1);
		sqlP.add(serchTf);
		sqlP.add(homeB);
//		sqlP.add(optionB);
//		sqlP.add(logoutB);
	}

}
