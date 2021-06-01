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

public class TermPanel extends BasePanel {
	private Panel termP;
	private ArrayList<MemberVo> list;
	private final String className = "Term";
	public TermPanel() {
		termP = new Panel();
		termP.setLayout(null);
		termP.setBackground(Color.green);
		termP.setBounds(10, 10, 680, 700);

		newApi();
		setApi();
		addApi();
		
		MemberDAO dao = new  MemberDAO();
		list = dao.selectDB(className);
		for(int i = 0 ; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String name = data.getName();
			
			c1.add(name);
		}

		MainFrame.f.add(termP);
	}

	// 객체 생성
	private void newApi() {
		nameP = new Panel();
		contentsP = new Panel();
		conTa = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		lb = new Label("bbbbbbbbbbbbb");
		c1 = new Choice();
		serchTf = new TextField();
		homeB = new Button("Home");
		optionB = new Button("Option");
		logoutB = new Button("Logout");
		font1 = new Font("함초롱바탕", Font.BOLD, 15);
		font2 = new Font("고딕", Font.BOLD, 18);
	}

	// 객체 설정
	private void setApi() {
		namePanel();
		contentsP();
		textarea();
		label();
		choice1();
		c1.addItemListener(new ChoiceHandler(conTa, className, c1));
		textField();
		homeButton();
		homeB.addActionListener(new ActButton(termP));
		optionButton();
		logoutButton();
	}

	// 패널에 추가
	private void addApi() {
		nameP.add(lb);
		contentsP.add(conTa);
		termP.add(nameP);
		termP.add(contentsP);
		termP.add(c1);
		termP.add(serchTf);
		termP.add(homeB);
//		termP.add(optionB);
//		termP.add(logoutB);
	}

}
