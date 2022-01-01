package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Roll {

	static int N;
	static int[] result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//입력받은 주사위 개수
		result = new int[N];		//결과값을 저장할 배열
		
		int diceNum = 0;	//0~(N~1)번 주사위를 의믜
		
		//roll(diceNum);
		rollDupDel(diceNum);
		
	}

	//주사위를 N개 던져서 나올 수 있는 경우의 수를 모두 출력하는 코드	
	private static void roll(int diceNum){

		//탈출 조건.
		if(diceNum == N){	//N번째 주사위에 값이 있을 경우
			System.out.println(Arrays.toString(result));
			return;
		}else{
			
			for(int i = 1 ; i <= 6 ; i ++){
				//값 바꾸기
				result[diceNum] = i;
				diceNum ++;	//n+1번 주사위로 넘어감
				
				//재귀호출
				roll(diceNum);	//n+1번 주사위에 대하여 재귀호출
				
				//값 원복
				diceNum --;
				result[diceNum] = 0; //앞서 변경했던 값을 다음호출을 위해 초기화를 위한 기존값 복원
			}
			
		}		
		
	}
	
	// 	모든 주사위가 다를 경우의 수를 중복 없이 출력합니다.
	//[1,2,3]과 [1,3,2], [3,1,2] 등은 모두 같은 경우로 간주하여 하나만 출력
	
	private static void rollDupDel(int diceNum){
		
		int count = 0;
		
		//탈출조건
		if(diceNum == N){
			
			System.out.println(Arrays.toString(result));
			return;
			
		}else{
			
			// 초기 값은 모두 저장 , 두번째 부터는 앞주사위 번째수부터 반복하여 중복건 제거
			if(diceNum == 0)
				count = 1;
			else
				count = result[diceNum-1];
			
			for(int i = count ; i <= 6; i++){
								
				result[diceNum] = i;
				diceNum ++ ;
				
				//재귀호출
				rollDupDel(diceNum);
				
				//값 원복
				diceNum --;
				result[diceNum] = 0;				
				
			}
			
			
		}
		
		
	}
	
}
