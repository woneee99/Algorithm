import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16987 {
	static int[] dur, w;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dur = new int[N];
		w = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int durable = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			dur[i] = durable;
			w[i] = weight;
		}
		
		cal(0, 0);
		System.out.println(max);
		
	}
	static int max;
	static void cal(int depth, int cnt) {
		if(depth == N) {
			max = Math.max(max, cnt);
			return;
		}
		
		if(dur[depth] <= 0 || cnt == N-1) {
			cal(depth+1, cnt);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(dur[i] <= 0 || depth == i ) {
				continue;
			}

			dur[depth] -= w[i];
			dur[i] -= w[depth];
			
			if(dur[depth] <= 0) {
				cnt++;
			}
			if(dur[i] <= 0) {
				cnt++;
			}
			
			cal(depth+1, cnt);
			if(dur[depth] <= 0) {
				cnt--;
			}
			if(dur[i] <= 0) {
				cnt--;
			}
			dur[depth] += w[i];
			dur[i] += w[depth];
		}
	}
}
