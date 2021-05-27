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

public class TermPanel extends BasePanel {
	private Panel termP;

	public TermPanel() {
		termP = new Panel();
		termP.setLayout(null);
		termP.setBackground(Color.green);
		termP.setBounds(10, 10, 680, 700);

		newApi();
		setApi();
		addApi();

		MainFrame.f.add(termP);
	}

	// �ʿ��Ѱ͵� ��ü ����
	private void newApi() {
		nameP = new Panel();
		lb = new Label("bbbbbbbbbbbbb");
		c1 = new Choice();
		serchTf = new TextField();
		homeB = new Button("Home");
		optionB = new Button("Option");
		logoutB = new Button("Logout");
		font1 = new Font("����", Font.BOLD, 15);
	}

	// ��ġ ����
	private void setApi() {
		namePanel();
		setLabel();
		choice1();
		textField();
		homeButton();
		homeB.addActionListener(new ActButton(termP));
		optionButton();
		logoutButton();
	}

	// ��ο� �߰�
	private void addApi() {
		nameP.add(lb);
		termP.add(nameP);
		termP.add(c1);
		termP.add(serchTf);
		termP.add(homeB);
//		termP.add(optionB);
//		termP.add(logoutB);
	}

}
