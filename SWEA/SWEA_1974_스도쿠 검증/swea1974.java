import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1974 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			boolean chk = true;
			
			int[][] arr = new int[9][9];
			for(int j=0; j<9; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int[] check = new int[10];
				for(int k=0; k<9; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					
					if(check[arr[j][k]] != 0) { //열 검사
						chk = false;
					}
					else check[arr[j][k]] = 1; 
				}
			}
			
			if(chk == false) {
				sb.append("#").append(i).append(" ").append(0).append("\n");
				continue;
			}
			
			for(int j=0; j<9; j++) { //행 검사
				int[] check = new int[10];
				for(int k=1; k<9; k++) {
					if(check[arr[k][j]] != 0) {
						chk = false;
						break;
					}
					else check[arr[k][j]] = 1; 
				}
				if(chk == false) break;
			}
			
			if(chk == false) {
				sb.append("#").append(i).append(" ").append(0).append("\n");
				continue;
			}
			
			a : for(int j=0; j<9; j+=3) {
				for(int k=0; k<9; k+=3) {
					int[] check = new int[10];
					for(int s = j; s<j+3; s++) {
						for(int m = k; m<k+3; m++) {
							if(check[arr[s][m]] != 0) {
								chk = false;
								break a;
							}
							else check[arr[s][m]] = 1;
						}
					}
				}
			}
			
			if(chk == false) {
				sb.append("#").append(i).append(" ").append(0).append("\n");
				continue;
			}
			sb.append("#").append(i).append(" ").append(1).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
