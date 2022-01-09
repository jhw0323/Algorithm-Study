package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  입력된 가진 돈 내에서 고를 수 있는 메뉴의 전체목록을 출력하는 클래스 (백트랙킹 사용)
 * */
public class DeliveryFood {

	static int N;	//입력받은 가진 돈
    static int[] price;	//메뉴의 가격 배열
    static String[] menu;	//메뉴명 배열
    static int[] visited;	//재귀함수 호출 시 호출이 된 것을 기록하는 배열
    static HashMap<Integer , ArrayList<String>> totalOrderList;		//최종주문목록 (금액,메뉴List)
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("가진 돈을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ArrayList<String> orderMenu = new ArrayList<String>();	//주문마다 담아놓을 메뉴
		
		totalOrderList = new HashMap<Integer,ArrayList<String>>();
        menu= new String[]{"치킨","피자","족발","중식","곱창","분식","회"};
        price=new int[] {20000,30000,40000,64000,33000,24000,72000};
        visited=new int[menu.length];
        
        order(0 , orderMenu);
        
        System.out.println("최종주문목록 Start");
        for(Map.Entry<Integer, ArrayList<String>> elem : totalOrderList.entrySet()){
        	System.out.println("금액::"+elem.getKey() + "\t\t 메뉴::"+elem.getValue());
        }
        System.out.println("최종주문목록 End");
	}
	
	/**
	 * 메뉴 주문  
	 *
	 * @param money 주문 메뉴 금액
	 * @param orderMenu 주문한 메뉴 목록
	 * */
	@SuppressWarnings("unchecked")
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
			/*
			for(int i = 0 ; i < orderMenu.size(); i ++){
				if(i == (orderMenu.size() -1) ){
					System.out.println(orderMenu.get(i) + "총액:"+money);
					
				}else{
					System.out.print(orderMenu.get(i) +" , ");
				}
			}
			*/
			//최종주문목록에 중복 제거하고 넣는다.
			if(! totalOrderList.containsValue(orderMenu.toString()) && !totalOrderList.containsKey(money)){
				totalOrderList.put(money, (ArrayList<String>) orderMenu.clone());
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
