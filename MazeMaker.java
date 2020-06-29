package hblee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeMaker {
	
	static int startRow= 1;
	static int startCol= 0;
	static int[] moveRow = {1,0,-1,0};
	static int[] moveCol = {0,1,0,-1};
	static String[] maze = {
			"x.x",
			"...",
			"xxx",
			"x.x"
	}; 
	static int[][] distance; 
	static int Row,Col;
	static int max=0;

	public static void main(String[] args) throws FileNotFoundException {
		MazeMaker mm = new MazeMaker();
		String path = System.getProperty("user.dir");
		File file = new File(path+"\\src\\hblee\\MazeMaker.txt");
		Scanner sc  = new Scanner(file);
		
		
		String str = sc.nextLine();
		
		Row = maze[0].length();
		Col = maze.length;
		distance = new int[Col][Row];

		for (int i = 0; i < Col; i++) {
			for (int j = 0; j < Row; j++) {
				if(maze[i].charAt(j) =='x') {
					distance[i][j] = -8;
				}else
				distance[i][j] = -1;
			}
		}

		mm.longestPath(maze,startRow, startCol, moveRow, moveCol);
	
		for (int i = 0; i < Col; i++) {
			for (int j = 0; j < Row; j++) {
				if(distance[i][j]==-1) {
					max = -1;
				}
				System.out.print(distance[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("result is : "+ max);
	}
	
	class Point{
		int x,y;
		
		Point(int x,int y ){
			this.x =x;
			this.y =y;
		}

		public void setX(int x) {
			this.x = x;
		}


		public void setY(int y) {
			this.y = y;
		}
		
	}

	public int longestPath(String[] maze, int startRow, int startCol,
							int[] moveRow, int[] moveCol) {
		
		Queue<Point> q = new LinkedList<>();
	
		//first start
		//q에 좌표를 저장해야함.. 
		Point p = new Point(startRow,startCol);
		q.add(p);
		
		distance[startCol][startRow] = 0;
		
		int x,y;
		
		while(!q.isEmpty()){
			Point temp = q.poll();
			
			x= temp.x;
			y= temp.y;

			for (int i = 0; i < moveCol.length; i++) {
				int nextX = x+moveRow[i];
				int nextY = y+moveCol[i];
				
				if(isIn(nextX ,nextY) && maze[nextY].charAt(nextX) =='.' && distance[nextY][nextX] == -1) {
				//add	
					distance[nextY][nextX]= distance[y][x]+1; 
					Point tp = new Point(nextX,nextY);
					q.add(tp);
					max = (distance[nextY][nextX]> max)? distance[nextY][nextX]:max;	
				}
				
			}
			
		}
		
		return max;
	}
	
	boolean isIn(int row, int col) {
		
		if(row>=0 && row<Row && col>=0 && col< Col) {
			return true;
		}
		return false;
	}
}
