import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj2015 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] sum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		long res = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=1; i<=N; i++) {
			if(sum[i] == K) res++;
			res += hm.getOrDefault(sum[i]-K, 0);
			hm.put(sum[i], (hm.getOrDefault(sum[i], 0) + 1));
		}
		System.out.println(res);
	}
}
