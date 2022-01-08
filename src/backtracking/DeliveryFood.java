package backtracking;

import java.util.ArrayList;
import java.util.Scanner;


public class DeliveryFood {

	static int N;	//�Է¹��� ��
    static int[] price;
    static String[] menu;
    static int[] visited;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���� ���� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ArrayList<String> orderMenu = new ArrayList<String>();
		
        menu= new String[]{"ġŲ","����","����","�߽�","��â","�н�","ȸ"};
        price=new int[] {20000,30000,40000,64000,33000,24000,72000};
        visited=new int[menu.length];
        
        order(0 , orderMenu);
	}
		
	public static void order(int money , ArrayList<String> orderMenu){
		
		//Ż������
		if(money >= N){
			
			//����Լ� ȣ�� �� ���� �ݾ��� �Ѵ� ������ ������ �Ѿ���� ������ �� �������� �Է��� �޴� �� ������ �����Ѵ�.
			if(money > N){
				String lastMenu = orderMenu.get((orderMenu.size()-1));
				
				for(int i = 0 ; i < menu.length; i ++){
					if(menu[i].equals(lastMenu)){
						money -= price[i];
						orderMenu.remove(lastMenu);
						break;
					}
				}	
			}
			
			//����� String���� ����ϴ� �Ŷ� �ߺ� �޴��� �߶� �� ����. �ߺ� ���Ÿ� �ϰ� �ʹٸ� ��������� �ٷＭ �ߺ����Ÿ� �Ͽ� �ϰ��� ����ϸ� ��.
			for(int i = 0 ; i < orderMenu.size(); i ++){
				if(i == (orderMenu.size() -1) ){
					System.out.println(orderMenu.get(i) + "�Ѿ�:"+money);
					
				}else{
					System.out.print(orderMenu.get(i) +" , ");
				}
			}
			return;
			
		}else{
			
			for(int i = 0 ; i < menu.length; i++){
				
				if(visited[i] == 0){
					visited[i] = 1;
					orderMenu.add(menu[i]);
					money += price[i];
					
					order(money , orderMenu);
					
					visited[i] = 0;
					money -= price[i];
					orderMenu.remove(menu[i]);
				}
				
			}	
		}
		
	}
}
