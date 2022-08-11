import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6603 {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			if(n == 0) break;
			
			arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			check = new boolean[n];
			cal(0, 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	static void cal(int depth, int index) {
		if(depth == 6) {
			for(int i=0; i<check.length; i++) {
				if(check[i]) sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=index; i<check.length; i++) {
			if(!check[i]) {
				check[i] = true;
				cal(depth+1, i+1);
				check[i] = false;
			}
		}
	}
}
