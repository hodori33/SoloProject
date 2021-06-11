package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import DbMaker.MemberDAO;
import DbMaker.MemberVo;
import Main.MainFrame;

public class Login extends WindowAdapter {
	private Frame loginF;
	private TextField tf1, tf2, tf3;
	private Panel p1, p2;
	private Label l1, l2;
	private Button b1, b2, dbB, redbB;
	private Font font1;
	ArrayList<MemberVo> list;

	public Login() {
		MemberDAO dao = new MemberDAO();
		loginF = new Frame();
		loginF.setLayout(null);
		loginF.setSize(400, 600);

		Toolkit tt = Toolkit.getDefaultToolkit();
		Dimension screenSize = tt.getScreenSize();
		loginF.setLocation(screenSize.width / 2 - (400 / 2), screenSize.height / 2 - (600 / 2));
		loginF.addWindowListener(this);
		loginF.setBackground(Color.green);
		font1 = new Font("고딕", Font.CENTER_BASELINE, 15);

		tf1 = new TextField();
		p1 = new Panel();
		l1 = new Label("ID");

		tf1.setBounds(190, 420, 100, 25);
		tf1.setFont(font1);
		tf1.setCaretPosition(25);
		p1.setBackground(Color.white);
		p1.setBounds(115, 420, 70, 25);
		l1.setAlignment(Label.CENTER);
		l1.setFont(font1);
		p1.add(l1);

		tf2 = new TextField();
		p2 = new Panel();
		l2 = new Label("Password");

		tf2.setBounds(190, 450, 100, 25);
		tf2.setFont(font1);
		tf2.setEchoChar('*');
		p2.setBackground(Color.white);
		p2.setBounds(115, 450, 70, 25);
		l2.setAlignment(Label.CENTER);
		l2.setFont(font1);
		p2.add(l2);

		tf3 = new TextField();
		tf3.setBounds(150, 530, 100, 25);
		tf3.setEditable(false);

		b1 = new Button("Login");
		b1.setBounds(210, 490, 50, 25);
		b2 = new Button("Create");
		b2.setBounds(125, 490, 50, 25);
		b2.addActionListener(new LoginButton());

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf3.setText("");
				if (tf1.getText().equals("")) {
					tf3.setText("ID를 입력하세요");
				} else if (tf2.getText().equals("")) {
					tf3.setText("Password를 입력하세요");
				} else {
					list = dao.list(tf1.getText());
					for (int i = 0; i < list.size(); i++) {
						MemberVo data = (MemberVo) list.get(i);
						String id = data.getTemp1();
						String password = data.getTemp2();
						if (id.toLowerCase().equals(tf1.getText().toLowerCase()) && password.equals(tf2.getText())) {
							tf3.setText("로그인 성공");
							loginF.dispose();
							new MainFrame(tf1.getText());
						} else {
							tf3.setText("로그인 실패");
						}

					}
				}
			}
		});
		dbB = new Button("DB생성");
		dbB.setBounds(20, 40, 50, 30);
		dbB.addActionListener(new LoginButton());

		redbB = new Button("DB삭제");
		redbB.setBounds(80, 40, 50, 30);
		redbB.addActionListener(new LoginButton());

		loginF.add(tf3);
		loginF.add(p1);
		loginF.add(p2);
		loginF.add(tf1);
		loginF.add(tf2);
		loginF.add(b1);
		loginF.add(b2);
		loginF.add(dbB);
		loginF.add(redbB);
		loginF.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

}
