package puzzle68;

/**
 * �ݶ��� ����
 * �ڿ��� n�� ����
 * n�� ¦���� ���, n�� 2�� ������.
 * n�� Ȧ���� ���, n�� 3�� ���� 1�� ���Ѵ�.
 * �� ����� �ݺ��ϸ� �ʱ갪�� � �������� �ݵ�� 1�� �����Ѵ�. (1 -> 4 -> 2 -> 1 ���¸� ��Եȴ�)
 * 
 * �ݴ��� ��������
 * �ʱ갪�� ¦���� �� ó������ n�� 3�� ���Ͽ� 1�� ���ϴ� �Ϳ��� �����ϰ� �������� �ݶ��� �������� 
 * 10,000 ������ ¦�� �� 'ó������ ���ư��� ��'�� �� �� �ִ��� ���غ�����
 * */
public class Quiz06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(collazConjecture(10000));
	}

	/**
	 * �ݺ��� �ȿ��� �ݶ��������� ���� �����ϴ� ���� ã�� �Լ�
	 * @param �ݶ��� ������ �����ϴ� ���� ã�� �ݺ���
	 * @return �ݺ��� �ȿ��� �ݶ��� ������ �����ϴ� ���ڰ���
	 * */
	public static int collazConjecture(int maxNumber) {
		
		int returnNumber = 0 ; //ó������ ���ư��� ������ ����
	
		int tempNumber = 0 ;
		for(int i = 2 ; i <= maxNumber; i += 2) {

			tempNumber = i;
			
			//�ʱ갪�� ¦���� �� ó������ n�� 3�� ���Ͽ� 1�� ���ϴ� ������ ����
			if(tempNumber % 2 == 0) {
				tempNumber *= 3;
				tempNumber += 1;	
			}
			
			while(true) {
				
				//¦���� 2�� ������
				if(tempNumber % 2 == 0) {
					tempNumber /= 2;
				//Ȧ���� 3�� ���� 1�� ���Ѵ�.
				}else {
					tempNumber *= 3;
					tempNumber += 1;
				}
				
				//ó������ ���ư��� �� üũ
				if(tempNumber == i) {
					returnNumber ++;
					break;
				//1�� �Ǵ� ��� (1->4->2->1)������ ����Ǿ� ���̻� �ݺ� ������ ���ǹ�
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
