package recursive;

public class Power {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		power(2,10);
		
	}
	
	//����Լ��� �̿��Ͽ� ������ ����ϴ� �޼���	
	public static int power(int n , int m){
		
		int result = 1;
		
		if ( m == 0 ) {		}
		else {
			System.out.println("���� ��� �� ����Լ� ȣ�� n="+n +" / m="+m);
			result = n * power(n , m-1);
			System.out.println("���� ��� �� ����Լ� ȣ�� �� n="+n +" / m="+m);
			System.out.println("���� ��� �� ����Լ� ȣ�� �� result :"+result);
		}
		
		return result;
		
	}
	
}
