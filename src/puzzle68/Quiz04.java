package puzzle68;

/**
 * 막대 자르기
 * 길이 n[cm]의 한 막대를 1[cm] 단위로 자르며 
 * 하나의 막대는 한번에 한 사람만 자를 수 있다. 잘린 막대가 3개가 되면 동시에 3명이 자를 수 있다.
 * 최대 m명이 있을 때 막대를 자르는 최소 횟수를 구해라.
 * */
public class Quiz04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cutBar(3,20,1));
		System.out.println(cutBar(5,100,1));
	}

	
	/**
	 * bar를 사람수 만큼 자르는 함수
	 * @param person : 사람수
	 * @param barSize : 막대 사이즈
	 * @param current : 현재 막대의 갯수
	 * @return 남은 bar size
	 * **/
	public static int cutBar(int person , int barSize , int current) {
		
		if(current >= barSize) {
			return 0; //잘라내기종료
		}else if(current < person) {
			return 1 + cutBar(person , barSize , current * 2);	//다음은 현재의 2배가 된다.
		}else {
			return 1 + cutBar(person , barSize, current + person);	//사람 수 만큼 증가
		}
		
	}
	
}


