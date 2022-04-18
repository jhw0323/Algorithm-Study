package puzzle68;

/**
 * ���� ��ȯ��
 * 10�� , 50�� , 100�� , 500�� �������� ��� ��ȯ ����
 * ��� ������ ����� ����
 * �� �������� �ִ� 15�� ���� ȯ���� �� �ִ�. 
 * ������ ������ �������� ���Ͻÿ�.
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
	 * ���� ��ȯ �Լ�
	 * 
	 * @param money:���� �ܵ�
	 * @param depth:���� ����
	 * @param count:��ȯ Ƚ��
	 * */
	public static void changeCoin(int money , int depth , int count) {
		
		//����Լ� ��������
		if(coin.length == depth) {
			if(money == 0 && count <= 15) {
				totCount ++;
			}	
		}
		else {
			
			int targetCoin = coin[depth];
			
			//���ȣ��
			for ( int i = 0 ; i <= money / targetCoin ; i ++) {
				changeCoin (money - coin[depth] * i , (depth + 1) , (count + i));
			}
		}
	}
	
	
}
