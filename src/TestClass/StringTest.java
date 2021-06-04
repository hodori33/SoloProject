package TestClass;

import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) {
		String str = "static double	abs(double a)";
		StringTokenizer st = new StringTokenizer(str, "\t");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

	}

}
