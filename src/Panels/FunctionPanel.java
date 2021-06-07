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

public class FunctionPanel extends BasePanel {
	private Panel functionP;
	private ArrayList<MemberVo> list;
	private final String className = "function";
	
	public FunctionPanel() {
		// Function 패널
		functionP = new Panel();
		functionP.setLayout(null);
		functionP.setBackground(Color.green);
		functionP.setBounds(10, 10, 680, 700);
		OnOff1 = true;
		OnOff2 = false;
		
		newFunction();
		setFunction();
		addFunction();

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
					b[i].addActionListener(new ActButton(className, b[i].getLabel(), c1, c2, contentsP, serchP, conTa));
					serchP.add(b[i]);
					b[i].setBounds(10, (i + 1) * 40, 70, 30);
				}
			}
		});

		MainFrame.f.add(functionP);
	}

	// 필요한 객체 생성
	private void newFunction() {
		nameP = new Panel();
		contentsP = new Panel();
		serchP = new Panel();
		homeB = new Button("Home");
//		optionB = new Button("Option");
		logoutB = new Button("LogOut");
		compileB = new Button("Compile");
		serchB = new Button("확인");
		closeB = new Button("검색 닫기");
		font1 = new Font("맑은 고딕", Font.CENTER_BASELINE, 15);
		font2 = new Font("고딕", Font.BOLD, 18);
		c1 = new Choice();
		c2 = new Choice();
		serchC = new Choice();
		serchTf = new TextField("검색어");
		conTa = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		lb = new Label(className.toUpperCase());
		dao = new MemberDAO();
	}
	
	// 객체들 세팅
	private void setFunction() {
		namePanel();
		contentsP();
		serchP();
		homeButton();
//		optionButton();
 		logoutButton();
		compileButton();
		serchB();
		closeB();
		choice1();
		choice2();
		serchC();
		serchTf();
		contentsTa();
		label();
		
		homeB.addActionListener(new ActButton(functionP));
		compileB.addActionListener(new ActButton());
		logoutB.addActionListener(new ActButton());
		c1.addItemListener(new ChoiceHandler(c1, c2, className));
		c2.addItemListener(new ChoiceHandler(conTa, c1, c2, className));
	}

	// 패널에 추가
	private void addFunction() {
		functionP.add(nameP);
		functionP.add(contentsP);
		functionP.add(serchP);
		functionP.add(homeB);
//		functionP.add(optionB);
		functionP.add(logoutB);
		functionP.add(compileB);
		functionP.add(serchB);
		functionP.add(closeB);
		functionP.add(c1);
		functionP.add(c2);
		functionP.add(serchC);
		functionP.add(serchTf);
		contentsP.add(conTa);
		nameP.add(lb);
	}
}
