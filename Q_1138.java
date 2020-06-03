package hblee;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class Q_1138 {

	public static void main(String[] args) throws Exception {

		String path = Q_1138.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "1138.txt"));

		int num = sc.nextInt();
		int arr[] = new int[num+1];

		List<Integer> list = new Vector<Integer>();
		
		for (int i = 1; i <= num; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = num; i > 0; i--) {
			list.add(i, arr[i-1]);
			System.out.println(i);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}