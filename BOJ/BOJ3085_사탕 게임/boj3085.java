import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj3085 {
	static int N, max;
	static char[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			arr[i] = line.toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int nx = i;
				int ny = j+1;
				if(ny < N && arr[nx][ny] != arr[i][j]) {
					swap(i, j, nx, ny);
					cal();
					swap(i, j, nx, ny);
				}
				
				nx = i+1; 
				ny = j;
				if(nx < N && arr[nx][ny] != arr[i][j]) {
					swap(i, j, nx, ny);
					cal();
					swap(i, j, nx, ny);
				}
			}
		}
		System.out.println(max);
	}
	static void cal() {
		for(int i=0; i<N; i++) {
			int cnt1 = 0, cnt2 = 0;
			for(int j=1; j<N; j++) {
				if(arr[i][j] == arr[i][j-1]) {
					cnt1++;
				}
				else {
					if(cnt1 != 0) {
						max = Math.max(max, cnt1+1);
						cnt1 = 0;
					}
				}
				if(arr[j][i] == arr[j-1][i]) {
					cnt2++;
				}
				else {
					if(cnt2 != 0) {
						max = Math.max(max, cnt2+1);
						cnt2 = 0;
					}
				}
			}
			if(cnt1 != 0) {
				max = Math.max(max, cnt1+1);
			}
			if(cnt2 != 0) {
				max = Math.max(max, cnt2+1);
			}
		}
	}
	static void swap(int i, int j, int nx, int ny) {
		char tmp = arr[i][j];
		arr[i][j] = arr[nx][ny];
		arr[nx][ny] = tmp;
	}
}
