import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20922 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cal = new int[100_001];
		int cnt = 0, max = 0;
		int front = 0;
		for(int i=0; i<N; i++) {
			int num = arr[i];
			if(cal[num] < M) {
				cal[num]++;
				cnt++;
				max = Math.max(max, cnt);
				continue;
			}
			while(cal[num] == M) {
				cal[arr[front]]--;
				cnt--;
				front++;
			}
			cnt++;
			cal[num]++;
		}
		System.out.println(max);
	}

}
