import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
	static StringBuilder sb = new StringBuilder();
	static boolean[][] list;
	static boolean[][] check;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());// 횟수
		
		for(int i=0; i<num; i++) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // x
			n = Integer.parseInt(st.nextToken()); // y
			int k = Integer.parseInt(st.nextToken()); // 배추 개수

			list = new boolean[n][m];
			check = new boolean[n][m];
			
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list[y][x] = true;
			}
			for(int j=0; j<n; j++) {
				for(int l=0; l<m; l++) {
					if(checkList(j,l) == true) {
						count++;
						DFS(j,l);
					}
				}
			}
			sb.append(count+"\n");
		} // 큰 for 문 끝
		System.out.println(sb);
	}
	public static boolean checkList(int row, int col) {
		if(row<0 || row>=n || col<0 || col>= m) {
			return false;
		}
		if(check[row][col] == true || list[row][col] == false) {
			return false;
		}
		return true;
	}
	public static void DFS(int x, int y) {
		check[x][y] = true;
		
		if(checkList(x+1, y)) DFS(x+1, y);
		if(checkList(x, y+1)) DFS(x, y+1);
		if(checkList(x-1, y)) DFS(x-1, y);
		if(checkList(x, y-1)) DFS(x, y-1);
	}
}
