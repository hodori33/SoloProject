package Buttons;

import java.awt.Choice;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import DbMaker.MemberDAO;

public class ChoiceHandler implements ItemListener{
	private String[] aa = { "11", "22", "33", "44", "55" };
	private String[] bb = { "66", "77", "88", "99", "10" };
	private Choice c1, c2;
	private String cName, name;
	private TextArea ta;
	
	public ChoiceHandler(TextArea ta, String cName, Choice c1) {
		this.ta = ta;
		this.cName = cName;
		this.c1 = c1;
	}
	public ChoiceHandler(Choice c1, Choice c2) {
		 this.c1 = c1;
		 this.c2 = c2;
	}


	public void itemStateChanged(ItemEvent e) {
		
//		if(c1.getSelectedItem().equals("aa")) {
//			c2.removeAll();	
//			for(int i = 0; i < aa.length; i++) {
//				c2.add(aa[i]);
//			}
//		}
//		
//		if(c1.getSelectedItem().equals("bb")) {
//			c2.removeAll();	
//			for(int i = 0; i < aa.length; i++) {
//				c2.add(bb[i]);
//			}
//		}
		name = c1.getSelectedItem();
		MemberDAO dao = new MemberDAO();
		String str = dao.contents(cName, name);
		ta.setText(str);
	 }
	


	
}
