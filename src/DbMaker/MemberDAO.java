package DbMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.MainFrame;

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

	// 로그인 사용자에 따른 검색기록. 개인 페이지에 사용자 검색 기록 출력. 
	// 사용자 아이디로 새로운 테이블 생성.
	// 아이디에 따른 검색 했던 목록 추가/삭제

	// 검색 기능 & 검색어 해당 유저의 db에 추가
	public ArrayList<MemberVo> serchDB(String str, String Choice, String serch) {	//클래스이름, 제목or내용, 검색어
		list = new ArrayList<MemberVo>();
		try {
			query = "insert into "+ MainFrame.f.getTitle() +" values('"+ serch +"','"+ serch + "')";
			rs = stmt.executeQuery(query);
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

	// 검색 목록 db에서 불러오기
	public ArrayList<MemberVo> serch_List() {
		list = new ArrayList<MemberVo>();
		try {
			query = "select serch_list from "+ MainFrame.f.getTitle();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("serch_list");
				MemberVo data = new MemberVo(name);
				list.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 검색 목록 db에서 제거
	public void serch_List_Remove(String str) {
		try {
			query = "delete from " + MainFrame.f.getTitle() + " where serch_list=('"+ str +"')";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
		}
	}
	
	// 검색 목록 모두 삭제
	public void serch_List_AllRemove() {
		try {
			query = "delete from " + MainFrame.f.getTitle();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
		}
	}
	
	// 검색 목록 db에서 불러오기
	
	
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
			return null;
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

	// id/pw테이블
	public void id_pw(){
		try {
			query = "create table person(id varchar2(50), pw varchar2(50))";

			rs = stmt.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 아이디 중복 체크
	public boolean idCheck(String id) {
	
		try {
			query = "SELECT id FROM person";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (id.equals(rs.getString("id"))) {
					return false;
				}
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	// 아이디 생성
	public void idCreate(String id, String pw) {
		
		try {
			query = "insert into person values(" + "'" + id + "','" + pw + "')";
			rs = stmt.executeQuery(query);
			query = "create table "+ id + "(serch_list varchar2(100), serch_date varchar2(30))";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 로그인
	public ArrayList<MemberVo> list(String name) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			query = "SELECT * FROM person";
			if (name != null) {
				query += " where id='" + name + "'";
			}
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("pw");
				MemberVo data = new MemberVo(id, password);
				list.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
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
