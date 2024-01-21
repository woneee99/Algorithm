import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1021 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			dq.add(i);
		}
		
		int res = 0;
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(Integer n : dq) {
				if(n == num) {
					break;
				}
				cnt++;
			}
			
			if(cnt <= N - cnt) {
				while(true) {
					int who = dq.poll();
					if(who == num) break;
					dq.addLast(who);
					res++;
				}
			}
			else {
				while(true) {
					int who = dq.pollLast();
					res++;
					if(who == num) break;
					dq.addFirst(who);
				}
			}
			N--;
		}
		
		System.out.println(res);
	}

}
