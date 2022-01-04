package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NQueens {

	
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
		
		String dignalYn = "N";	//대각존재여부
		
		//탈출조건
		if(row == N){
			printResult();
			return;
		}else{
			
			
			for(int col = 0 ; col < N ; col++){
					
				if(row == 0){
					//값 셋팅
					visited[col] = 1;
					map[row][col] = 1;
					row ++;
					
					//재귀함수 호출
					locate(row);
					
					//값복원
					row--;
					visited[col]=0;
					map[row][col] = 0;
				}else{
					
					//윗row의 퀸 대각선 존재 여부 체크 
					//해당 비교 조건을 Math.abs로 하는게 더 효율적일 것 같다.
					/*
					if(col == 0){	//맨 좌측
						if(map[row-1][col+1] == 1){
							dignalYn = "Y";
						}else{
							dignalYn = "N";
						}
					}else if(col == N-1){	//맨 우측
						if(map[row-1][col-1] == 1){
							dignalYn = "Y";
						}else{
							dignalYn = "N";
						}
					}else{	//그외
						if(map[row-1][col-1] == 1 || map[row-1][col+1] == 1){
							dignalYn = "Y";
						}else{
							dignalYn = "N";
						}
					}
					*/
					for(int i = 0 ; i < N ; i ++){
						if(Math.abs(i - col) == 1 && map[row-1][i] == 1){
							dignalYn = "Y";
							break;
						}else{
							dignalYn = "N";
						}
					}
					
					//Queen의 세로 줄에 포함되있지 않은 경우 && 윗 대각선에 1이 존재하지 않는경우에 1표시 후 이후 진행
					if(visited[col] != 1 && "N".equals(dignalYn)){
						//값 셋팅
						visited[col] = 1;
						map[row][col] = 1;
						row ++;
						
						//재귀함수 호출
						locate(row);
						
						//값복원
						row--;
						visited[col]=0;
						map[row][col] = 0;
					}
					
				}
			}
			
			
			
			
		}
		
	}
	
	private static void printResult(){
		
		for(int i = 0 ; i < N ; i++){
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("------------------------------");
		
	}
	
	
}
