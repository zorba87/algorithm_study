package hblee;

public class Cryptography {
	
	public static void main(String[] args) {
		Cryptography cr = new Cryptography();
		
		int num[] = {1,1,1};
		cr.encrypt(num);
	}
	
	public long encrypt(int[] numbers) {
		
		int max = 0;
		int num[] = numbers;

		for(int i=0; i< num.length; i++) {
			
			int sum= 1;
			for(int j =0; j<num.length; j++) {
				if(j !=i) {
					sum *= num[j];
				}else {
					sum *= num[i]+1;
				}
				
			}
			max = sum;
		System.out.println(max);
		}
		return max;
	}
	
}
