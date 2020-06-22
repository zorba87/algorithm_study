package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

enum Direction{
	EAST,
	WEST,
	SOUTH,
	NORTH
}

public class CrazyBot {
	static int east;
	static int west;
	static int south;
	static int north;
	static double total=0;
	static int n;

	static boolean matrix[][] = new boolean [100][100];
	int []xis = new int[]{-1,1,0,0};
	int []yis = new int[]{0,0,-1,1};
	static int value[] = new int[4];
	
	
	public static void main(String[] args) throws FileNotFoundException {
		CrazyBot cb = new CrazyBot();
	
		String str = FriendScore.class.getResource("").getPath();
		File file = new File(str+"CrazyBot.txt");
		Scanner sc  = new Scanner(file);

		n= sc.nextInt();
		int val;
		
		for(int i=0;i<4;i++) {
			val = sc.nextInt();
			sc.nextLine();
			value[i] = val;
		}

		matrix[50][50] = true;
		cb.dfs(n,50,50,0);
		System.out.println("tt "+total);
	}
	
	public double dfs(int depth,int x,int y,int k) {
		double sum = 0;

		if(depth >0) {
			
			for(int i=0; i<4;i++) {
				int xx = xis[i];
				int yy = yis[i];
				
				if(matrix[x+xx][y+yy] != true) {
					matrix[x+xx][y+yy] = true;
					System.out.println("gg");
					total += dfs(depth-1,x+xx,y+yy,i)*value[i];
					System.out.println(total);
					matrix[x+xx][y+yy] = false;
					
				}
				for (int j = 0; j < matrix.length; j++) {
					for (int j2 = 0; j2 < matrix.length; j2++) {
						matrix[j][j2] = false;
					}
				}
			}
			
		}
		
		return value[k];
	}
	
}
