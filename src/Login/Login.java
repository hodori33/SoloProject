package Login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import DbMaker.MemberDAO;
import DbMaker.MemberVo;
import Main.MainFrame;
public class Login extends WindowAdapter {
	private Frame f;
	private TextField tf1, tf2, tf3;
	private Panel p1, p2;
	private Label l1, l2;
	private Button b1, b2;
	private Font font1;
	ArrayList<MemberVo> list;

	public Login() {
		MemberDAO dao = new MemberDAO();
		f = new Frame();
		f.setLayout(null);
		f.setSize(400, 600);

		Toolkit tt = Toolkit.getDefaultToolkit();
		Dimension screenSize = tt.getScreenSize();
		f.setLocation(screenSize.width / 2 - (400 / 2), screenSize.height / 2 - (600 / 2));
		f.addWindowListener(this);
		f.setBackground(Color.green);
		font1 = new Font("고딕", Font.BOLD, 15);

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
						String id = data.getId();
						String password = data.getPassword();
						System.out.println(id + " : " + password);
						if (id.equals(tf1.getText()) && password.equals(tf2.getText())) {
							tf3.setText("로그인 성공");
							f.dispose();
							new MainFrame();
						} else {
							tf3.setText("로그인 실패");
						}

					}
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Create();
				
			}
		});

		f.add(tf3);
		f.add(p1);
		f.add(p2);
		f.add(tf1);
		f.add(tf2);
		f.add(b1);
		f.add(b2);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

}