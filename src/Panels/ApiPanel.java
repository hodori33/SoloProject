package Panels;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import Buttons.ActButton;
import Buttons.ChoiceHandler;
import Main.MainFrame;

public class ApiPanel extends BasePanel {
	private Panel apiP;
	private String[] str = { "aa", "bb"};
	

	public ApiPanel() {
		apiP = new Panel();
		apiP.setLayout(null);
		apiP.setBackground(Color.green);
		apiP.setBounds(10, 10, 680, 700);
		
		newApi();
		setApi();
		addApi();
		
	//	conTa.setText("");
		
		// 초이스 샘플
		for (int i = 0; i < str.length; i++) {
			c1.add(str[i]);
		}
		// 1번 초이스에 넣을 내용을 db에서 가져와서 배열에 저장해야됨
		// 1번초이스 선택 - 배열에 들어있는 String 을 db table 에서 검색
		// 그 테이블을 2번 초이스에 추가 시키기 마찬가지로 배열로?
		// 2번 초이스 선택 - 배열에 들어있는 String을 db table검색
		// 그 내용을 textarea에 출력.

		MainFrame.f.add(apiP);
	}

	// 필요한 객체 생성
	private void newApi() {
		nameP = new Panel();
		contentsP = new Panel();
		conTa = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		lb = new Label("abcde");  //라벨 수정 필요
		c1 = new Choice();
		c2 = new Choice();
		serchTf = new TextField("검색창");
		homeB = new Button("Home");
		optionB = new Button("Option");
		logoutB = new Button("Logout");
		compileB = new Button("Compile");
		font1 = new Font("궁서", Font.BOLD, 10);
		font2 = new Font("고딕", Font.BOLD, 18);

	}
	
	// 객체들 세팅
	private void setApi() {
		namePanel();
		contentsP();
		textarea();
		label();	//라벨 수정 필요
		choice1();
		choice2();
		c1.addItemListener(new ChoiceHandler(c1, c2));
		homeButton();
		homeB.addActionListener(new ActButton(apiP));
		optionButton();
		logoutButton();
		compileButton();
		compileB.addActionListener(new ActButton(compileB, homeB));
		textField();
	}

	// 패널에 추가
	private void addApi() {
		nameP.add(lb);	//라벨 수정 필요
		contentsP.add(conTa);
		apiP.add(nameP);
		apiP.add(contentsP);
		apiP.add(c1);
		apiP.add(c2);
		apiP.add(serchTf);
		apiP.add(homeB);
//		apiP.add(optionB);
//		apiP.add(logoutB);
		apiP.add(compileB);
		

	}

}
