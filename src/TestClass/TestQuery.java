package TestClass;

public class TestQuery {

	public static void main(String[] args) {
		String str = "term";
		String name = "ab";
		String query;
		
		query = "select " + str + "_name from java_" + str+" where "+str+"_name like '%"+name.toUpperCase()+"%'";
		
		System.out.println(query);

	}

}
