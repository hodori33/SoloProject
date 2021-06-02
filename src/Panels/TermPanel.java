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
		OnOff = true;
		
		newTerm();
		setTerm();
		addTerm();
		
		//db 조회로 c1목록 채우기	
		list = dao.selectDB(className);
		for (int i = 0; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String name = data.getName();
			c1.add(name);
		}
		panelOnOff();
		MainFrame.f.add(termP);
	}

	// 객체 생성
	private void newTerm() {
		nameP = new Panel();
		contentsP = new Panel();
		serchP = new Panel();
		homeB = new Button("Home");
//		optionB = new Button("Option");
//		logoutB = new Button("Logout");
		serchB = new Button("확인");
		closeB = new Button("검색 닫기");
		font1 = new Font("맑은 고딕", Font.CENTER_BASELINE, 15);
		font2 = new Font("고딕", Font.BOLD, 18);
		c1 = new Choice();
		serchC = new Choice();
		serchTf = new TextField();
		conTa = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		lb = new Label("bbbbbbbbbbbbb");
		dao = new MemberDAO();	
	}

	// 객체 설정
	private void setTerm() {
		namePanel();
		contentsP();
		serchP();
		homeButton();
//		optionButton();
// 		logoutButton();
		serchB();
		closeB();
		choice1();
		serchC();
		serchTf();
		contentsTa();
		label();
		
		homeB.addActionListener(new ActButton(termP));
		serchB.addActionListener(new ActButton(closeB, conTa, serchTf, serchC, className));
		closeB.addActionListener(new ActButton(contentsP, conTa));
		c1.addItemListener(new ChoiceHandler(conTa, className, c1));
	}

	// 패널에 추가
	private void addTerm() {
		termP.add(nameP);
		termP.add(contentsP);
		termP.add(serchP);
		termP.add(homeB);
//		termP.add(optionB);
//		termP.add(logoutB);
		termP.add(serchB);
		termP.add(closeB);
		termP.add(c1);
		termP.add(serchC);
		termP.add(serchTf);
		contentsP.add(conTa);
		nameP.add(lb);
	}
}
