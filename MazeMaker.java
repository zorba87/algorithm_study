package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MazeMaker {
	
	static int startRow= 0;
	static int startCol= 1;
	static int[] moveRow = {1,0,-1,0};
	static int[] moveCol = {0,1,0,-1};
	static String[] maze = {
			"...",
			".X.",
			"..."
	}; 

	public static void main(String[] args) throws FileNotFoundException {
		MazeMaker mm = new MazeMaker();
		String path = System.getProperty("user.dir");
		File file = new File(path+"\\src\\hblee\\MazeMaker.txt");
		Scanner sc  = new Scanner(file);
		
		
		String str = sc.nextLine();
		

		mm.longestPath(maze,startRow, startCol, moveRow, moveCol);
	
	}
	
	class Point{
		int x,y;
		
		Point(int x,int y ){
			this.x =x;
			this.y =y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
	}

	public int longestPath(String[] maze, int startRow, int startCol,
							int[] moveRow, int[] moveCol) {
		
//		System.out.println(maze[1].charAt(1));
		
		Queue<Point> q = new PriorityQueue<>();
		Iterator<Point> itor = q.iterator();
	
		//first start
		//q에 좌표를 저장해야함.. 
		Point p = new Point(startRow,startCol);
		q.add(p);
	
		int x,y;
		
		while(itor.hasNext() ){
			Point temp = q.poll();
			System.out.println(temp);
			
			x= temp.x;
			y= temp.y;

			for (int i = 0; i < moveCol.length; i++) {
				if(".".equals(maze[x].charAt(y))) {
					p.setX(x);
					p.setY(y);
					q.add(p);
					
				}
				
			}
			
		}
		
		return 0;
	}
}
