package DbMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	private LocalDateTime now;
	private DateTimeFormatter dateTimeFormatter;

	public MemberDAO() {
		connDB();
	}

	// 초기에 존재해야하는 테이블들 생성
	public void baseDB() {
		person();
		serch_List_Create();
		serch_Count_Create();
	}

	// id/pw 테이블 생성
	public void person() {
		try {
			query = "create table person(person_id varchar2(50) , person_pw varchar2(50) not null, "
					+ "constraint pk_person primary key(person_id))";
			rs = stmt.executeQuery(query);
			System.out.println("person table create!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 검색어 목록 테이블 생성
	public void serch_List_Create() {
		try {
			query = "create table serch_list(serch_word varchar2(100), serch_date varchar2(50), person_id varchar2(30), "
					+ "constraint fk_serch_list foreign key(person_id) references person(person_id))";
			rs = stmt.executeQuery(query);
			System.out.println("serch_list table create!");
		} catch (SQLException e) {
		}
	}

	// 검색어 카운트 테이블
	public void serch_Count_Create() {
		try {
			query = "create table serch_count(c_word varchar2(100), c_count int)";
			rs = stmt.executeQuery(query);
			System.out.println("serch_count table create!");
		} catch (SQLException e) {
		}
	}

	// 검색어 카운트 테이블 조회
	public ArrayList<MemberVo> serch_Count() {
		list = new ArrayList<MemberVo>();
		try {
			query = "select c_word, c_count from serch_count order by c_count desc";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String word = rs.getString("c_word");
				MemberVo data = new MemberVo(word);
				list.add(data);
			}
		} catch (SQLException e) {
		}
		return list;
	}

	// 검색어 리스트에 추가 & 검색어 카운트 & 검색 기능
	public ArrayList<MemberVo> serchDB(String str, String serch) { // 클래스이름, 검색어
		list = new ArrayList<MemberVo>();
		now = LocalDateTime.now();
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
		try {
			// 검색어를 검색어목록 테이블에 insert or update.(검색어, 날짜, 사용자)
			query = "merge into serch_list using dual on (serch_word = '" + serch + "' and person_id='"
					+ MainFrame.f.getTitle().toLowerCase() + "')" + "when matched then update set serch_date = '"
					+ now.format(dateTimeFormatter) + "'"
					+ "when not matched then insert (serch_word, serch_date, person_id) " + "values ('" + serch + "', '"
					+ now.format(dateTimeFormatter) + "','" + MainFrame.f.getTitle().toLowerCase() + "')";
			rs = stmt.executeQuery(query);
			// 검색어를 카운트 테이블에서 있으면 count 없으면 insert.
			query = "merge into serch_count using dual on (c_word = '" + serch + "')"
					+ "when matched then update set c_count = c_count +1"
					+ "when not matched then insert (c_word, c_count) values ('" + serch + "', 1)";
			rs = stmt.executeQuery(query);
			// 검색어를 해당 테이블에서 검색한다.
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

	// 사용자 검색 목록 조회
	public ArrayList<MemberVo> serch_List() {
		list = new ArrayList<MemberVo>();
		try {
			query = "select serch_word, serch_date from serch_list where person_id = '"
					+ MainFrame.f.getTitle().toLowerCase() + "'";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String word = rs.getString("serch_word");
				String date = rs.getString("serch_date");
				MemberVo data = new MemberVo(word, date);
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
			query = "delete from serch_list where serch_word ='" + str + "'and person_id = '"
					+ MainFrame.f.getTitle().toLowerCase() + "'";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
		}
	}

	// 검색 목록 모두 삭제
	public void serch_List_AllRemove() {
		try {
			query = "delete from serch_list where person_id = '" + MainFrame.f.getTitle().toLowerCase() + "'";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
		}
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
				return str;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	// 테이블 생성
	public void createTable(String table_name) {
		try {
			query = "create table java_" + table_name + "(" + table_name + "_name varchar2(100), " + table_name
					+ "_contents varchar2(4000))";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// table_name에 내용 넣기
	public void insert(String table_name, String str, String str2) {
		try {
			query = "insert into java_" + table_name + " values('" + str + "', '" + str2 + "')";
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// function table 필요없는 필드 삭제.
	public void remove_field() {
		try {
			query = "alter table java_function drop column function_contents";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
		}
	}

	// 모든 DB삭제
	public void removeAll() {
		list = new ArrayList<MemberVo>();
		try {
			query = "select 'drop table ' || object_name || ' cascade constraints' from user_objects where object_type = 'TABLE'";
			rs = stmt.executeQuery(query);
			System.out.println(query);
			while (rs.next()) {
				String name = rs.getString("'DROPTABLE'||OBJECT_NAME||'CASCADECONSTRAINTS'");
				MemberVo data = new MemberVo(name);
				list.add(data);
			}
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				query = data.getTemp1();
				System.out.println(query);
				rs = stmt.executeQuery(query);
			}
		} catch (SQLException e) {
			System.out.println("테이블 없음");
		}
	}

	// 아이디 중복 체크
	public boolean idCheck(String id) {
		try {
			query = "SELECT person_id FROM person";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (id.toLowerCase().equals(rs.getString("person_id"))) {
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
			query = "insert into person values('" + id.toLowerCase() + "','" + pw.toLowerCase() + "')";
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 로그인
	public ArrayList<MemberVo> list(String name) {
		list = new ArrayList<MemberVo>();
		try {
			query = "select * from person where person_id = '" + name.toLowerCase() + "'";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("person_id");
				String password = rs.getString("person_pw");
				MemberVo data = new MemberVo(id.toLowerCase(), password.toLowerCase());
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
