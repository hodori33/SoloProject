package Login;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Create extends WindowAdapter {
	static Frame createF;
	public static TextField tfId, tfIdC, tfPw, tfRePw, tfPwC, tfEm, tfEmC;
	private Label lId, lPw, lRePw;
	private Panel pId, pPw, pRePw;
	private Button bOk, bCancle, bId, bPw;
	private Font font1;

	Create() {
		createF = new Frame();
		createF.setLayout(null);
		createF.setSize(400, 500);
		createF.setVisible(true);
		createF.setResizable(false);
		

		Toolkit tt = Toolkit.getDefaultToolkit();
		Dimension screenSize = tt.getScreenSize();
		createF.setLocation(screenSize.width / 2 - (400 / 2), screenSize.height / 2 - (500 / 2));
		createF.addWindowListener(this);
		createF.setBackground(Color.green);
		font1 = new Font("고딕", Font.BOLD, 15);

		// Id
		lId = new Label("Id");
		tfId = new TextField();
		tfIdC = new TextField();
		pId = new Panel();
		bId = new Button("중복 검사");

		lId.setFont(font1);
		lId.setAlignment(Label.CENTER);

		tfId.setBounds(190, 100, 100, 25);

		tfIdC.setBounds(300, 135, 70, 25);
		tfIdC.setEditable(false);

		pId.add(lId);
		pId.setBackground(Color.gray);
		pId.setBounds(80, 100, 100, 25);

		bId.setBounds(300, 100, 50, 25);

		// Pw
		lPw = new Label("Password");
		lRePw = new Label("재입력");
		tfPw = new TextField();
		tfRePw = new TextField();
		tfPwC = new TextField();
		pPw = new Panel();
		pRePw = new Panel();
		bPw = new Button("P/W검사");

		lPw.setFont(font1);
		lPw.setAlignment(Label.CENTER);

		lRePw.setFont(font1);
		lRePw.setAlignment(Label.CENTER);

		tfPw.setBounds(190, 170, 100, 25);
		tfPw.setEchoChar('*');

		tfRePw.setBounds(190, 205, 100, 25);
		tfRePw.setEchoChar('*');

		tfPwC.setBounds(300, 205, 70, 25);
		tfPwC.setEditable(false);

		pPw.add(lPw);
		pPw.setBackground(Color.gray);
		pPw.setBounds(80, 170, 100, 25);

		pRePw.add(lRePw);
		pRePw.setBackground(Color.gray);
		pRePw.setBounds(80, 205, 100, 25);

		bPw.setBounds(300, 170, 50, 25);

		// 생성과 취소버튼
		bOk = new Button("생성");
		bCancle = new Button("취소");

		bOk.setBounds(140, 400, 50, 25);
		bCancle.setBounds(210, 400, 50, 25);

		bOk.addActionListener(new LoginButton());
		bCancle.addActionListener(new LoginButton());
		bId.addActionListener(new LoginButton());
		bPw.addActionListener(new LoginButton());

		// Id
		createF.add(pId);
		createF.add(tfId);
		createF.add(bId);
		createF.add(tfIdC);
		// PW
		createF.add(pPw);
		createF.add(tfPw);
		createF.add(bPw);
		createF.add(tfRePw);
		createF.add(pRePw);
		createF.add(tfPwC);
		// E-mail
		//
		// ok 와 cancle 버튼
		createF.add(bOk);
		createF.add(bCancle);

	}

	public void windowClosing(WindowEvent e) {
		createF.dispose();
	}

}
