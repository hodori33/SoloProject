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
	private Panel userP, nameP, p1, p2;
	private Label nameLb, p1Lb;
	private Button b[];
	private Label lb[];
	private Button clearB;
	private Font font1, font2;
	private ArrayList<MemberVo> list;
	private MemberDAO dao;
	
	//userP	UserPanel
	//nameP	사용자아이디 패널
	//p1	환영인사 패널
	//p2	사용자 검색목록 패널
	//p3	누적 검색목록 패널
	
	public UserPanel(){
		userObject();
		objectSet();
		objectAdd();
		
		//목록조회후 버튼추가
		dao = new MemberDAO();
		list = dao.serch_List();
		if(list != null) {
			b = new Button[list.size()];
			lb = new Label[list.size()];
			for(int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				String name = data.getName();
				lb[i] = new Label(name);
				lb[i].setSize(100, 30);
				lb[i].setFont(font2);
				lb[i].setBounds(20, (i+1)*20, 100, 30);
				b[i] = new Button("x");
				b[i].setBounds(220, (i+1)*20, 20, 20);
				b[i].addActionListener(new ActButton(b[i], lb[i]));
				p2.add(lb[i]);
				p2.add(b[i]);
			}
		}
	}
	
	//객체 생성
	private void userObject() {
		userP = new Panel();
		nameP = new Panel();
		p1 = new Panel();
		p2 = new Panel();
		nameLb = new Label(MainFrame.f.getTitle());
		p1Lb = new Label("님 환영합니다.");
		clearB = new Button("모두 지우기");
		clearB.addActionListener(new ActButton(p2));
		font1 = new Font("맑은 고딕", Font.CENTER_BASELINE, 25);
		font2 = new Font("맑은 고딕", Font.CENTER_BASELINE, 15);
	}
	//객체들 세팅
	private void objectSet() {
		userP.setLayout(null);
		userP.setBackground(Color.gray);
		userP.setBounds(691, 0, 300, 700);
		nameP.setLayout(null);
		nameP.setBackground(Color.red);
		nameP.setBounds(40, 40, 220, 50);
		p1.setBackground(Color.green);
		p1.setBounds(40, 90, 220, 30);
		p2.setLayout(null);
		p2.setBackground(Color.green);
		p2.setBounds(20, 150, 260, 480);
		clearB.setBounds(115, 650, 70, 30);
		nameLb.setSize(210, 45);
		nameLb.setFont(font1);
		nameLb.setAlignment(Label.CENTER);
		p1Lb.setSize(210, 25);
		p1Lb.setFont(font2);
		p1Lb.setAlignment(Label.CENTER);
		
	}
	private void objectAdd() {
		MainFrame.f.add(userP);
		userP.add(nameP);
		userP.add(p1);
		userP.add(p2);
		userP.add(clearB);
		nameP.add(nameLb);
		p1.add(p1Lb);
	}
	public void closePanel() {
		userP.setVisible(false);
	}
}
