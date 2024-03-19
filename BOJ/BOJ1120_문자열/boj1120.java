import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1120 {
	static String A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		
		int res = 51;
		for(int i=0; i <= B.length() - A.length(); i++) {
			int cal = 0;
			for(int j=0; j<A.length(); j++) {
				if(B.charAt(i+j) != A.charAt(j)) {
					cal++;
				}
			}
			res = Math.min(res, cal);
		}
		System.out.println(res);
	}

}
