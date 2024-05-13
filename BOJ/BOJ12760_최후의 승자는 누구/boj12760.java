import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj12760 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr[i]);
		}
		
		int[] score = new int[N];
		for(int i=M-1; i>=0; i--) {
			int[] check = new int[N];
			for(int j=0; j<N; j++) {
				check[j] = arr[j][i];
			}
			Arrays.sort(check);
			
			for(int j=0; j<N; j++) {
				if(check[N-1] == arr[j][i]) score[j]++;
			}
		}
		
		int[] chk = Arrays.copyOf(score, N);
		Arrays.sort(chk);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			if(score[i] == chk[N-1]) sb.append(i+1).append(" ");
		}
		System.out.println(sb.toString());
	}

}
