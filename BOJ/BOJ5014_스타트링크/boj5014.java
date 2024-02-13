import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 총 
		int S = Integer.parseInt(st.nextToken()); // 현재
		int G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		if(G == S) {
			System.out.println(0);
			System.exit(0);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		
		boolean[] chk = new boolean[F+1];
		chk[S] = true;
		
		boolean res = false;
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			cnt++;
			for(int i=0; i<size; i++) {
				int now = q.poll();
				
				int up = now + U;
				int down = now - D;
				
				if(up == G || down == G) {
					res = true;
					break;
				}
				
				if(up <= F && !chk[up]) {
					chk[up] = true;
					q.add(up);
				}
				if(down > 0 && !chk[down]) {
					chk[down] = true;
					q.add(down);
				}
			}
			if(res) break;
		}
		
		System.out.println(!res ? "use the stairs" : cnt);
		
	}
}
