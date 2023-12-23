import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1411 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] word = new String[N];
		for(int i=0; i<N; i++) {
			word[i] = br.readLine();
		}
		
		int length = word[0].length();
		int res = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				boolean[] word1 = new boolean[26];
				int[] check = new int[26];
				
				boolean[] word2 = new boolean[26];
				boolean isTrue = false;
				for(int o=0; o<length; o++) {
					int idx = word[i].charAt(o) - 'a';
					int comp = word[j].charAt(o) - 'a';
					
					if(word1[idx]) {
						if(comp != check[idx]) {
							isTrue = true;
							break;
						}
					}
					else {
						if(word2[comp]) {
							isTrue = true;
							break;
						}
						word1[idx] = true;
						check[idx] = comp;
						word2[comp] = true;
					}
				}
				if(!isTrue) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
