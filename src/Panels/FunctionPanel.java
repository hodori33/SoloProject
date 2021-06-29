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
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				String name = data.getTemp1();
				c1.add(name);
			}
		} else {
			conTa.setText("DB가 없습니다.");
		}
	
		// 검색 버튼을 눌렀을때 패널 전환하고 검색 내용 출력
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelOnOff();
				searchP.removeAll();
				list = dao.searchDB(className, searchTf.getText());
				b = new Button[list.size()];
				for (int i = 0; i < list.size(); i++) {
					MemberVo data = (MemberVo) list.get(i);
					String name = data.getTemp1();
					b[i] = new Button(name);
					System.out.println(b[i].getLabel());
					b[i].addActionListener(new ActButton(className, b[i].getLabel(), c1, c2, contentsP, searchP, conTa));
					searchP.add(b[i]);
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
		searchP = new Panel();
		homeB = new Button("Home");
		userB = new Button("검색기록");
		logoutB = new Button("LogOut");
		compileB = new Button("Compile");
		searchB = new Button("확인");
		closeB = new Button("검색 닫기"); // 안쓰는 버튼
		font1 = new Font("맑은 고딕", Font.BOLD, 15);
		font2 = new Font("고딕", Font.BOLD, 20);
		c1 = new Choice();
		c2 = new Choice();
		searchC = new Choice();
		searchTf = new TextField("검색어");
		conTa = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		lb = new Label(className.toUpperCase());
		dao = new MemberDAO();
		list = new ArrayList<MemberVo>();
	}

	// 객체들 세팅
	private void setFunction() {
		namePanel();
		contentsP();
		searchP();
		homeButton();
		userButton();
		logoutButton();
		compileButton();
		searchB();
		closeB();
		choice1();
		choice2();
		searchC();
		searchTf();
		contentsTa();
		label();

		homeB.addActionListener(new ActButton(functionP));
		userB.addActionListener(new ActButton(userB));
		logoutB.addActionListener(new ActButton());
		compileB.addActionListener(new ActButton());

		c1.addItemListener(new ChoiceHandler(c1, c2, className));
		c2.addItemListener(new ChoiceHandler(conTa, searchP, contentsP, c1, c2, className));
	}

	// 패널에 추가
	private void addFunction() {
		functionP.add(nameP);
		functionP.add(contentsP);
		functionP.add(searchP);
		functionP.add(homeB);
		functionP.add(userB);
		functionP.add(logoutB);
		functionP.add(compileB);
		functionP.add(searchB);
		functionP.add(closeB);
		functionP.add(c1);
		functionP.add(c2);
		functionP.add(searchC);
		functionP.add(searchTf);
		contentsP.add(conTa);
		nameP.add(lb);
	}
}
