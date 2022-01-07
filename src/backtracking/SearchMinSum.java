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
		System.out.println("최소값::"+result);
		
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
		
			//가지치기 적용
			//탈출 조건에 만족하는 최소값보다 재귀함수 결과값이 높으면 추후 진행할 필요가 없기 때문에 탈출진행을 한다
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
	 * Map을 난수로 generate하는 함수
	 * @param map 난수를 배정받을 이차원 배열
	 * @param count 한 행당 입력된 열 갯수
	 * */
    public static void genMap(int[][] map , int count) {
        
        //중복없는 난수생성
        int [] ranArray = new int[count*count];
        
        for(int i = 0  ; i < (count*count) ; i ++){
        	int random = (int) (Math.random()*(count*count*2)+1);		//입력한 count 보다 제곱 * 2 배 기준으로 random변수 생성
        	ranArray[i] = random;
        			
        	for(int j = 0 ; j < i ; j ++){
        		//전 배열방까지 중복건이 있으면 다시 재적재 조건
        		if(ranArray[i] == ranArray[j]){
        			i--;
        			break;
        		}
        	}
        }
        
        //배열에 입력
        int ranCount = 0;
        for(int row = 0 ; row < map.length; row++){
        	for(int col = 0 ; col < map[row].length ; col++){
        		map[row][col] = ranArray[ranCount];
        		ranCount++;
        	}
        }
        
        System.out.println("-----------------------------------");
        //배열 출력
		for(int i = 0 ; i < N ; i++){
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("-----------------------------------");
    }
	
}
