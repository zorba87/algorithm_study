package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Q_2437 {
	public static void main(String[] args) throws FileNotFoundException {
		String path = Q_2437.class.getResource("").getPath();
		Scanner sc= new Scanner(new File(path+"2437.txt"));
			
		int num = sc.nextInt();
	
		int arr[]= new int[num];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int findNum=1;
		
		for (int i = 0; i < arr.length; i++) {
			if(findNum < arr[i]) {
				break;	
			}
			findNum += arr[i];
		}
		System.out.println("result is :"+findNum);
		
		
	}
}
