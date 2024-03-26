import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj19638 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long H = Long.parseLong(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		int cnt = 0;
		while(T--> 0) {
			if(pq.peek() == 1 || pq.peek() < H) break;
			pq.add(pq.poll() / 2);
			cnt++;
		}
		
		if(pq.peek() < H) {
			System.out.println("YES");
			System.out.println(cnt);
		}
		else {
			System.out.println("NO");
			System.out.println(pq.peek());
		}
	}
}
