import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1374 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> start = new PriorityQueue<>();
		PriorityQueue<Long> end = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			start.add(Long.parseLong(st.nextToken()));
			end.add(Long.parseLong(st.nextToken()));
		}
		
		int cnt = 0, res = 0;
		while(!start.isEmpty()) {
			long s = start.peek();
			long e = end.peek();
			
			if(s < e) {
				start.poll();
				cnt++;
				res = Math.max(res, cnt);
			}
			else {
				end.poll();
				cnt--;
			}
		}
		System.out.println(res);
	}
}
