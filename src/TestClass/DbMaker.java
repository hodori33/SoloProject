package TestClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class DbMaker {		
	
	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("test.txt");
			ps = new PrintStream(fos);
			System.setOut(ps);
		}catch(FileNotFoundException e) {
			System.err.println("File not found");
			
		}
		System.out.println("aa");
	}

}
