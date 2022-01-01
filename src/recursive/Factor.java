package recursive;

public class Factor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		factor(60);
	}
	
	//소인수 분해
	public static void factor (int n ){
		
		int i = 2;	//소수는 체크 변수
		

		//System.out.println("n::"+n);
		if (n == 1){
			return ;
		}else{
			while(true){
				//System.out.println("n:"+n+"/ i :" +i +"=="+n/i); 
				if(n % i == 0){
					
					if ( n == i ){
						System.out.print(i);
					}else{
						System.out.print(i + "," );
					}
					factor(n/i);
					break;
				}else{
					// i가 원래 입력값과 같으면 종료.
					if ( n == i ){
						System.out.print(i);
						break;					
					}else{
						i++;					
					}
				}			
			}	
		}		
	}
}
