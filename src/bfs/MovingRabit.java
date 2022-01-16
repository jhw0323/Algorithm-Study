package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토끼의 이동에 대한 최적경로 구하는 클래스
 * 시작점은 0, 도착점은 N (입력값) 이다.
 * 이동할 수 있는 경우의 수는 +3, -3, +7, -7이다.
 * 이동 횟수는 제한이 없으나 최소한으로 이동하는 것을 목표로 한다.
 * */
public class MovingRabit {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        //현재 좌표
        LinkedList<Integer> pathQ=new LinkedList<Integer>();

        //방문한 좌표를 기록할 ArrayList인 visitedList (Queue는 poll할때 기존 좌표가 휘발되니 해당 위치를 방문했는지 알수 없으므로 ArrayList를 사용)
        ArrayList<Integer> visitedList=new ArrayList<Integer>();
        //방문 횟수를 저장할 Queue인 visitedQ
        LinkedList<Integer> visitedQ=new LinkedList<Integer>();
        
        int answer = 0;
        pathQ.add(0);
        visitedQ.add(0);
        visitedList.add(0);
        
        while (true){
        	
        	int now = pathQ.poll();
        	int cnt = visitedQ.poll();
        	
        	int jump_forward_3 = now + 3;
        	int jump_forward_7 = now + 7;
        	int jump_back_3 = now -3;
        	int jump_back_7 = now - 7;

        	//현재 위치가 입력받은 N인경우 검색 종료
        	if(now == N){
        		answer = cnt;
        		break;
        	}
        	
        	if(!visitedList.contains(jump_forward_3)){
        		pathQ.add(jump_forward_3);
        		visitedList.add(jump_forward_3);
        		visitedQ.add(cnt+1);
        	}
        	
        	if(!visitedList.contains(jump_forward_7)){
        		pathQ.add(jump_forward_7);
        		visitedList.add(jump_forward_7);
        		visitedQ.add(cnt+1);
        	}
        	
        	if(!visitedList.contains(jump_back_3)){
        		pathQ.add(jump_back_3);
        		visitedList.add(jump_back_3);
        		visitedQ.add(cnt+1);
        	}
        	
        	if(!visitedList.contains(jump_back_7)){
        		pathQ.add(jump_back_7);
        		visitedList.add(jump_back_7);
        		visitedQ.add(cnt+1);
        	}
        	
        }
        
        System.out.println("answer::"+answer);
        
	}

}
