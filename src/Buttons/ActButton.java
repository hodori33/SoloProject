package Buttons;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Robot;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import DbMaker.FunctionDbMaker;
import DbMaker.MemberDAO;
import DbMaker.MemberVo;
import DbMaker.SqlDbMaker;
import DbMaker.TermDbMaker;
import Login.Login;
import Main.MainFrame;
import Panels.FunctionPanel;
import Panels.HomePanel;
import Panels.SqlPanel;
import Panels.TermPanel;
import Panels.UserPanel;

public class ActButton implements ActionListener {
	private Panel p1, p2;
	private UserPanel up;
	private Choice c1, c2;
	private TextArea ta;
	private Button b1;
	private Label lb1, lb2;
	private String cName, name;
	private ArrayList<MemberVo> list;

	public ActButton() {
	}

	// 홈에서의 패널 선택
	public ActButton(Panel p1) {
		this.p1 = p1;
	}

	// 검색결과버튼 초이스 하나일때
	public ActButton(String cName, String name, Choice c1, Panel p1, Panel p2, TextArea ta) {
		this.cName = cName;
		this.name = name;
		this.c1 = c1;
		this.p1 = p1;
		this.p2 = p2;
		this.ta = ta;
	}

	// 검색결과버튼 초이스 두개일때
	public ActButton(String cName, String name, Choice c1, Choice c2, Panel p1, Panel p2, TextArea ta) {
		this.cName = cName;
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
		this.p1 = p1;
		this.p2 = p2;
		this.ta = ta;
	}
	// 사용자 패널on/off
	public ActButton(Button b1) {
		this.b1 = b1;
	}
	// 사용자 패널에 검색 목록 버튼들.
	public ActButton(Button b1, Label lb1, Label lb2) {
		this.b1 = b1;
		this.lb1 = lb1;
		this.lb2 = lb2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//// 홈패널
		if (e.getActionCommand().equals("Java Funtion")) {
			p1.setVisible(false);
			new FunctionPanel();
		}

		if (e.getActionCommand().equals("Java Term")) {
			p1.setVisible(false);
			new TermPanel();
		}

		if (e.getActionCommand().equals("SQL")) {
			p1.setVisible(false);
			new SqlPanel();
		}
		if (e.getActionCommand().equals("Function DB")) {
			FunctionDbMaker fdm = new FunctionDbMaker();
			fdm.createFunctionTable();
		}
		if (e.getActionCommand().equals("Function DB Remove")) {
			FunctionDbMaker fdm = new FunctionDbMaker();
			fdm.removeTable();
		}
		if (e.getActionCommand().equals("Term DB")) {
			TermDbMaker tdm = new TermDbMaker();
			tdm.createTermTable();
		}
		if (e.getActionCommand().equals("Term DB Remove")) {
			TermDbMaker tdm = new TermDbMaker();
			tdm.removeTable();
		}
		if (e.getActionCommand().equals("SQL DB")) {
			SqlDbMaker sdm = new SqlDbMaker();
			sdm.createSqlTable();
		}
		if (e.getActionCommand().equals("SQL DB Remove")) {
			SqlDbMaker sdm = new SqlDbMaker();
			sdm.removeTable();
		}
		//// Function,Term,SQL 패널
		if (e.getActionCommand().equals("Home")) {
			p1.setVisible(false);
			MainFrame.f.setBounds(0, 0, 700, 700);
			Toolkit tt = Toolkit.getDefaultToolkit();
			Dimension screenSize = tt.getScreenSize();
			MainFrame.f.setLocation(screenSize.width / 2 - (700 / 2), screenSize.height / 2 - (700 / 2));
			new HomePanel();

		}
		if (e.getActionCommand().equals("검색기록")) {
			try {
				Robot robot = new Robot();
				robot.mouseMove(590, 850);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			b1.setLabel("닫기");
			MainFrame.f.setBounds(0, 0, 1000, 700);
			Toolkit tt = Toolkit.getDefaultToolkit();
			Dimension screenSize = tt.getScreenSize();
			MainFrame.f.setLocation(screenSize.width / 2 - (1000 / 2), screenSize.height / 2 - (700 / 2));
			UserPanel up = new UserPanel();
			this.up = up;
		}
		
		if (e.getActionCommand().equals("닫기")) {
			try {
				Robot robot = new Robot();
				robot.mouseMove(750, 850);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			b1.setLabel("검색기록");
			MainFrame.f.setBounds(0, 0, 700, 700);
			Toolkit tt = Toolkit.getDefaultToolkit();
			Dimension screenSize = tt.getScreenSize();
			MainFrame.f.setLocation(screenSize.width / 2 - (700 / 2), screenSize.height / 2 - (700 / 2));
			up.closePanel();
		}
		
		
		if (e.getActionCommand().equals("LogOut")) {
			MainFrame.f.dispose();
			new Login();
		}
		//// 컴파일 관련
		if (e.getActionCommand().equals("Compile")) {	
			try {
				Desktop.getDesktop().browse(new URI("https://www.compilejava.net/"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// 검색 관련
		if (e.getActionCommand().equals(name)) {

			if (c2 == null) {
				p1.setVisible(true);
				p2.setVisible(false);
				c1.select(name);
				MemberDAO dao = new MemberDAO();
				String str = dao.contents(cName, name);
				ta.setText(str);

			} else {
				p1.setVisible(true);
				p2.setVisible(false);
				c1.select(name);
				MemberDAO dao = new MemberDAO();
				list = dao.selectDB(name);
				for (int i = 0; i < list.size(); i++) {
					MemberVo data = (MemberVo) list.get(i);
					String temp = data.getTemp1();
					c2.add(temp);
				}
				c2.select(0);
				name = c2.getItem(0);
				System.out.println(name);
				String str = dao.contents(c1.getSelectedItem(), name);
				ta.setText(str);
			}

		}
		
		if (e.getActionCommand().equals("x")) {
			MemberDAO dao = new MemberDAO();
			dao.serch_List_Remove(lb1.getText());
			b1.setVisible(false);
			lb1.setVisible(false);
			lb2.setVisible(false);	
		}
		if (e.getActionCommand().equals("모두 지우기")) {
			MemberDAO dao = new MemberDAO();
			dao.serch_List_AllRemove();
			p1.removeAll();
		}
		if (e.getActionCommand().equals("새로고침")) {
			p1.setVisible(false);
			new UserPanel();
		}
		
	}
}