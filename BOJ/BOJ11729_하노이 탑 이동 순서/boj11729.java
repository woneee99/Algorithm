import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11729 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int k = (int) (Math.pow(2, n) - 1);
		sb.append(k).append("\n");
		
		hanoi(n, 1,2,3);
		System.out.println(sb.toString());
		
	}

	static void hanoi(int n, int from, int by, int to) {
		if(n == 1) {
			sb.append(from).append(" ").append(to).append("\n");
		}
		else {
			hanoi(n-1, from, to, by);
			sb.append(from).append(" ").append(to).append("\n");
			hanoi(n-1, by, from, to);
		}
	}
}
