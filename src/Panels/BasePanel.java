package Panels;

import java.awt.*;
import DbMaker.MemberDAO;

abstract class BasePanel {

	protected Panel nameP, contentsP, searchP;
	protected Button homeB, userB, logoutB, compileB, searchB, closeB, b[];
	protected Font font1, font2;
	protected Choice c1, c2, searchC;
	protected TextField searchTf;
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
	protected void searchP() {
		searchP.setLayout(null);
		searchP.setBounds(10, 90, 660, 520);
		searchP.setBackground(Color.yellow);
		searchP.setVisible(OnOff2);
	}

	// 홈 버튼
	protected void homeButton() {
		homeB.setFont(font1);
		homeB.setBounds(30, 630, 60, 40);
	}

	// 옵션 버튼
	protected void userButton() {
		userB.setFont(font1);
		userB.setBounds(100, 630, 60, 40);
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
	protected void searchB() {
		searchB.setBounds(580, 60, 50, 25);
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
	protected void searchC() {
		searchC.add("제목");
		searchC.setBounds(520, 60, 50, 25);
	}

	// 검색창
	protected void searchTf() {
		searchTf.setFont(font1);
		searchTf.selectAll();
		searchTf.setBounds(520, 30, 100, 25);
	}

	// 내용textarea
	protected void contentsTa() {
		conTa.setFont(font1);
		conTa.setBounds(1, 1, 658, 518);
		conTa.setEditable(false);
	}

	// 라벨
	protected void label() {
		lb.setSize(140, 40);
		lb.setFont(font2);
		lb.setAlignment(Label.CENTER);
	}

	// 패널 교체
	protected void panelOnOff() {
		contentsP.setVisible(!OnOff1);
		searchP.setVisible(!OnOff2);
	}
}
