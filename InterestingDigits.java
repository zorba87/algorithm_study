package topcoder;

import java.util.ArrayList;
import java.util.Scanner;

public class InterestingDigits {
	public static void main(String[] args) {
		InterestingDigits id = new InterestingDigits();
	
		Scanner sc =new Scanner(System.in);
		
		int base = sc.nextInt();
		int [] result = id.digits(base);
		
		for(int ret : result) {
			System.out.println(ret);
		}
	}
	
	public int[] digits(int base) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=2; i< base; i++) {
			boolean ok = true;
			
			for(int k1=0; k1 < base; k1++) {
				for(int k2=0; k2 <base; k2++) {
					for(int k3=0;k3<base;k3++) {
						if((k3+k2*base+k1*base*base) % i ==0 && (k1+k2+k3) % i != 0) {
							ok = false;
							break;
						}
					}
					if(!ok) break;
				}
				if(!ok) break;
			}
			if(ok) list.add(i); 
		}		
		
		int ans[] = new int[list.size()];
		for(int i=0; i< list.size();i++) ans[i] = list.get(i);
		
		return ans; 
	}
}
