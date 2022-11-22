import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj3584 {
	static int[] arr;
	static boolean[] chk;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine()); //노드 수
			arr = new int[n+1];
			chk = new boolean[n+1];
			
			for(int i=0; i<n-1; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int son = Integer.parseInt(st.nextToken());
				arr[son] = parent;
			}
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			cal(one);
			result = 0;
			cal(two);
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void cal(int x) {
		while(x != 0) {
			if(chk[x]) {
				result = x;
				return;
			}
			else {
				chk[x] = true;
				x = arr[x];
			}
		}
	}
}
