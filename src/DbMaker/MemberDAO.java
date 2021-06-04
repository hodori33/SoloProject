package DbMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String user = "green";
	private String password = "green1234";

	private Connection con;
	private Statement stmt;
	private String query;
	private ResultSet rs;
	private ArrayList<MemberVo> list;
	
	public MemberDAO() {
		connDB();
	}

	// 검색 기능
	public ArrayList<MemberVo> serchDB(String str, String Choice, String serch) {
		list = new ArrayList<MemberVo>();
		try {
			query = "select " + str + "_name from java_" + str + " where " + str + "_name like '%" + serch.toUpperCase()
					+ "%'";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString(str + "_name");
				MemberVo data = new MemberVo(name);
				list.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 목록 조회
	public ArrayList<MemberVo> selectDB(String str) {
		list = new ArrayList<MemberVo>();
		try {
			query = "select " + str.toUpperCase() + "_name from java_" + str.toUpperCase();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString(str + "_name");
				MemberVo data = new MemberVo(name);
				list.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 초이스에서 선택된 항목으로 DB조회
	public String contents(String cName, String name) {
		String str = "";
		try {
			connDB();
			query = "select " + cName + "_contents from java_" + cName + " where " + cName.toLowerCase() + "_name = '"
					+ name + "'";
			rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				str = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	// 테이블 생성
	public void createTable(String table_name) {
		try {
			query = "create table java_" + table_name + "(" + table_name + "_id int, " + table_name
					+ "_name varchar2(100), " + table_name + "_contents varchar2(4000))";

			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// table_name에 내용 넣기
	public void insert(String table_name, int cnt, String str, String str2) {
		try {
			String query = "insert into java_" + table_name + " values('" + cnt + "', '" + str + "', '" + str2 + "')";
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// table삭제
	public void removeTable(String table_name) {
		try {
			query = "drop table java_" + table_name;
			rs = stmt.executeQuery(query);
			System.out.println("삭제 완료!");
		} catch (SQLException e) {
			System.out.println("없는 테이블");
		}
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}
	}

}
