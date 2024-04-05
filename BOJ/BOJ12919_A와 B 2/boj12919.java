import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj12919 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		cal(T, S);
		System.out.println(chk ? 1 : 0);
	}
	
	static boolean chk;
	static void cal(String T, String S) {
		if(chk || T.length() < S.length()) return;
		if(T.length() == S.length()) {
			if(T.equals(S)) chk = true;
			return;
		}
		
		if(T.charAt(T.length()-1) == 'A') {
			cal(T.substring(0, T.length()-1), S);
		}
		if(T.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(T);
			sb.deleteCharAt(0);
			sb.reverse();
			cal(sb.toString(), S);
		}
	}
}
