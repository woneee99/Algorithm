import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10971 {
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check = new boolean[n];
		
		for(int i=0; i<n; i++) {
			check[i] = true;
			start = i;
			cal(1, i, 0);
			check[i] = false;
		}
		
		System.out.println(min);
	}
	
	static int min = Integer.MAX_VALUE, start = 0;
	static boolean[] check;
	
	static void cal(int depth, int now, int sum) {
		if(depth == n) {
			if(arr[now][start] != 0 ) {
				sum += arr[now][start];
				min = min > sum ? sum : min;
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!check[i] && arr[now][i] != 0) {
				check[i] = true;
				cal(depth+1, i, sum + arr[now][i]);
				check[i] = false;
			}	
		}
	}
}
