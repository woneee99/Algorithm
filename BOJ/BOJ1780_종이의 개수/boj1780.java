import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1780 {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // n 
		
		StringTokenizer st;
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cal(0, 0, n);
		System.out.print(result[0] + "\n" + result[1] + "\n" + result[2]);
	}
	
	static int[] result = new int[3];
	static void cal(int x, int y, int size) {
		boolean check = false;
		int chk = arr[x][y];
		a : for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(arr[i][j] != chk) {
					check = true;
					break a;
				}
			}
		}
		
		if(check) {
			size /= 3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cal(x + (size * i), y + (size * j), size);
				}
			}
		}
		else result[chk+1]++;
	}
}
