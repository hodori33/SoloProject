package DbMaker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class FunctionDbMaker {
	private MemberDAO dao = new MemberDAO();

	public FunctionDbMaker() {
		dao.connDB();
	}

	public void createFunctionTable() {
		BufferedReader reader = null;
		Reader r = null;
		String table = null, name = null, temp = null, data1 = null, data2 = null;
		int cnt1 = 1, cnt2 = 1;
		try {
			r = new FileReader("C:\\Users\\hodori\\Desktop\\db만들기\\Function.txt", StandardCharsets.UTF_8);
			reader = new BufferedReader(r);
			dao.createTable("function");
			while (true) {
				table = reader.readLine(); // 첫줄 해당 테이블생성
				if (table == null) {
					break;
				}
				
				dao.createTable(table);
				dao.insert("function", cnt1++, table, null);
				System.out.println(table);
				data1 = reader.readLine(); // 둘째줄 내용 1
				while (true) {
					temp = reader.readLine(); // 셋째줄 파싱
					if (temp.equals("@@")) { // @@ 널이면 종료
						break;
					}
					System.out.println(temp);
					StringTokenizer st = new StringTokenizer(temp, "\t");
					while (st.hasMoreTokens()) {
						data2 = st.nextToken();
						name = st.nextToken();
					}
					temp = "\n" + data1 + "\n" + data2 +"\t"+ name + "\n" + reader.readLine(); // 넷째줄 내용1 + 이름 + 내용2
					// dao.로 table(테이블명) cnt(넘버링), name(이름), data1(내용) 전달
					dao.insert(table, cnt2++, name, temp);
					temp = "";
				}
				cnt2 = 1;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeTable() {
		//function 테이블을 검색해서
		//목록과 일치하는 테이블 삭제해야됨.
		dao.removeTable("function");
	}
	
	public void tableList() {
		//function 테이블을 검색해서
		//리스트로 리턴 받아 choice에 추가해야한다.
	}
	
}
