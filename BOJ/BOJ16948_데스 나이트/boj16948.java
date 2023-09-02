import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16948 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		int[] dx = {-2, -2, 0, 0, 2, 2};
		int[] dy = {-1, 1, -2, 2, -1, 1};
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r1, c1, 0));
		map[r1][c1] = 1;
		
		int res = -1;
		while(!q.isEmpty()) {
			Node pol = q.poll();
			
			if(pol.x == r2 && pol.y == c2) {
				res = pol.cnt;
				break;
			}

			for(int i=0; i<6; i++) {
				int nx = dx[i] + pol.x;
				int ny = dy[i] + pol.y;
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 1) continue;
				map[nx][ny] = 1;
				q.add(new Node(nx, ny, pol.cnt + 1));
			}
		}
		
		System.out.println(res);
	}
	
	static class Node {
		int x; 
		int y; 
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
