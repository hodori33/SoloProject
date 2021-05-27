package Panels;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import Buttons.ActButton;
import Main.MainFrame;

public class ApiPanel extends BasePanel {
	private Panel apiP;
	private String[] str = { "aa", "bb", "cc", "dd", "ee" };
	

	public ApiPanel() {
		apiP = new Panel();
		apiP.setLayout(null);
		apiP.setBackground(Color.green);
		apiP.setBounds(10, 10, 680, 700);
		
		newApi();
		setApi();
		addApi();
		
		// 초이스 샘플
		for (int i = 0; i < str.length; i++) {
			c1.add(str[i]);
			c2.add(str[i]);
		}		
		MainFrame.f.add(apiP);
	}

	// 필요한것들 객체 생성
	private void newApi() {
		nameP = new Panel();
		lb = new Label("이 라벨이 추가가 안됩니다.");  //!!!!!!!!!!!!!!!!!
		c1 = new Choice();
		c2 = new Choice();
		serchTf = new TextField("검색어");
		homeB = new Button("Home");
		optionB = new Button("Option");
		logoutB = new Button("Logout");
		compileB = new Button("Compile");
		font1 = new Font("굴림", Font.BOLD, 15);

	}
	
	// 위치 세팅
	private void setApi() {
		namePanel();
		setLabel();	//	 라벨 세팅!!!!!!!!!!!!!!!!!!!!!
		choice1();
		choice2();
		homeButton();
		homeB.addActionListener(new ActButton(apiP));
		optionButton();
		logoutButton();
		compileButton();
		compileB.addActionListener(new ActButton(compileB, homeB));
		textField();
	}

	// 페널에 추가
	private void addApi() {
		nameP.add(lb);		//라벨 추가!!!!!!!!!!!!!
		apiP.add(nameP);
		apiP.add(c1);
		apiP.add(c2);
		apiP.add(serchTf);
		apiP.add(homeB);
//		apiP.add(optionB);
//		apiP.add(logoutB);
		apiP.add(compileB);

	}

}
