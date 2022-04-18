package puzzle68;

/**
 * 콜라츠 추측
 * 자연수 n에 대해
 * n이 짝수인 경우, n을 2로 나눈다.
 * n이 홀수인 경우, n에 3을 곱해 1을 더한다.
 * 이 계산을 반복하면 초깃값이 어떤 수였더라도 반드시 1에 도달한다. (1 -> 4 -> 2 -> 1 형태를 띄게된다)
 * 
 * 반대의 개념으로
 * 초깃값이 짝수면 맨 처음에만 n에 3을 곱하여 1을 더하는 것에서 시작하고 나머지는 콜라츠 추측으로 
 * 10,000 이하의 짝수 중 '처음으로 돌아가는 수'가 몇 개 있는지 구해보세요
 * */
public class Quiz06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(collazConjecture(10000));
	}

	/**
	 * 반복수 안에서 콜라츠추측에 대해 만족하는 수를 찾는 함수
	 * @param 콜라츠 추측에 만족하는 값을 찾는 반복수
	 * @return 반복수 안에서 콜라츠 추측에 만족하는 숫자갯수
	 * */
	public static int collazConjecture(int maxNumber) {
		
		int returnNumber = 0 ; //처음으로 돌아가는 숫자의 갯수
	
		int tempNumber = 0 ;
		for(int i = 2 ; i <= maxNumber; i += 2) {

			tempNumber = i;
			
			//초깃값이 짝수면 맨 처음에만 n에 3을 곱하여 1을 더하는 것으로 시작
			if(tempNumber % 2 == 0) {
				tempNumber *= 3;
				tempNumber += 1;	
			}
			
			while(true) {
				
				//짝수면 2로 나눈다
				if(tempNumber % 2 == 0) {
					tempNumber /= 2;
				//홀수면 3을 곱해 1을 더한다.
				}else {
					tempNumber *= 3;
					tempNumber += 1;
				}
				
				//처음으로 돌아가는 수 체크
				if(tempNumber == i) {
					returnNumber ++;
					break;
				//1이 되는 경우 (1->4->2->1)순으로 진행되어 더이상 반복 진행이 무의미
				}else if(tempNumber == 1){
					break;
				}else {
					continue;
				}
				
			}
			
		}
		
		return returnNumber;
	}
	
}
