package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class SearchMinSum {
	
	static int N;
	static int[][] map;
	static int[] minArray;
	static int[] visited;
    static int result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new int [N];
		result = Integer.MAX_VALUE;
		
		genMap(map, N);
		
		int row = 0;
		int sum = 0;
		
		selectNum(row,sum);
		System.out.println("�ּҰ�::"+result);
		
	}
	
	public static void selectNum(int row , int sum){
		
		
		if(row == N){
			//printResult();
			if(result != 0){
				result = Math.min(result, sum);
			}else{
				result = sum;
			}
			
			return;
		}else{
		
			//����ġ�� ����
			//Ż�� ���ǿ� �����ϴ� �ּҰ����� ����Լ� ������� ������ ���� ������ �ʿ䰡 ���� ������ Ż�������� �Ѵ�
			if(result < sum){
				return;
			}
			
			for(int col = 0; col < N ; col++){
				
				if(visited[col]!=1){
					sum = sum+map[row][col];
					visited[col] = 1;
					row ++;
					selectNum(row, sum);
					row--;
					visited[col] = 0;
					sum = sum-map[row][col];
				}
			}
		}
		return;
		
		
	}
	
	/**
	 * Map�� ������ generate�ϴ� �Լ�
	 * @param map ������ �������� ������ �迭
	 * @param count �� ��� �Էµ� �� ����
	 * */
    public static void genMap(int[][] map , int count) {
        
        //�ߺ����� ��������
        int [] ranArray = new int[count*count];
        
        for(int i = 0  ; i < (count*count) ; i ++){
        	int random = (int) (Math.random()*(count*count*2)+1);		//�Է��� count ���� ���� * 2 �� �������� random���� ����
        	ranArray[i] = random;
        			
        	for(int j = 0 ; j < i ; j ++){
        		//�� �迭����� �ߺ����� ������ �ٽ� ������ ����
        		if(ranArray[i] == ranArray[j]){
        			i--;
        			break;
        		}
        	}
        }
        
        //�迭�� �Է�
        int ranCount = 0;
        for(int row = 0 ; row < map.length; row++){
        	for(int col = 0 ; col < map[row].length ; col++){
        		map[row][col] = ranArray[ranCount];
        		ranCount++;
        	}
        }
        
        System.out.println("-----------------------------------");
        //�迭 ���
		for(int i = 0 ; i < N ; i++){
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("-----------------------------------");
    }
	
}
