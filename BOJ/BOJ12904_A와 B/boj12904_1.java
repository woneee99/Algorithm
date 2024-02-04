import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj12904_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		int dir = 0, start = 0, end = T.length()-1;
		for(int i=T.length()-1; i>=S.length(); i--) {
			char c = ' ';
			if(dir == 0) {
				c = T.charAt(end);
				end--;
			}
			else {
				c = T.charAt(start);
				start++;
			}
			
			if(c == 'B') {
				dir = dir == 1 ? 0 : 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String res = T.substring(start, end+1);
		if(dir == 1) res = sb.append(res).reverse().toString();
		System.out.println(res.equals(S) ? 1 : 0);
	}

}
