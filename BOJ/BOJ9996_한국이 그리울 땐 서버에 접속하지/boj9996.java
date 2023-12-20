import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9996 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] pattern = br.readLine().split("\\*");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			int startLength = pattern[0].length();
			int endLength = pattern[1].length();
			
			int lineLength = line.length();
			if(startLength > lineLength || endLength > lineLength || startLength + endLength > lineLength) {
				sb.append("NE");
			}
			else if(line.substring(0, startLength).equals(pattern[0]) && line.substring(lineLength - endLength, lineLength).equals(pattern[1])) {
				sb.append("DA");
			}
			else sb.append("NE");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
