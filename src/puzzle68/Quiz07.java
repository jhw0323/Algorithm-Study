package puzzle68;

import java.util.Calendar;

/**
 * 날짜의 2진수 변환
 * YYYYMMDD -> 10진수 -> 2진수 -> 거꾸로 나열 -> 10진수 되돌렸을 때 원래 날짜와 같은 날짜가 되는 것을 찾으시오.
 * (1964/10/10 ~ 2020/07/24 사이) 
 * */
public class Quiz07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int year = 0;
		int month = 0;
		int date = 0;
		String concatDate = "";
		
		//시작일 셋팅
		Calendar sdt = Calendar.getInstance();
		sdt.set(1964, 10, 10);
		
		//종료일 셋팅
		Calendar edt = Calendar.getInstance();
		edt.set(2020, 7 , 24);
		
		String bStr = "";	//2진수 변환문자열
		String reverseBStr = "";	//2진수 거꾸로 나열 문자열
		int reverseDate = 0;	//2진수 거꾸로 나열 문자열을 변환 10진수
		int count = 0 ;
		
		while(true) {
			
			//종료조건
			if(sdt.after(edt)) {
				break;
			}
			
			//날짜 문자열 셋팅
			year = sdt.get(Calendar.YEAR);
			month = sdt.get(Calendar.MONTH);
			date = sdt.get(Calendar.DATE);
			concatDate = String.valueOf(year);
			if(month < 10) {
				concatDate += "0";
			}
			concatDate += month;
			if(date < 10) {
				concatDate += "0";
			}
			concatDate += date;
			
			//2진수 변환
			bStr = Integer.toBinaryString(Integer.valueOf(concatDate));
			
			//역순 문자열 함수 호출
			reverseBStr = reverseStr(bStr);
			
			//역순 문자열 (날짜) 이진수를 10진수로 변경
			reverseDate = Integer.parseInt(reverseBStr,2);
			
			if(Integer.valueOf(concatDate) == reverseDate) {
				System.out.println("날짜 , 변화 날짜가 같은 경우::"+concatDate);
				count ++;
			}
			
			//1일 추가
			sdt.add(Calendar.DATE, 1);
		}
		
		System.out.println("같은날짜 count::"+count);
		
	}
	
	/**
	 * 역순문자열 리턴함수
	 * @param source : 원문자열
	 * @return 역순 문자열
	 * */
	private static String reverseStr(String source) {
		char[] chAry = new char[source.length()];
		
		for(int i = 0 ; i < source.length() ; i ++) {
			chAry[i] = source.charAt(source.length() - (i+1));
		}
		String target = new String(chAry);
		
		return target;
	}

}
