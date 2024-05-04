import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj12018 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] minM = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] tmp = new int[p];
			for(int j=0; j<p; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(tmp);
			minM[i] = p >= l ? tmp[p-l] : 1;
		}
		
		Arrays.sort(minM);
		int cnt = 0;
		for(int i=0; i<n; i++) {
			m -= minM[i];
			if(m < 0) break;
			cnt++;
		}
		System.out.println(cnt);
	}

}
