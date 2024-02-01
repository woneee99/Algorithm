import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1080 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] A = new char[N][M];
		char[][] B = new char[N][M];
		for(int i=0; i<N; i++) {
			A[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			B[i] = br.readLine().toCharArray();
		}
		
		int res = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] != B[i][j] && i+2 < N && j+2 < M) {
					for(int r=i; r<i+3; r++) {
						for(int c=j; c<j+3; c++) {
							A[r][c] = A[r][c] == '1' ? '0' : '1';
						}
					}
					res++;
				}
			}
		}
		
		boolean chk = false;
		a : for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] != B[i][j]) {
					chk = true;
					break a;
				}
			}
		}
		
		res = chk ? -1 : res;
		System.out.println(res);
	}

}
