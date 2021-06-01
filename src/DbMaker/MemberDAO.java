package DbMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private String query;
	private ResultSet rs;

	// 목록 조회
	public ArrayList<MemberVo> selectDB(String str) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try {
			connDB();

			query = "select " + str + "_name from java_" + str;
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

	public String contents(String cName, String name) {
		String str = "";
		try {
			connDB();
			query = "select " + cName + "_contents from java_" + cName + " where " + cName + "_name = '"
					+ name.toUpperCase() + "'";
			rs = stmt.executeQuery(query);
			rs.next();
			System.out.println(rs.getString(1));
			str = rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	// Term DB만들기
	// Term table 생성
	public void createTermTable() {
		try {
			query = "create table java_term (term_id int, term_name varchar2(40), term_contents varchar2(4000))";
			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Term table삭제
	public void removeTermTable() {
		try {
			query = "drop table java_term";
			rs = stmt.executeQuery(query);
			System.out.println("삭제 완료!");
		} catch (SQLException e) {
			System.out.println("없는 테이블");
		}
	}

	// Term table 내용 넣기
	public void addTerm(int cnt, String str, String str2) {
		try {
			String query = "insert into java_term values('" + cnt + "', '" + str + "', '" + str2 + "')";
			rs = stmt.executeQuery(query);
			System.out.println("생성 완료!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// SQL DB만들기
	// SQL table 생성
	public void createSqlTable() {
		try {
			query = "create table java_Sql (term_id int, sql_name varchar2(50), sql_contents varchar2(4000))";
			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// SQL table삭제
	public void removeSqlTable() {
		try {
			query = "drop table java_Sql";
			rs = stmt.executeQuery(query);
			System.out.println("삭제 완료!");

		} catch (SQLException e) {
			System.out.println("없는 테이블");
		}
	}

	// SQL table 내용 넣기
	public void addSql(int cnt, String str, String str2) {
		try {
			String query = "insert into java_Sql values('" + cnt + "', '" + str + "', '" + str2 + "')";
			rs = stmt.executeQuery(query);
			System.out.println("생성 완료!");

		} catch (Exception e) {
			e.printStackTrace();
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
