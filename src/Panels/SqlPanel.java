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

public class SqlPanel extends BasePanel {
	private Panel sqlP;
	
	public SqlPanel() {
		sqlP = new Panel();
		sqlP.setLayout(null);
		sqlP.setBackground(Color.green);
		sqlP.setBounds(10, 10, 680, 700);

		newSql();
		setSql();
		addSql();

		MainFrame.f.add(sqlP);
	}

	// �ʿ��Ѱ͵� ��ü ����
	private void newSql() {
		nameP = new Panel();
		lb = new Label("ccccccccccccc");
		c1 = new Choice();
		serchTf = new TextField();
		homeB = new Button("Home");
		optionB = new Button("Option");
		logoutB = new Button("Logout");
		font1 = new Font("����", Font.BOLD, 15);
	}

	// ��ġ ����
	private void setSql() {
		namePanel();
		setLabel();
		choice1();
		textField();
		homeButton();
		homeB.addActionListener(new ActButton(sqlP));
		optionButton();
		logoutButton();
	}

	// ��ο� �߰�
	private void addSql() {
		nameP.add(lb);
		sqlP.add(nameP);
		sqlP.add(c1);
		sqlP.add(serchTf);
		sqlP.add(homeB);
//		sqlP.add(optionB);
//		sqlP.add(logoutB);
	}

}
