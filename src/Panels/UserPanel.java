package Panels;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;

import Buttons.ActButton;
import DbMaker.MemberDAO;
import DbMaker.MemberVo;
import Main.MainFrame;

public class UserPanel {
	private Panel userP, nameP, p1, p2, p3;
	private Label nameLb, p1Lb;
	private Button b[];
	private Label wordLb[], dateLb[], countLb[];
	private Button clearB, reFlashB;
	private Font font1, font2;
	private ArrayList<MemberVo> list;
	private MemberDAO dao;

	// userP UserPanel
	// nameP 사용자아이디 패널
	// p1 환영인사 패널
	// p2 사용자 검색목록 패널
	// p3 누적 검색목록 패널

	public UserPanel() {
		userObject();
		objectSet();
		objectAdd();

		// 목록조회후 버튼추가
		dao = new MemberDAO();
		list = dao.search_List();
		if (list != null) {
			b = new Button[list.size()];
			wordLb = new Label[list.size()];
			dateLb = new Label[list.size()];
			int j = 1;
			for (int i = 0; i < list.size(); i++) {
				// 7개 까지만 출력.
				if (i > 6) {
					break;
				}
				MemberVo data = (MemberVo) list.get(i);
				wordLb[i] = new Label(data.getTemp1());
				wordLb[i].setSize(100, 30);
				wordLb[i].setFont(font2);
				wordLb[i].setBounds(20, (i + j) * 20, 100, 20);
				dateLb[i] = new Label(data.getTemp2());
				dateLb[i].setSize(100, 30);
				dateLb[i].setFont(font2);
				dateLb[i].setBounds(20, (i + j + 1) * 20, 220, 20);
				b[i] = new Button("x");
				b[i].setBounds(220, (i + j) * 20, 20, 20);
				b[i].addActionListener(new ActButton(b[i], wordLb[i], dateLb[i]));
				p2.add(dateLb[i]);
				p2.add(wordLb[i]);
				p2.add(b[i]);
				j += 2;
			}

			list = dao.search_Count();
			System.out.println(list.size());
			countLb = new Label[list.size()];
			for (int i = 0; i < list.size(); i++) {
				if (i > 2) {
					break;
				}
				MemberVo data = (MemberVo) list.get(i);
				countLb[i] = new Label(i + 1 + ". " + data.getTemp1());
				countLb[i].setSize(200, 30);
				countLb[i].setBounds(10, (i)*20, 200, 25);
				countLb[i].setFont(font2);
				p3.add(countLb[i]);
			}

		}
	}

	// 객체 생성
	private void userObject() {
		userP = new Panel();
		nameP = new Panel();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		nameLb = new Label(MainFrame.f.getTitle());
		p1Lb = new Label("님 환영합니다.");
		clearB = new Button("모두 지우기");
		clearB.addActionListener(new ActButton(p2));
		reFlashB = new Button("새로고침");
		reFlashB.addActionListener(new ActButton(userP));
		font1 = new Font("맑은 고딕", Font.CENTER_BASELINE, 25);
		font2 = new Font("맑은 고딕", Font.CENTER_BASELINE, 15);
		list = new ArrayList<MemberVo>();
	}

	// 객체들 세팅
	private void objectSet() {
		userP.setLayout(null);
		userP.setBackground(Color.gray);
		userP.setBounds(691, 0, 300, 700);
		nameP.setLayout(null);
		nameP.setBackground(Color.red);
		nameP.setBounds(40, 40, 220, 40);
		p1.setBackground(Color.green);
		p1.setBounds(40, 80, 220, 30);
		p1.setLayout(null);
		p2.setLayout(null);
		p2.setBackground(Color.green);
		p2.setBounds(10, 120, 280, 510);
		p3.setBackground(Color.yellow);
		p3.setLayout(null);
		p3.setBounds(10, 430, 260, 70);
		clearB.setBounds(170, 650, 70, 30);
		reFlashB.setBounds(70, 650, 70, 30);
		nameLb.setSize(210, 45);
		nameLb.setFont(font1);
		nameLb.setAlignment(Label.CENTER);
		p1Lb.setSize(210, 25);
		p1Lb.setFont(font2);
		p1Lb.setAlignment(Label.CENTER);

	}

	// 페널 또는 프레임에 추가
	private void objectAdd() {
		MainFrame.f.add(userP);
		userP.add(nameP);
		userP.add(p1);
		userP.add(p2);
		p2.add(p3);
		userP.add(clearB);
		userP.add(reFlashB);
		nameP.add(nameLb);
		p1.add(p1Lb);
	}

	// 현재 페널 닫기
	public void closePanel() {
		userP.setVisible(false);
	}
}
