import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj5582 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		String line2 = br.readLine();
		
		int[][] str = new int[line1.length()+1][line2.length()+1];
		int max = 0;
		for(int i=1; i<=line1.length(); i++) {
			for(int j=1; j<=line2.length(); j++) {
				if(line1.charAt(i-1) == line2.charAt(j-1)) {
					str[i][j] = str[i-1][j-1] + 1;
					max = Math.max(max, str[i][j]);
				}
			}
		}
		
		System.out.println(max);
	}

}
