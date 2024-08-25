import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4307 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			boolean[] chk = new boolean[len+1];
			for(int i=0; i<n; i++) {
				chk[Integer.parseInt(br.readLine())] = true;
			}
			
			int half = len / 2;
			int left = half, right = half;
			while(left > 0) {
				if(chk[left]) break;
				left--;
			}
			while(right < len) {
				if(chk[right]) break;
				right++;
			}
			sb.append(Math.max(left, len - right)).append(" ");
			
			left = 0; right = len;
			while(left <= half) {
				if(chk[left]) break;
				left++;
			}
			while(right > half) {
				if(chk[right]) break;
				right--;
			}
			sb.append(Math.max(len - left, right)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
