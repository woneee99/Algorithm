import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj15903 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0; i<m; i++) {
			long x = pq.poll() + pq.poll();
			
			pq.add(x);
			pq.add(x);
		}
		
		long res = 0;
		while(!pq.isEmpty()) {
			res += pq.poll();
		}
		
		System.out.println(res);
	}

}
