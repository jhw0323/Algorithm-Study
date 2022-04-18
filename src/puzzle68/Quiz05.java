package puzzle68;

/**
 * 동전 교환기
 * 10원 , 50원 , 100원 , 500원 동전으로 섞어서 교환 가능
 * 모든 동전이 충분한 상태
 * 각 동전마다 최대 15개 까지 환전할 수 있다. 
 * 동전의 조합의 가짓수를 구하시오.
 * */
public class Quiz05 {
	
	static int[] coin = {500,100,50,10};
	
	static int totCount = 0 ;
	static int maxCount = 15;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		changeCoin(1000, 0 , 0);
		System.out.println(totCount);
	}
	
	/** 
	 * 동전 교환 함수
	 * 
	 * @param money:남은 잔돈
	 * @param depth:동전 순번
	 * @param count:교환 횟수
	 * */
	public static void changeCoin(int money , int depth , int count) {
		
		//재귀함수 종료조건
		if(coin.length == depth) {
			if(money == 0 && count <= 15) {
				totCount ++;
			}	
		}
		else {
			
			int targetCoin = coin[depth];
			
			//재귀호출
			for ( int i = 0 ; i <= money / targetCoin ; i ++) {
				changeCoin (money - coin[depth] * i , (depth + 1) , (count + i));
			}
		}
	}
	
	
}
