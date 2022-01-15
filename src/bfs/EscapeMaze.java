package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 너비우선탐색(bfs)을 활용한 미로탈출
 * */
public class EscapeMaze {


	static int[][] visited;	//이전 방문한 경로를 기억해 해당 좌표에 도달 길이를 적재하는 배열 
	static Queue<Integer> myQ;	//배열에 입력된 값  (가로,세로 순)
	
	static int totMoveCnt = 0;	//이동횟수
	
	public static void main(String[] args) {

		/*S:시작점 , W:벽 , G:목표지점*/
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
	 * 미로탈출 함수
	 * @param 탈출할 지도의 2차원배열 
	 * */
	public static void escapeMaze(String[][] map){
		
		myQ = new LinkedList<Integer>();	
		visited = new int[map.length][map[0].length];
		
		myQ.add(0);	//시작 (가로점)
		myQ.add(0);  	//시작 (세로점)
		visited[0][0] = 1;
		
		while(! myQ.isEmpty()){
			int x = myQ.poll();	// x 좌표
			int y = myQ.poll();	// y 좌표
//			System.out.println(myQ.toString());
			
			//위쪽 노드
			if(x -1 >= 0){	// 배열 index 범위 안에 있음
				if(visited[x-1][y] == 0){	//아직 방문하지 않은 경우
					if(!"W".equals(map[x-1][y])){	// 가고자하는 점이 벽("W")이 아닌 경우
						myQ.add(x-1);	
						myQ.add(y);
						visited[x-1][y] = visited[x][y] + 1;	//이전 방문 경로의 횟수 + 1
					}
				}
			}
			
			//아래쪽 노드
			if(x +1 < map[0].length){
				if(visited[x+1][y] == 0){	//아직 방문하지 않은 경우
					if(!"W".equals(map[x+1][y])){	// 가고자하는 점이 벽("W")이 아닌 경우
						myQ.add(x+1);	
						myQ.add(y);
						visited[x+1][y] = visited[x][y] + 1;
					}
				}
			}
			
			//왼쪽 노드
			if(y -1 >= 0){	// 배열 index 범위 안에 있음
				if(visited[x][y-1] == 0){	//아직 방문하지 않은 경우
					if(!"W".equals(map[x][y-1])){	// 가고자하는 점이 벽("W")이 아닌 경우
						myQ.add(x);	
						myQ.add(y-1);
						visited[x][y-1] = visited[x][y] + 1;	//이전 방문 경로의 횟수 + 1
					}
				}
			}
			
			//오른쪽
			if(y + 1 < map[0].length){
				if(visited[x][y+1] == 0){	//아직 방문하지 않은 경우
					if(!"W".equals(map[x][y+1])){	// 가고자하는 점이 벽("W")이 아닌 경우
						myQ.add(x);	
						myQ.add(y+1);
						visited[x][y+1] = visited[x][y] + 1;
					}
				}
			}
		}

		System.out.println("====================");
		//방문경로 출력
	    for (int i = 0; i < 7; i++) {
		    System.out.println(Arrays.toString(visited[i]));
	    }
	    System.out.println("====================");
	    
	    //최종경로 출력
		totMoveCnt = visited[map.length-1][map[0].length-1];
		System.out.println(totMoveCnt); //13
	}

}
