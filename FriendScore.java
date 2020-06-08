package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendScore {
	public static void main(String[] args) throws FileNotFoundException {
		String str = FriendScore.class.getResource("").getPath();
		
		File file = new File(str+"FriendScore.txt");
	
		Scanner sc  = new Scanner(file);
	
		ArrayList<String> list = new ArrayList<>();
		
		while(sc.hasNext()) {
			String input = sc.nextLine();
			list.add(input);
		}
		
		String[] strs = new String[list.size()];
		FriendScore fs = new FriendScore();
		
		fs.highestScore(list.toArray(strs));
		
	}
	
	public int highestScore(String[] friends) {
		int count[] = new int[friends.length];
		int index=0;

		for(String str:friends) {
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='Y') 
					count[index]++;
			}
			index++;
		}
	
		int max=0;
		for(int i=0; i< friends.length;i++) {
			
		}
		return 0;
	}
}
