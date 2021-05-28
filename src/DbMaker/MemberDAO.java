package DbMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private String query;
	private ResultSet rs;

	public void name(String str) {
		try {
			connDB();
			query = "create table " + str + "(" + str + "_id int," + "name varchar2(30)," + str
					+ "_contents varchar(1000))";
			stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Term db만들기
	public void createTermTable() {
		try {
			query = "create table java_term (term_id int, term_name varchar2(50), term_contents varchar(4000))";
			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeTermTable() {
		try {
			query = "drop table java_term";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addTerm(int cnt, String str, String list) {
		try {
			String query = "insert into java_term values('" + cnt + "', '" + str + "', '" + list + "')";
			rs = stmt.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
