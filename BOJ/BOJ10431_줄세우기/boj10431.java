import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10431 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			
			arr = new int[20];
			
			int cnt = 0;
			arr[0] = Integer.parseInt(st.nextToken());
			for(int j=1; j<20; j++) {
				int student = Integer.parseInt(st.nextToken());
				
				arr[j] = student;
				int now = j;
				for(int k=j-1; k>=0; k--) {
					if(arr[k] > student) {
						swap(k, now);
						cnt++;
						now--;
					}
					else break;
				}
			}
			
			sb.append(T).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void swap(int i, int j) {
		int x = arr[i];
		arr[i] = arr[j];
		arr[j] = x;
	}

}
