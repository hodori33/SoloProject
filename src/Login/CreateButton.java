package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DbMaker.MemberDAO;
import DbMaker.MemberVo;

public class CreateButton implements ActionListener {
	ArrayList<MemberVo> list;
	@Override
	public void actionPerformed(ActionEvent e) {
		MemberDAO dao = new MemberDAO();

		if (e.getActionCommand().equals("중복 검사")) {
			if (dao.idCheck(Create.tfId.getText()))
				Create.tfIdC.setText("생성 가능");
			else
				Create.tfIdC.setText("생성 불가");
			
		}
		if (e.getActionCommand().equals("P/W검사")) {
			if(Create.tfPw.getText().equals(Create.tfRePw.getText()))
				Create.tfPwC.setText("정상");
			else
				Create.tfPwC.setText("불가");
		}
		if (e.getActionCommand().equals("생성")) {
			if(dao.idCheck(Create.tfId.getText()) && Create.tfPw.getText().equals(Create.tfRePw.getText())) {
				dao.idCreate(Create.tfId.getText(), Create.tfPw.getText());
				System.out.println("생성 완료!");
				Create.loginf.dispose();
			}
			else
				System.out.println("생성 실패");
			
		}
		if (e.getActionCommand().equals("취소")) {
			Create.loginf.dispose();
		}
	}
}
