package DbMaker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TermDbMaker {

	public static void main(String[] args) {
		BufferedReader reader = null;
		Reader r = null;
		String temp = "";
		MemberDAO dao = new MemberDAO();
		String name, data;
		int cnt = 1;
		try {
			r = new FileReader("C:\\Users\\hodori\\Desktop\\Term.txt");
			reader = new BufferedReader(r);

			dao.connDB();
			dao.createTermTable(); // TermTable생성

			while (true) {
				name = reader.readLine(); // term_name용
				if (name == null) {
					break;
				}
				while (true) {
					data = reader.readLine(); // 두번째 라인부터
					if (data.equals("@@") || data == null) { // @@ 이거나 널이면 종료
						break;
					}
					String arr = data.toString(); // temp 문장 이어 붙이기
					temp += arr;
				}
				dao.addTerm(cnt, name, temp); // temp로 name테이블의 contents항목에 insert.
				temp = "";
				cnt++; // 넘버링
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("생성 완료!");

	}

}