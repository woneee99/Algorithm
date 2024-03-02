import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2110 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] room = new int[N];
		for(int i=0; i<N; i++) {
			room[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(room);
		int res = 0;
		int left = 0, right = room[N-1] - room[0];
		while(left <= right) {
			int cnt = 1;
			int first = room[0];
			
			int mid = (left + right) / 2;
			for(int i=1; i<N; i++) {
				if(room[i] - first >= mid) {
					cnt++;
					first = room[i];
				}
			}
			
			if(cnt >= C) {
				res = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(res);
	}
	
}
