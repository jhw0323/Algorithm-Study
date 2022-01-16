package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * �䳢�� �̵��� ���� ������� ���ϴ� Ŭ����
 * �������� 0, �������� N (�Է°�) �̴�.
 * �̵��� �� �ִ� ����� ���� +3, -3, +7, -7�̴�.
 * �̵� Ƚ���� ������ ������ �ּ������� �̵��ϴ� ���� ��ǥ�� �Ѵ�.
 * */
public class MovingRabit {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        //���� ��ǥ
        LinkedList<Integer> pathQ=new LinkedList<Integer>();

        //�湮�� ��ǥ�� ����� ArrayList�� visitedList (Queue�� poll�Ҷ� ���� ��ǥ�� �ֹߵǴ� �ش� ��ġ�� �湮�ߴ��� �˼� �����Ƿ� ArrayList�� ���)
        ArrayList<Integer> visitedList=new ArrayList<Integer>();
        //�湮 Ƚ���� ������ Queue�� visitedQ
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

        	//���� ��ġ�� �Է¹��� N�ΰ�� �˻� ����
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
