package TestClass;

public class TestQuery {

	public static void main(String[] args) {
		String cName = "Calendar";
		String name = "clear()";
		String query;
		
		query = "select " + cName + "_contents from java_" + cName + " where " + cName.toLowerCase() + "_name = '"
				+ name.toLowerCase() + "'";
		
		System.out.println(query);

	}

}
