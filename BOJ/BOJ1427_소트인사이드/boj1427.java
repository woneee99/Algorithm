import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1427 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		Arrays.sort(N);
		
		StringBuilder sb = new StringBuilder();
		for(int i=N.length-1; i>=0; i--) {
			sb.append(N[i]);
		}
		System.out.println(sb);
	}

}
