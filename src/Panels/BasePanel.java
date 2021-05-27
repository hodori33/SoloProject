package Panels;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

abstract class BasePanel {

	protected Panel nameP;
	protected Button homeB, optionB, logoutB, compileB;
	protected Font font1;
	protected Choice c1, c2;
	protected TextField serchTf;
	protected Label lb;
	// 변수 세팅
	// 이름 페널
	protected void namePanel() {
		nameP.setLayout(null);
		nameP.setBounds(50, 50, 140, 40);
		nameP.setBackground(Color.yellow);
	}
	// 홈 버튼
	protected void homeButton() {
		homeB.setFont(font1);
		homeB.setBounds(30, 600, 60, 40);
	}
	// 옵션 버튼
	protected void optionButton() {
		optionB.setFont(font1);
		optionB.setBounds(100, 600, 60, 40);
	}
	// 로그아웃 버튼
	protected void logoutButton() {
		logoutB.setFont(font1);
		logoutB.setBounds(170, 600, 60, 40);
	}
	// 컴파일 버튼
	protected void compileButton() {
		compileB.setFont(font1);
		compileB.setBounds(240, 600, 60, 40);
	}
	// 초이스 1
	protected void choice1() {
		c1.setFont(font1);
		c1.setBounds(200, 50, 150, 30);
	}
	// 초이스 2
	protected void choice2() {
		c2.setFont(font1);
		c2.setBounds(360, 50, 150, 30);
	}
	// 검색창
	protected void textField() {
		serchTf.setFont(font1);
		serchTf.selectAll();
		serchTf.setBounds(520, 50, 100, 25);
	}
	//라벨 세팅
	protected void setLabel() {
		lb.setFont(font1);
		lb.setAlignment(Label.LEFT);
		lb.setBackground(Color.red);
		lb.setForeground(Color.white);
	}
}
