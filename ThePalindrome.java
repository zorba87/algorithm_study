package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThePalindrome {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ThePalindrome pal = new ThePalindrome();
		
		String path = ThePalindrome.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path+"ThePalindrome.txt"));
		
		String s = sc.nextLine();
		String origin = s; 
		int cnt=0;
		
		while(true) {
			
			if(isPal(s)) {
//				System.out.println("pal is "+s);
				break;
			}else {
				s= s.substring(1);
//				System.out.println(s);
			}
			cnt++;
		}
		int sum = cnt +origin.length();
		System.out.println(sum);
	}
	
	
	static boolean isPal(String sub) {
		int len = sub.length();

		for(int i=0; i<len; i++ ) {
			if(sub.charAt(i) != sub.charAt(len-i-1) ) {
				return false;
			}
		}
		return true;
	}
}
