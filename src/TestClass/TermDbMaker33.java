package TestClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import DbMaker.MemberDAO;

public class TermDbMaker33 {
	private MemberDAO dao = new MemberDAO();

	public TermDbMaker33() {
		dao.connDB();
	}

	public void createTermTable() {
		BufferedReader reader = null;
		Reader r = null;
		String temp = "";

		String name, data;
		int cnt = 1;
		try {
			r = new FileReader("C:\\Users\\hodori\\Desktop\\가나.txt");
			reader = new BufferedReader(r);

			dao.createTermTable(); // TermTable�깮�꽦

			while (true) {
				name = reader.readLine(); // term_name�슜
				if (name == null) {
					break;
				}
				while (true) {
					data = reader.readLine(); // �몢踰덉㎏ �씪�씤遺��꽣
					if (data.equals("@@") || data == null) { // @@ �씠嫄곕굹 �꼸�씠硫� 醫낅즺 //null泥댄겕媛� �븞�맖.
						break;
					}
					System.out.println(data);
					String arr = data.toString() + "\n"; // temp 臾몄옣 �씠�뼱 遺숈씠湲�
					temp += arr;
				}
				dao.addTerm(cnt, name, temp); // temp濡� name�뀒�씠釉붿쓽 contents�빆紐⑹뿉 insert.
				temp = "";
				cnt++; // �꽆踰꾨쭅
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeTermTable() {
		dao.removeTermTable();
	}

}
