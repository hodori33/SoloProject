package DbMaker;

public class MemberVo {
	private String temp1, temp2;

	public MemberVo() {
	}

	public MemberVo(String temp1) {
		this.temp1 = temp1;
	}

	public MemberVo(String temp1, String temp2) {
		this.temp1 = temp1;
		this.temp2 = temp2;
	}

	public String getTemp1() {
		return temp1;
	}

	public String getTemp2() {
		return temp2;
	}
}
