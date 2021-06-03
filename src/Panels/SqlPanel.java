package Panels;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		// Sql 패널
		sqlP = new Panel();
		sqlP.setLayout(null);
		sqlP.setBackground(Color.green);
		sqlP.setBounds(10, 10, 680, 700);
		OnOff1 = true;
		OnOff2 = false;
		
		newSql();
		setSql();
		addSql();
		
		// db 조회로 c1목록 채우기
		list = dao.selectDB(className);
		for (int i = 0; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String name = data.getName();
			c1.add(name);
		}
		
		serchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelOnOff();
				
				list = dao.serchDB(className, serchC.getSelectedItem(), serchTf.getText());
				b = new Button[list.size()];
				for (int i = 0; i < list.size(); i++) {
					MemberVo data = (MemberVo) list.get(i);
					String name = data.getName();
					b[i] = new Button(name);					
					System.out.println(b[i].getLabel());
					b[i].addActionListener(new ActButton(b[i].getLabel(), c1));
					serchP.add(b[i]);
					b[i].setBounds(10, (i + 1) * 40, 70, 30);
				}
			}
		});

		MainFrame.f.add(sqlP);
	}

	// 객체 생성
	private void newSql() {
		nameP = new Panel();
		contentsP = new Panel();
		serchP = new Panel();
		homeB = new Button("Home");
//		optionB = new Button("Option");
//		logoutB = new Button("Logout");
//		compileB = new Button("Compile");
		serchB = new Button("확인");
		closeB = new Button("검색 닫기");
		font1 = new Font("맑은 고딕", Font.CENTER_BASELINE, 15);
		font2 = new Font("고딕", Font.BOLD, 18);
		c1 = new Choice();
		serchC = new Choice();
		serchTf = new TextField("검색어");
		conTa = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		lb = new Label("ccccccccccccc");
		dao = new MemberDAO();
	}

	// 객체 설정
	private void setSql() {
		namePanel();
		contentsP();
		serchP();
		homeButton();
//		optionButton();
// 		logoutButton();
//		compileButton();
		serchB();
		closeB();
		choice1();
		serchC();
		serchTf();
		contentsTa();
		label();
		
		homeB.addActionListener(new ActButton(sqlP));
//		serchB.addActionListener(new ActButton(closeB, conTa, serchTf, serchC, className));
//		closeB.addActionListener(new ActButton(contentsP, conTa));
		c1.addItemListener(new ChoiceHandler(conTa, className, c1));		
	}

	// 패널에 추가
	private void addSql() {
		sqlP.add(nameP);
		sqlP.add(contentsP);
		sqlP.add(serchP);
		sqlP.add(homeB);
//		sqlP.add(optionB);
//		sqlP.add(logoutB);
//		sqlP.add(compileB);
		sqlP.add(serchB);
		sqlP.add(closeB);
		sqlP.add(c1);
		sqlP.add(serchC);
		sqlP.add(serchTf);
		contentsP.add(conTa);
		nameP.add(lb);
	}
}
