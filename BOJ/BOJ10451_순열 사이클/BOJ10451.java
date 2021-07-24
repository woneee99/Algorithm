import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int []arr;
	static boolean []check;
	static int N,j;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int cnt = 0;
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N+1];
			for(int j=1; j<=N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			check = new boolean[N+1];
			for(j=1; j<=N; j++) {
				int q = arr[j];
				if(check[j] == false) {
					if(q == j) {
						cnt++;
						check[j] = true;
					}
					else {
						cnt++;
						check(j); 
					}	
				}
			}
			System.out.println(cnt);
		}
	}
	
	static void check(int x) {
		check[x] = true;
		int y = arr[x];
		if(y != j) check(y);
	}
}
