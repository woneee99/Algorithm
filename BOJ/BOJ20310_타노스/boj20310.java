import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj20310 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] S = br.readLine().toCharArray();
		int one = 0, zero = 0;
		for(int i=0; i<S.length; i++) {
			if(S[i] == '1') one++;
			else zero++;
		}
		
		StringBuilder sb = new StringBuilder();
		int nowOne = 0, nowZero = 0;
		for(int i=0; i<S.length; i++) {
			if(S[i] == '0' && nowZero != zero/2) {
				sb.append(0);
				nowZero++;
			}
			else if(S[i] == '1') {
				if(nowOne == one/2) sb.append(1);
				else nowOne++;
			}
		}

		System.out.println(sb.toString());
	}

}
