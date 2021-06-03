package Panels;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import DbMaker.MemberDAO;

abstract class BasePanel {

	protected Panel nameP, contentsP, serchP;
	protected Button homeB, optionB, logoutB, compileB, serchB, closeB, b[];
	protected Font font1, font2;
	protected Choice c1, c2, serchC;
	protected TextField serchTf;
	protected TextArea conTa;
	protected Label lb;
	protected MemberDAO dao;
	protected boolean OnOff1, OnOff2;
	
	// 이름 패널
	protected void namePanel() {
		nameP.setLayout(null);
		nameP.setBounds(20, 30, 140, 40);
		nameP.setBackground(Color.yellow);
	}

	// 내용 패널
	protected void contentsP() {
		contentsP.setLayout(null);
		contentsP.setBounds(10, 90, 660, 520);
		contentsP.setBackground(Color.yellow);
		contentsP.setVisible(OnOff1);
	}

	// 검색 패널
	protected void serchP() {
		serchP.setLayout(null);
		serchP.setBounds(10, 90, 660, 520);
		serchP.setBackground(Color.yellow);
		serchP.setVisible(OnOff2);
	}

	// 홈 버튼
	protected void homeButton() {
		homeB.setFont(font1);
		homeB.setBounds(30, 630, 60, 40);
	}

	// 옵션 버튼
	protected void optionButton() {
		optionB.setFont(font1);
		optionB.setBounds(100, 630, 60, 40);
	}

	// 로그아웃 버튼
	protected void logoutButton() {
		logoutB.setFont(font1);
		logoutB.setBounds(170, 630, 60, 40);
	}

	// 컴파일 버튼
	protected void compileButton() {
		compileB.setFont(font1);
		compileB.setBounds(240, 630, 60, 40);
	}

	// 검색 버튼
	protected void serchB() {
		serchB.setBounds(580, 60, 50, 25);
	}

	// 닫기 버튼
	protected void closeB() {
		closeB.setBounds(460, 60, 50, 25);
		closeB.setVisible(false);
	}

	// 초이스1
	protected void choice1() {
		c1.setFont(font1);
		c1.setBounds(200, 30, 150, 30);
	}

	// 초이스2
	protected void choice2() {
		c2.setFont(font1);
		c2.setBounds(360, 30, 150, 30);
	}

	// 검색 종류
	protected void serchC() {
		serchC.add("제목");
		serchC.add("내용");
		serchC.setBounds(520, 60, 50, 25);
	}

	// 검색창
	protected void serchTf() {
		serchTf.setFont(font1);
		serchTf.selectAll();
		serchTf.setBounds(520, 30, 100, 25);
	}

	// 내용textarea
	protected void contentsTa() {
		conTa.setFont(font2);
		conTa.setBounds(1, 1, 658, 518);
		conTa.setEditable(false);
	}

	// 라벨
	protected void label() {
		lb.setFont(font1);
		lb.setAlignment(Label.CENTER);
	}
	// 패널 교체
	protected void panelOnOff() {
		contentsP.setVisible(!OnOff1);
		serchP.setVisible(!OnOff2);
	}
}
