package recursive;

public class Factor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		factor(60);
	}
	
	//���μ� ����
	public static void factor (int n ){
		
		int i = 2;	//�Ҽ��� üũ ����
		

		//System.out.println("n::"+n);
		if (n == 1){
			return ;
		}else{
			while(true){
				//System.out.println("n:"+n+"/ i :" +i +"=="+n/i); 
				if(n % i == 0){
					
					if ( n == i ){
						System.out.print(i);
					}else{
						System.out.print(i + "," );
					}
					factor(n/i);
					break;
				}else{
					// i�� ���� �Է°��� ������ ����.
					if ( n == i ){
						System.out.print(i);
						break;					
					}else{
						i++;					
					}
				}			
			}	
		}		
	}
}
