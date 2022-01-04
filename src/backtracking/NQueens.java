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
		
		String dignalYn = "N";	//�밢���翩��
		
		//Ż������
		if(row == N){
			printResult();
			return;
		}else{
			
			
			for(int col = 0 ; col < N ; col++){
					
				if(row == 0){
					//�� ����
					visited[col] = 1;
					map[row][col] = 1;
					row ++;
					
					//����Լ� ȣ��
					locate(row);
					
					//������
					row--;
					visited[col]=0;
					map[row][col] = 0;
				}else{
					
					//��row�� �� �밢�� ���� ���� üũ 
					//�ش� �� ������ Math.abs�� �ϴ°� �� ȿ������ �� ����.
					/*
					if(col == 0){	//�� ����
						if(map[row-1][col+1] == 1){
							dignalYn = "Y";
						}else{
							dignalYn = "N";
						}
					}else if(col == N-1){	//�� ����
						if(map[row-1][col-1] == 1){
							dignalYn = "Y";
						}else{
							dignalYn = "N";
						}
					}else{	//�׿�
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
					
					//Queen�� ���� �ٿ� ���Ե����� ���� ��� && �� �밢���� 1�� �������� �ʴ°�쿡 1ǥ�� �� ���� ����
					if(visited[col] != 1 && "N".equals(dignalYn)){
						//�� ����
						visited[col] = 1;
						map[row][col] = 1;
						row ++;
						
						//����Լ� ȣ��
						locate(row);
						
						//������
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
