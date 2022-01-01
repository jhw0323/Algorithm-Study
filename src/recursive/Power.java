package recursive;

public class Power {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		power(2,10);
		
	}
	
	//재귀함수를 이용하여 제곱을 계산하는 메서드	
	public static int power(int n , int m){
		
		int result = 1;
		
		if ( m == 0 ) {		}
		else {
			System.out.println("최종 재곱 전 재귀함수 호출 n="+n +" / m="+m);
			result = n * power(n , m-1);
			System.out.println("최종 재곱 전 재귀함수 호출 후 n="+n +" / m="+m);
			System.out.println("최종 재곱 전 재귀함수 호출 후 result :"+result);
		}
		
		return result;
		
	}
	
}
