package puzzle68;

/**
 * ���� �ڸ���
 * ���� n[cm]�� �� ���븦 1[cm] ������ �ڸ��� 
 * �ϳ��� ����� �ѹ��� �� ����� �ڸ� �� �ִ�. �߸� ���밡 3���� �Ǹ� ���ÿ� 3���� �ڸ� �� �ִ�.
 * �ִ� m���� ���� �� ���븦 �ڸ��� �ּ� Ƚ���� ���ض�.
 * */
public class Quiz04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cutBar(3,20,1));
		System.out.println(cutBar(5,100,1));
	}

	
	/**
	 * bar�� ����� ��ŭ �ڸ��� �Լ�
	 * @param person : �����
	 * @param barSize : ���� ������
	 * @param current : ���� ������ ����
	 * @return ���� bar size
	 * **/
	public static int cutBar(int person , int barSize , int current) {
		
		if(current >= barSize) {
			return 0; //�߶󳻱�����
		}else if(current < person) {
			return 1 + cutBar(person , barSize , current * 2);	//������ ������ 2�谡 �ȴ�.
		}else {
			return 1 + cutBar(person , barSize, current + person);	//��� �� ��ŭ ����
		}
		
	}
	
}


