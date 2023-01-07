import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1209 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			
			int max = 0;
			for(int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int chk = 0;
				for(int k=0; k<100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					chk += arr[j][k];
				}
				max = chk > max ? chk : max;
			}
			
			int left = 0, right = 0;
			for(int j=0, l=99; j<100 && l >= 0; j++, l--) {
				int chk = 0;
				for(int k=0; k<100; k++) {
					chk += arr[k][j];
				}
				max = chk > max ? chk : max;
				
				left += arr[j][j];
				right+= arr[l][l];
			}
			
			max = left > max ? left : max;
			max = right > max ? right : max;
			
			sb.append("#").append(n).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
