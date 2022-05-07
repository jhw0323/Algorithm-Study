package puzzle68;

import java.util.Calendar;

/**
 * ��¥�� 2���� ��ȯ
 * YYYYMMDD -> 10���� -> 2���� -> �Ųٷ� ���� -> 10���� �ǵ����� �� ���� ��¥�� ���� ��¥�� �Ǵ� ���� ã���ÿ�.
 * (1964/10/10 ~ 2020/07/24 ����) 
 * */
public class Quiz07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int year = 0;
		int month = 0;
		int date = 0;
		String concatDate = "";
		
		//������ ����
		Calendar sdt = Calendar.getInstance();
		sdt.set(1964, 10, 10);
		
		//������ ����
		Calendar edt = Calendar.getInstance();
		edt.set(2020, 7 , 24);
		
		String bStr = "";	//2���� ��ȯ���ڿ�
		String reverseBStr = "";	//2���� �Ųٷ� ���� ���ڿ�
		int reverseDate = 0;	//2���� �Ųٷ� ���� ���ڿ��� ��ȯ 10����
		int count = 0 ;
		
		while(true) {
			
			//��������
			if(sdt.after(edt)) {
				break;
			}
			
			//��¥ ���ڿ� ����
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
			
			//2���� ��ȯ
			bStr = Integer.toBinaryString(Integer.valueOf(concatDate));
			
			//���� ���ڿ� �Լ� ȣ��
			reverseBStr = reverseStr(bStr);
			
			//���� ���ڿ� (��¥) �������� 10������ ����
			reverseDate = Integer.parseInt(reverseBStr,2);
			
			if(Integer.valueOf(concatDate) == reverseDate) {
				System.out.println("��¥ , ��ȭ ��¥�� ���� ���::"+concatDate);
				count ++;
			}
			
			//1�� �߰�
			sdt.add(Calendar.DATE, 1);
		}
		
		System.out.println("������¥ count::"+count);
		
	}
	
	/**
	 * �������ڿ� �����Լ�
	 * @param source : �����ڿ�
	 * @return ���� ���ڿ�
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
