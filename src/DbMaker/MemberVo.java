package DbMaker;

public class MemberVo {
	private String name;
	private String id;
	private String password;
	
	public MemberVo() {
	}

	public MemberVo(String name) {
		this.name = name;
	}
	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

}
