package EtcPanels;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.ArrayList;

import Buttons.ActButton;
import DbMaker.MemberDAO;
import DbMaker.MemberVo;
import Main.MainFrame;
public class SerchPanel {
	private MemberDAO dao;
	private ArrayList<MemberVo> list;
	private String buttonName;
	private Button b[];
	private Panel p;

	public SerchPanel(TextArea ta, TextField tf, Choice c, String cName) {
		p = new Panel();
		p.setLayout(null);
		p.setBounds(10, 10, 680, 700);
		p.setBackground(Color.black);
		dao = new MemberDAO();
		list = dao.serchDB(cName, c.getSelectedItem(), tf.getText());
		b = new Button[list.size()];
		for (int i = 0; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String name = data.getName();
			b[i] = new Button(name);
			b[i].addActionListener(new ActButton(b[i].getName(), c));

			p.add(b[i]);
			MainFrame.f.add(p);
			b[i].setBounds(10, (i + 1) * 40, 70, 30);
		}

	}

	public void closeP() {
		p.setVisible(false);
	}

}