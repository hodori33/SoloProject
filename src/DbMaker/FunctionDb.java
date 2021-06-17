package DbMaker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class FunctionDb {
	private MemberDAO dao = new MemberDAO();

	public FunctionDb() {
		BufferedReader reader = null;
		Reader r = null;
		String table = null, name = null, temp = null, data1 = null, data2 = null;
		try {
			r = new FileReader("G:\\Java\\SoloProject3\\src\\Function.txt", StandardCharsets.UTF_8);
			reader = new BufferedReader(r);
			dao.createTable("function");
			while (true) {
				table = reader.readLine(); // 첫줄 해당 테이블생성
				if (table == null) {
					break;
				}
				dao.createTable(table);
				dao.insert("function", table, null);
				data1 = reader.readLine(); // 둘째줄 내용 1
				while (true) {
					temp = reader.readLine(); // 셋째줄 파싱
					if (temp.equals("@@")) { // @@ 이면 종료
						break;
					}
					StringTokenizer st = new StringTokenizer(temp, "\t");
					while (st.hasMoreTokens()) {
						data2 = st.nextToken();
						name = st.nextToken();
					}
					temp = "\n" + data1 + "\n" + data2 + "\t" + name + "\n" + reader.readLine(); // 넷째줄 내용1 + 이름 + 내용2
					// dao.로 table(테이블명), name(이름), data1(내용) 전달
					dao.insert(table, name, temp);
					temp = "";
				}
			}
			dao.remove_field();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
