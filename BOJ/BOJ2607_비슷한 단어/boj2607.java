import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2607 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String first = br.readLine();
		int res = 0;
		for(int i=1; i<N; i++) {
			String now = br.readLine();
			
			int[] word = new int[26];
			for(int j=0; j<first.length(); j++) {
				word[first.charAt(j) - 'A']++;
			}
			
			int cnt = 0;
			for(int j=0; j<now.length(); j++) {
				if(word[now.charAt(j) - 'A'] > 0) {
					word[now.charAt(j) - 'A']--;
					cnt++;
				}
			}
			
			if(first.length() == now.length() && (first.length() == cnt || first.length() - 1 == cnt)) res++;
			else if(first.length() == now.length() - 1 && now.length() - 1 == cnt) res++;
			else if(first.length() == now.length() + 1 && now.length() == cnt) res++;
		}
		
		System.out.println(res);
	}

}
