package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class InterestingParty{
	public static void main(String[] args) throws FileNotFoundException {
		InterestingParty party = new InterestingParty();

		String path = InterestingParty.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path+"input.txt"));

		String first[];
		String second[];
		
		String str = sc.nextLine();
		first = str.split(" ");
		
		str = sc.nextLine();
		second = str.split(" ");
		
		
		int result = party.bestInvitation2(first, second);
		System.out.println(result);
	}
	
	public int bestInvitation(String[] first, String[] second) {
		int max =1;
		int result = 0;
		
		for(int i=0; i< first.length; i++) {
			String temp = first[i];
			max = 0;
			for(int j=0; j<first.length; j++) {
				String temp2 = first[j];
				String temp3 = second[j];
				
				if(i==j) continue;
				if(temp.equals(temp2) || temp.equals(temp3)) {
					System.out.print(i+" "+j);
					System.out.print(": ");
					System.out.println(temp+" ");
					max++;
					if(result < max) {
						result = max;
					}
				}
			}
		}
		
		
		return result+1;
	}
	
	public int bestInvitation2(String[] first, String[] second) {
		HashMap<String,Integer> dic =  new HashMap<>();
		
		for(int i =0; i< first.length; i++) {
			dic.put(first[i],0);
			dic.put(second[i],0);
		}
	
		for(int i =0; i<first.length; i++) {
			dic.put(first[i],dic.get(first[i])+1);
			dic.put(second[i],dic.get(second[i])+1);
		}
		
		int ans =0;
		
		for(String key: dic.keySet()) {
			ans = Math.max(ans,dic.get(key));
		}
		return ans;
	}
	
}
