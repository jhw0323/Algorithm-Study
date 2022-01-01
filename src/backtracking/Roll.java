package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Roll {

	static int N;
	static int[] result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//�Է¹��� �ֻ��� ����
		result = new int[N];		//������� ������ �迭
		
		int diceNum = 0;	//0~(N~1)�� �ֻ����� �ǒ�
		
		//roll(diceNum);
		rollDupDel(diceNum);
		
	}

	//�ֻ����� N�� ������ ���� �� �ִ� ����� ���� ��� ����ϴ� �ڵ�	
	private static void roll(int diceNum){

		//Ż�� ����.
		if(diceNum == N){	//N��° �ֻ����� ���� ���� ���
			System.out.println(Arrays.toString(result));
			return;
		}else{
			
			for(int i = 1 ; i <= 6 ; i ++){
				//�� �ٲٱ�
				result[diceNum] = i;
				diceNum ++;	//n+1�� �ֻ����� �Ѿ
				
				//���ȣ��
				roll(diceNum);	//n+1�� �ֻ����� ���Ͽ� ���ȣ��
				
				//�� ����
				diceNum --;
				result[diceNum] = 0; //�ռ� �����ߴ� ���� ����ȣ���� ���� �ʱ�ȭ�� ���� ������ ����
			}
			
		}		
		
	}
	
	// 	��� �ֻ����� �ٸ� ����� ���� �ߺ� ���� ����մϴ�.
	//[1,2,3]�� [1,3,2], [3,1,2] ���� ��� ���� ���� �����Ͽ� �ϳ��� ���
	
	private static void rollDupDel(int diceNum){
		
		int count = 0;
		
		//Ż������
		if(diceNum == N){
			
			System.out.println(Arrays.toString(result));
			return;
			
		}else{
			
			// �ʱ� ���� ��� ���� , �ι�° ���ʹ� ���ֻ��� ��°������ �ݺ��Ͽ� �ߺ��� ����
			if(diceNum == 0)
				count = 1;
			else
				count = result[diceNum-1];
			
			for(int i = count ; i <= 6; i++){
								
				result[diceNum] = i;
				diceNum ++ ;
				
				//���ȣ��
				rollDupDel(diceNum);
				
				//�� ����
				diceNum --;
				result[diceNum] = 0;				
				
			}
			
			
		}
		
		
	}
	
}
