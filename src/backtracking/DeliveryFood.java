package backtracking;

import java.util.ArrayList;
import java.util.Scanner;


public class DeliveryFood {

	static int N;	//입력받은 돈
    static int[] price;
    static String[] menu;
    static int[] visited;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("가진 돈을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ArrayList<String> orderMenu = new ArrayList<String>();
		
        menu= new String[]{"치킨","피자","족발","중식","곱창","분식","회"};
        price=new int[] {20000,30000,40000,64000,33000,24000,72000};
        visited=new int[menu.length];
        
        order(0 , orderMenu);
	}
		
	public static void order(int money , ArrayList<String> orderMenu){
		
		//탈출조건
		if(money >= N){
			
			//재귀함수 호출 할 때는 금액이 넘는 가격이 더해져 넘어오기 때문에 맨 마지막에 입력한 메뉴 및 가격을 제거한다.
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
			
			//결과를 String으로 출력하는 거라 중복 메뉴를 발라낼 수 없다. 중복 제거를 하고 싶다면 멤버변수로 다뤄서 중복제거를 하여 일괄로 출력하면 됨.
			for(int i = 0 ; i < orderMenu.size(); i ++){
				if(i == (orderMenu.size() -1) ){
					System.out.println(orderMenu.get(i) + "총액:"+money);
					
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
