package puzzle68;

/**
 * �յڰ� ���� 10���� �����
 * ��Ī�� : �յڰ� ���� �Ųٷ� �о ���� ��
 * 10���� , 2���� , 8���� �� ��� ������ ǥ���Ͽ��� ��Ī���� �Ǵ� �� ��,
 * 10������ 10 �̻󿡼��� �ּڰ��� ���ϴ� Ŭ����.
 * */
public class Quiz01 {

	public static void main(String[] args) {
		int num = 10;
		String digit2 =	"";		//2���� String����
		String digit8 =	"";		//8���� String����
		String digit10 = 	"";		//10���� String����
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
	 * �Է��� String�� ���� ��Ī���� �´��� üũ�ϴ� �Լ�
	 * @return ��Ī���� true : ��Ī , false : ���Ī
	 * */
	public static boolean checkSymmetry(String digit){
		
		int digitLength = digit.length();
		
		// ���ڿ��� ������ Ȧ������ ¦������ ������� ������ �ݸ�ŭ ������ ��Ī�Ǵ� �ڸ��� ���Ͽ�  
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
