package puzzle68;

/**
 * 1~100의 번호가 쓰인 100장의 카드 
 * 각각의 사람이 2번 카드부터 1장 간격으로 카드를 뒤집어 나감. (2, 4, 6 ...)
 * 다음 사람이 3번 카드부터 2장 간격으로 카드를 뒤집어 나감. (3, 6, 9 ...)
 * 다음 사람이 4번 카드부터 3장 간격으로 카드를 뒤집어 나감. (4, 8, 12 ...)
 * n번째의 카드부터 n-1장간격으로 카드를 뒤집는 작업을 뒤집을 카드가 더는 없을 때 까지 계속하는데
 * 뒤지븡 ㄹ카드가 더는 없을 때 뒷면이 위를 향한 카드의 번호를 모두 구해 보시오
 * */
public class Quiz03 {

	public static void main(String[] args) {
		
		//배열 초기화 (기본 상태 false , 뒤집어 진 상태 true)
		boolean[] cards = new boolean[100];
		for(int i = 0 ; i < cards.length; i ++) {
			cards[i] = false;
		}
		
		for( int i = 2 ; i <= cards.length; i  ++) {
			
			int j = i ; 
			
			while(true) {
				//배열은 0번방부터 시작
				if(cards[j-1]) {
					cards[j-1] = false;
				}else {
					cards[j-1] = true;
				}
				
				j += i;
				
				//n-1장 간격이 카드 크기보다 길어진다면 뒤집기 종료 
				if(j > cards.length) {
					break;
				}
			}
			
		}
	
		printArray(cards);
	}
	
	/**
	 * 입력된 배열의 항목들이 뒤집어지지 않은 뒷면인 상태를 print 하는 함수
	 * 뒤집은 상태 true , 뒷면인 경우 false
	 * */
	private static void printArray(boolean[] array) {
		
		//배열 항목 중에 앞면이 한건이라도 존재하는 경우 true 리턴.
		for(int i = 0 ; i < array.length ; i ++) {
			if(array[i]==false) {
				System.out.println("array["+(i+1)+"]");
			}
		}
	}
	
}
