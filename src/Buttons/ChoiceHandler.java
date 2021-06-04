package Buttons;

import java.awt.Choice;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import DbMaker.MemberDAO;
import DbMaker.MemberVo;

public class ChoiceHandler implements ItemListener {
	private Choice c1, c2;
	private String table_name, name, str;
	private TextArea ta;
	private ArrayList<MemberVo> list;
	private MemberDAO dao;
	private boolean on_off = true;

	public ChoiceHandler() {
	}

	// term, sql 패널에서 초이스가 1개 일때 2번초이스
	public ChoiceHandler(TextArea ta, Choice c2, String table_name) {
		this.ta = ta;
		this.table_name = table_name;
		this.c2 = c2;
	}

	// function 패널에서 초이스가 2개 일때 1번초이스
	public ChoiceHandler(Choice c1, Choice c2, String className) {
		this.c1 = c1;
		this.c2 = c2;
		this.table_name = className;
	}

	// function 패널에서 초이스가 2개 일때 2번초이스
	public ChoiceHandler(TextArea ta, Choice c1, Choice c2, String table_name) {
		this.ta = ta;
		this.c1 = c1;
		this.c2 = c2;
		this.table_name = table_name;
		this.on_off = !on_off;
	}

	public void itemStateChanged(ItemEvent e) {
		dao = new MemberDAO();
		if (c1 != null) {
			if (on_off) {
				c2.removeAll();
				name = c1.getSelectedItem();
				list = dao.selectDB(name);
				for (int i = 0; i < list.size(); i++) {
					MemberVo data = (MemberVo) list.get(i);
					String temp = data.getName();
					c2.add(temp);
				}
			}
			if (!on_off) {
				name = c2.getSelectedItem();
				str = dao.contents(c1.getSelectedItem(), name);
				System.out.println(str);
				ta.setText(str);
			}

		} else {
			name = c2.getSelectedItem();
			System.out.println(name);
			str = dao.contents(table_name, name);
			System.out.println(str);
			ta.setText(str);
		}
	}
}
