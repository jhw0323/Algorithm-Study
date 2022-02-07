package puzzle68;

/**
 * 앞뒤가 같은 10진수 만들기
 * 대칭수 : 앞뒤가 같아 거꾸로 읽어도 같은 수
 * 10진수 , 2진수 , 8진수 그 어느 것으로 표현하여도 대칭수가 되는 수 중,
 * 10진수의 10 이상에서의 최솟값을 구하는 클래스.
 * */
public class Quiz01 {

	public static void main(String[] args) {
		int num = 10;
		String digit2 =	"";		//2진수 String변수
		String digit8 =	"";		//8진수 String변수
		String digit10 = 	"";		//10진수 String변수
		while (true) {

			digit2 = Integer.toBinaryString(num);	 
			digit8 = Integer.toOctalString(num);	
			digit10 = Integer.toString(num);
			if ( checkSymmetry(digit2) && checkSymmetry(digit8) && checkSymmetry(digit10)){
				break;
			}
			num ++;
		}
		
		System.out.println( num ) ;

	}

	/*
	 * 입력한 String에 대해 대칭수가 맞는지 체크하는 함수
	 * @return 대칭여부 true : 대칭 , false : 비대칭
	 * */
	public static boolean checkSymmetry(String digit){
		
		int digitLength = digit.length();
		
		// 문자열의 갯수가 홀수개든 짝수개들 상관없이 길이의 반만큼 돌려서 대칭되는 자리수 비교하여  
		for (int i = 0 ; i < digitLength/2 ; i++ ){
			/*
			System.out.println("digit::"+digit +"//digitLength-(i+1)::"+(digitLength-(i+1)));
			*/
		  	if( ! digit.substring(i, i+1).equals(digit.substring(digitLength-(i+1),digitLength-i ))){
		  		return false;
		  	}
		  	
		}
		return true;
		
	}

}
