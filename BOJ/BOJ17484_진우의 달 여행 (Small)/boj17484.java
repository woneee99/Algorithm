import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj17484 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] space = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<Now> pq = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			pq.add(new Now(0, i, -1, space[0][i]));
		}
		
		int[] dy = {-1, 0, 1};
		int res = 1200;
		a : while(!pq.isEmpty()) {
			Now now = pq.poll();
			
			for(int i=0; i<3; i++) {
				if(now.dir == i) continue;
				int ny = now.y + dy[i];
				if(ny < 0 || ny >= M) continue;
				
				if(now.x + 1 == N) {
					res = Math.min(res, now.amount);
					break a;
				}
				pq.add(new Now(now.x+1, ny, i, now.amount + space[now.x+1][ny]));
			}
		}
		System.out.println(res);
	}
	
	static class Now implements Comparable<Now>{
		int x;
		int y;
		int dir;
		int amount;
		
		public Now(int x, int y, int dir, int amount) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.amount = amount;
		}

		@Override
		public int compareTo(Now o) {
			return this.amount - o.amount;
		}
	}
}
