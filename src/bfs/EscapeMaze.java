package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * �ʺ�켱Ž��(bfs)�� Ȱ���� �̷�Ż��
 * */
public class EscapeMaze {


	static int[][] visited;	//���� �湮�� ��θ� ����� �ش� ��ǥ�� ���� ���̸� �����ϴ� �迭 
	static Queue<Integer> myQ;	//�迭�� �Էµ� ��  (����,���� ��)
	
	static int totMoveCnt = 0;	//�̵�Ƚ��
	
	public static void main(String[] args) {

		/*S:������ , W:�� , G:��ǥ����*/
		String[][] map = { 
                { "S", "0", "0", "0", "W", "0", "W" }, 
                { "W", "0", "W", "0", "0", "0", "0" },
                { "0", "0", "0", "W", "0", "W", "0" }, 
                { "0", "W", "W", "0", "0", "0", "0" },
                { "0", "0", "W", "W", "0", "W", "W" }, 
                { "W", "0", "W", "0", "0", "0", "0" },
                { "0", "0", "0", "W", "0", "0", "G" } };
		
		escapeMaze(map);
		
		System.out.println(totMoveCnt);
	}
	
	/**
	 * �̷�Ż�� �Լ�
	 * @param Ż���� ������ 2�����迭 
	 * */
	public static void escapeMaze(String[][] map){
		
		myQ = new LinkedList<Integer>();	
		visited = new int[map.length][map[0].length];
		
		myQ.add(0);	//���� (������)
		myQ.add(0);  	//���� (������)
		visited[0][0] = 1;
		
		while(! myQ.isEmpty()){
			int x = myQ.poll();	// x ��ǥ
			int y = myQ.poll();	// y ��ǥ
//			System.out.println(myQ.toString());
			
			//���� ���
			if(x -1 >= 0){	// �迭 index ���� �ȿ� ����
				if(visited[x-1][y] == 0){	//���� �湮���� ���� ���
					if(!"W".equals(map[x-1][y])){	// �������ϴ� ���� ��("W")�� �ƴ� ���
						myQ.add(x-1);	
						myQ.add(y);
						visited[x-1][y] = visited[x][y] + 1;	//���� �湮 ����� Ƚ�� + 1
					}
				}
			}
			
			//�Ʒ��� ���
			if(x +1 < map[0].length){
				if(visited[x+1][y] == 0){	//���� �湮���� ���� ���
					if(!"W".equals(map[x+1][y])){	// �������ϴ� ���� ��("W")�� �ƴ� ���
						myQ.add(x+1);	
						myQ.add(y);
						visited[x+1][y] = visited[x][y] + 1;
					}
				}
			}
			
			//���� ���
			if(y -1 >= 0){	// �迭 index ���� �ȿ� ����
				if(visited[x][y-1] == 0){	//���� �湮���� ���� ���
					if(!"W".equals(map[x][y-1])){	// �������ϴ� ���� ��("W")�� �ƴ� ���
						myQ.add(x);	
						myQ.add(y-1);
						visited[x][y-1] = visited[x][y] + 1;	//���� �湮 ����� Ƚ�� + 1
					}
				}
			}
			
			//������
			if(y + 1 < map[0].length){
				if(visited[x][y+1] == 0){	//���� �湮���� ���� ���
					if(!"W".equals(map[x][y+1])){	// �������ϴ� ���� ��("W")�� �ƴ� ���
						myQ.add(x);	
						myQ.add(y+1);
						visited[x][y+1] = visited[x][y] + 1;
					}
				}
			}
		}

		System.out.println("====================");
		//�湮��� ���
	    for (int i = 0; i < 7; i++) {
		    System.out.println(Arrays.toString(visited[i]));
	    }
	    System.out.println("====================");
	    
	    //������� ���
		totMoveCnt = visited[map.length-1][map[0].length-1];
		System.out.println(totMoveCnt); //13
	}

}
