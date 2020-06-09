package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FriendScore {
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		String str = FriendScore.class.getResource("").getPath();
		
		File file = new File(str+"FriendScore.txt");
	
		Scanner sc  = new Scanner(file);
	
		
		while(sc.hasNext()) {
			String input = sc.nextLine();
			list.add(input);
			
		}
		
		
		
		String[] strs = new String[list.size()];
		FriendScore fs = new FriendScore();
		
		fs.highestScore(list.toArray(strs));
		
	}
	
	public int highestScore(String[] friends) {
		
		int max=0;
		int sum=0;
		int len = friends.length;

		boolean matrix[][] = new boolean[friends.length][friends.length];
		
		for (int i = 0; i < len; i++) {
			
			for (int j = 0; j < len; j++) {
				if(friends[i].charAt(j) == 'Y' ) {
					matrix[i][j] = true;
				}else {
					matrix[i][j] = false;
				}
			}
		}
	
		for (int i = 0; i < len; i++) {
			
			sum=0;
			
			for(int j=0; j< len;j++) {
				if(matrix[i][j] == true) {
					sum++;
					
					for (int k = 0; k < len; k++) {
						if(k!=i && matrix[j][k] == true) {
							if(matrix[i][k] != true)
								sum++;
						}
					}
					
				}
			}
			max = (sum > max)? sum : max;
			
		}
		System.out.println(max);
		return 0;
	}
}
