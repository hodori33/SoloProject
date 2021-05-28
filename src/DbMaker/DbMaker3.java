package DbMaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DbMaker3 {

	public static void main(String[] args) {
		File file = new File("G:\\Java\\SoloProject3\\data1.txt");
		
		try {
			Scanner sc = new Scanner(file);
			
			
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
