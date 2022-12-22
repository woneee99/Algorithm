import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1244 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(sex == 1) { //남학생
				for(int j=1, nx = num; (nx*j)<=n; j++) {
					arr[nx*j] = arr[nx*j] == 1 ? 0 : 1;
				}
			}
			else { //여학생
				arr[num] = arr[num] == 1 ? 0 : 1;
				for(int j=num+1, k=num-1; j<=n && k > 0; j++, k--) {
					if(arr[j] == arr[k]) {
						arr[j] = arr[j] == 1 ? 0 : 1;
						arr[k] = arr[k] == 1 ? 0 : 1;
					}
					else break;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int chk = 20, origin = 20;
		for(int i=1, j=2; i<=n; i++) {
			if(i==chk) {
				sb.append(arr[i]).append("\n");
				chk = origin * j;
				j++;
			}
			else sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
