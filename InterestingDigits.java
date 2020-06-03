package hblee;

import java.util.Scanner;

public class InterestingDigits {
	public static void main(String[] args) {
		InterestingDigits id = new InterestingDigits();
	
		Scanner sc =new Scanner(System.in);
		
		int base = sc.nextInt();
		int [] result = id.digits(base);
		
//		for(int ret : result) {
//			System.out.println(ret);
//		}
	}
	
	public int[] digits(int base) {
		int[] result = null;

		int sumArr[] = new int[1001];
		
		StringBuffer sb;

		for(int i =1; i<1000; i++) {
			int sum =0;
			int remain=0;
			int temp; 
			sb = new StringBuffer();
		
			int val = i;
			while(true) {
				remain = val % base;
				val = val / base;
				
				sb.append(remain);
				sum+=remain;
				
				if(val < base) {
					sum += val;
					sb.append(val);
					break;
				}
			}
			System.out.print(i +" ==== ");
			System.out.println(sb.reverse().toString());
			
		}
		
		return result; 
	}
}
