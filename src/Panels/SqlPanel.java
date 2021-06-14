package Panels;

import java.awt.*;
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
	private final String className = "sql";

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
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				String name = data.getTemp1();
				c2.add(name);
			}
		} else {
			conTa.setText("DB가 없습니다.");
		}

		serchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelOnOff();
				serchP.removeAll();
				list = dao.serchDB(className, serchTf.getText());
				b = new Button[list.size()];
				for (int i = 0; i < list.size(); i++) {
					MemberVo data = (MemberVo) list.get(i);
					String name = data.getTemp1();
					b[i] = new Button(name);
					System.out.println(b[i].getLabel());
					b[i].addActionListener(new ActButton(className, b[i].getLabel(), c2, contentsP, serchP, conTa));
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
		userB = new Button("검색기록");
		logoutB = new Button("LogOut");
		compileB = new Button("Compile");
		serchB = new Button("확인");
		closeB = new Button("검색 닫기");
		font1 = new Font("맑은 고딕", Font.BOLD, 15);
		font2 = new Font("고딕", Font.BOLD, 20);
		c2 = new Choice();
		serchC = new Choice();
		serchTf = new TextField("검색어");
		conTa = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		lb = new Label(className.toUpperCase());
		dao = new MemberDAO();
		list = new ArrayList<MemberVo>();
	}

	// 객체 설정
	private void setSql() {
		namePanel();
		contentsP();
		serchP();
		homeButton();
		userButton();
		logoutButton();
		compileButton();
		serchB();
		closeB();
		choice2();
		serchC();
		serchTf();
		contentsTa();
		label();

		homeB.addActionListener(new ActButton(sqlP));
		userB.addActionListener(new ActButton(userB));
		logoutB.addActionListener(new ActButton());
		compileB.addActionListener(new ActButton());
		c2.addItemListener(new ChoiceHandler(conTa, serchP, contentsP, c2, className));
	}

	// 패널에 추가
	private void addSql() {
		nameP.add(lb);
		sqlP.add(nameP);
		sqlP.add(contentsP);
		sqlP.add(serchP);
		sqlP.add(homeB);
		sqlP.add(userB);
		sqlP.add(logoutB);
		sqlP.add(compileB);
		sqlP.add(serchB);
		sqlP.add(closeB);
		sqlP.add(c2);
		sqlP.add(serchC);
		sqlP.add(serchTf);
		contentsP.add(conTa);

	}
}
