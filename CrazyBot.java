package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CrazyBot {
	
	static double east;
	static double west;
	static double south;
	static double north;
	static double total=0;

	public static void main(String[] args) throws FileNotFoundException {
		CrazyBot cb = new CrazyBot();
	
		String str = FriendScore.class.getResource("").getPath();
		File file = new File(str+"CrazyBot.txt");
		Scanner sc  = new Scanner(file);
	
		int n = sc.nextInt();
		sc.nextLine();
//		System.out.println(n);

		east =sc.nextDouble();
		east *= 0.01;
		sc.nextLine();
//		System.out.println(east);

		west =sc.nextDouble();
		west *= 0.01;
		sc.nextLine();
//		System.out.println(west);

		south = sc.nextDouble();
		south *= 0.01;
		sc.nextLine();
//		System.out.println(south);

		north = sc.nextDouble();
		north *= 0.01;
//		System.out.println(north);

		cb.getProbability(n, east, west, south, north);
	}
	
	public double getProbability(int n, double east, double west,double south,double north) {
		double sum = 0;


		total = depthSearch(n,1);
		System.out.println(sum);
		return sum;
	}
	
	public double depthSearch(int depth, double value) {
		double val = value; 

			if(depth == 0) {
						System.out.println("-----------");
				return 0;
			}else {
				for (int i = 1; i <= 4; i++) {
					if(i == 1) {
						val = val *west ;
						System.out.println(val);
						System.out.println("west");
					}else if(i ==2) {
						val = val *east;
						System.out.println(val);
						System.out.println("east");
					}else if(i==3) {
						val = val *south;
						System.out.println(val);
						System.out.println("south");
					}else if(i==4) {
						val = val *north;
						System.out.println(val);
						System.out.println("north");
					}
					System.out.println(total);
					total += depthSearch(depth-1, val);
				}
			}
		return val;
	}
}
