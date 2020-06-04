package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThePalindrome {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ThePalindrome pal = new ThePalindrome();
		
		String path = ThePalindrome.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path+"ThePalindrome.txt"));
		
		String input = sc.nextLine();
		int result = pal.find(input);
		
//		System.out.println(" result "+result);
	}
	
	public int find(String s) {
		String in = s;
	
		System.out.println(isPal(s));
		
		
		return 0;
	}
	
	static boolean isPal(String sub) {
		
		int len = sub.length();
		boolean isPal; 
		

		for(int i=0; i<len; i++ ) {
			if(sub.charAt(i) != sub.charAt(len-i-1) ) {
				return false;
			}
		}
		return true;
	}
}
