package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
        //ArrayList<Integer> visitedList=new ArrayList<Integer>();
        //�湮�� ��ǥ�� ������ ��� ArrayList�� �ƴ� HashMap ���·� ó�� �ʿ�.
        HashMap<Integer,ArrayList<Integer>> visitedList = new HashMap<Integer,ArrayList<Integer>> ();
        
        //�湮 Ƚ���� ������ Queue�� visitedQ
        LinkedList<Integer> visitedQ=new LinkedList<Integer>();
        
        int answer = 0;
        pathQ.add(0);
        visitedQ.add(0);
        
        //visitedList.add(0);
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(0);
        visitedList.put(0 , path);
        
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
        	
        	//�湮 ��θ� �����ؾ� �ϴ� ��� �湮�� List�� ���� ����Ҹ� HashMap�� �̿��Ͽ� �����Ͽ� History�� �����.
        	if(! visitedList.containsKey(jump_forward_3)){
        		pathQ.add(jump_forward_3);

        		ArrayList<Integer> jf3 = (ArrayList<Integer>) visitedList.get(now).clone();
        		jf3.add(jump_forward_3);
        		visitedList.put(jump_forward_3 , jf3);
        		
        		visitedQ.add(cnt+1);
        	}
        	
        	if(! visitedList.containsKey(jump_forward_7)){
        		pathQ.add(jump_forward_7);

        		ArrayList<Integer> jf7 = (ArrayList<Integer>) visitedList.get(now).clone();
        		jf7.add(jump_forward_7);
        		visitedList.put(jump_forward_7 , jf7);
        		
        		visitedQ.add(cnt+1);
        	}
        	
        	
        	if(! visitedList.containsKey(jump_back_3)){
        		pathQ.add(jump_back_3);

        		ArrayList<Integer> jb3 = (ArrayList<Integer>) visitedList.get(now).clone();
        		jb3.add(jump_back_3);
        		visitedList.put(jump_back_3 , jb3);
        		
        		visitedQ.add(cnt+1);
        	}
        	
        	
        	if(! visitedList.containsKey(jump_back_7)){
        		pathQ.add(jump_back_7);

        		ArrayList<Integer> jb7 = (ArrayList<Integer>) visitedList.get(now).clone();
        		jb7.add(jump_back_7);
        		visitedList.put(jump_back_7 , jb7);
        		  
        		visitedQ.add(cnt+1);
        	}
        	
        	/* ��� ���� ���� �����ϴ� ����ϴ� ���� �湮 ����Ʈ�� ArrayList�� ����.
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
        	*/
        }
        
        System.out.println("answer::"+answer);
        System.out.print("path history :: ");
        for(int i = 0 ; i < visitedList.get(N).size() ; i ++){
        	System.out.print(visitedList.get(N).get(i));
        	if(i < visitedList.get(N).size() -1){
        		System.out.print(" , ");
        	}
        }
	}

}
