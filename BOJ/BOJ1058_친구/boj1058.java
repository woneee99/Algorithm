import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1058 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] friend = new char[N][N];
		for(int i=0; i<N; i++) {
			friend[i] = br.readLine().toCharArray();
		}
		
		int[] cnt = new int[N];
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(friend[i][j] == 'Y') {
					cnt[i]++;
					cnt[j]++;
				}
				else {
					for(int k=0; k<N; k++) {
						if(friend[i][k] == 'Y' && friend[k][j] == 'Y') {
							cnt[i]++;
							cnt[j]++;
							break;
						}
					}
				}
			}
		}
		
		Arrays.sort(cnt);
		System.out.println(cnt[N-1]);
	}
	
}
