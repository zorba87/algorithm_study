package hblee;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q_1700{
	public static void main(String[] args) throws Exception {
		String path = Q_1700.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path+"1700.txt"));
		
		int plug = sc.nextInt();
		int times =  sc.nextInt();
		int arr[] = new int[times];
		int count = 0;
		int save[] = new int[101];
	
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < times; i++) {
			arr[i] = sc.nextInt();
			save[arr[i]]++;
		}
		
		for (int i = 0; i < times; i++) {
			if(list.contains(arr[i])) {
				save[arr[i]]--;
				continue;
			}
			
			if(list.size() > 0) {
				for (int j = 0; j < list.size(); j++) {
					if(save[list.get(j)] <=0) {
						
					}
				}
				
				
			}
						
			list.add(arr[i]);
			save[arr[i]]--;
		}
	}
}