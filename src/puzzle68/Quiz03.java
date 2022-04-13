package puzzle68;

/**
 * 1~100�� ��ȣ�� ���� 100���� ī�� 
 * ������ ����� 2�� ī����� 1�� �������� ī�带 ������ ����. (2, 4, 6 ...)
 * ���� ����� 3�� ī����� 2�� �������� ī�带 ������ ����. (3, 6, 9 ...)
 * ���� ����� 4�� ī����� 3�� �������� ī�带 ������ ����. (4, 8, 12 ...)
 * n��°�� ī����� n-1�尣������ ī�带 ������ �۾��� ������ ī�尡 ���� ���� �� ���� ����ϴµ�
 * ������ ��ī�尡 ���� ���� �� �޸��� ���� ���� ī���� ��ȣ�� ��� ���� ���ÿ�
 * */
public class Quiz03 {

	public static void main(String[] args) {
		
		//�迭 �ʱ�ȭ (�⺻ ���� false , ������ �� ���� true)
		boolean[] cards = new boolean[100];
		for(int i = 0 ; i < cards.length; i ++) {
			cards[i] = false;
		}
		
		for( int i = 2 ; i <= cards.length; i  ++) {
			
			int j = i ; 
			
			while(true) {
				//�迭�� 0������� ����
				if(cards[j-1]) {
					cards[j-1] = false;
				}else {
					cards[j-1] = true;
				}
				
				j += i;
				
				//n-1�� ������ ī�� ũ�⺸�� ������ٸ� ������ ���� 
				if(j > cards.length) {
					break;
				}
			}
			
		}
	
		printArray(cards);
	}
	
	/**
	 * �Էµ� �迭�� �׸���� ���������� ���� �޸��� ���¸� print �ϴ� �Լ�
	 * ������ ���� true , �޸��� ��� false
	 * */
	private static void printArray(boolean[] array) {
		
		//�迭 �׸� �߿� �ո��� �Ѱ��̶� �����ϴ� ��� true ����.
		for(int i = 0 ; i < array.length ; i ++) {
			if(array[i]==false) {
				System.out.println("array["+(i+1)+"]");
			}
		}
	}
	
}