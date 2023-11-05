import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1495 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] play = new int[M+1];
		Arrays.fill(play, -1);
		
		st = new StringTokenizer(br.readLine());
		play[S] = 0;
		for(int i=1; i<=N; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> arr = new ArrayList<>();
			for(int s = 0; s<=M; s++) {
				if(play[s] == i-1) {
					if(s + x <= M) {
						arr.add(s+x);
					}
					if(s - x >= 0) {
						arr.add(s-x);
					}
				}
			}
			
			if(arr.size() == 0) {
				System.out.println(-1);
				return;
			}
			
			for(int s : arr) {
				play[s] = i;
			}
		}
		
		for(int i=M; i>=0; i--) {
			if(play[i] == N) {
				System.out.println(i);
				break;
			}
		}
	}

}
