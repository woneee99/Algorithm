import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2468 {
	static int[][] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		StringTokenizer st;
		int max = 0, min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = arr[i][j] > max ? arr[i][j] : max;
				min = arr[i][j] < min ? arr[i][j] : min;
			}
		}
		int num = 1;
		for(int i=min; i<max; i++) {
			int x = cal(i);
			num = x > num ? x : num;
		}
		System.out.println(num);
	}
	static boolean[][] check;
	static int cal(int x) {
		check = new boolean[n][n];
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j] && arr[i][j] > x) {
					dfs(i, j, x);
					count++;
				}
			}
		}
		return count;
	}
	
	static void dfs(int x, int y, int num) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		if(!check[x][y]) {
			check[x][y] = true;
			for(int i=0; i<4; i++) {
				int x1 = x + dx[i];
				int y1 = y + dy[i];
				
				if(x1 < 0 || y1 < 0 || x1 >= n || y1 >= n) continue;
				if(check[x1][y1]) continue;
				if(arr[x1][y1] <= num) continue;
				dfs(x1, y1, num);
			}	
		}
	}
	
}
