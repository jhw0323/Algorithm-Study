package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NRooks {
	
	
	static int N;
	static int[][] map;
	static int[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new int [N];
		
		int row = 0;
		
		locate(row);
		
	}
	
	private static void locate(int row){
		
		//탈출 조건
		if(row == N){
			printResult();
			return;
		}else{
			
			for(int col = 0 ; col < N ; col++){
				
				if(visited[col] != 1){
					map[row][col] = 1;
					visited[col] = 1;
					row ++;
					
					locate(row);
					
					//값 복원
					row --;
					visited[col] = 0;
					map[row][col] = 0;
				}
			}
		}
		return ;
		
	}
	
	private static void printResult(){
		for(int i = 0; i<N ; i++){
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("-------------");
		
	}

}
