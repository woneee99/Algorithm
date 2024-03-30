import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1515 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int N = 0, idx = 0;
		while(idx < line.length()) {
			N++;
			String now = N + "";
			
			for(int i=0; i<now.length(); i++) {
				if(now.charAt(i) == line.charAt(idx)) {
					idx++;
				}
				if(idx == line.length()) {
					break;
				}
			}
		}
		System.out.println(N);
	}

}
