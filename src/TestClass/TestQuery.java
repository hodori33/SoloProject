package TestClass;

public class TestQuery {

	public static void main(String[] args) {
		String str = "function";
		String name = "ab";
		String query;
		
		query = "select " + str + "_name from java_" + str;
		
		System.out.println(query);

	}

}
