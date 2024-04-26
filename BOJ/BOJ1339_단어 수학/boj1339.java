import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1339 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] alpha = new int[26];
		String[] words = new String[N];
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			words[i] = word;
		}
		
		for(int i=0; i<N; i++) {
			int tmp = (int) Math.pow(10, words[i].length()-1);
			for(int j=0; j<words[i].length(); j++) {
				alpha[words[i].charAt(j) - 'A'] += tmp;
				tmp /= 10;
			}
		}
		
		Arrays.sort(alpha);
		int max = 9, sum = 0;
		for(int i=alpha.length-1; i>=0; i--) {
			if(alpha[i] == 0) break;
			sum += max * alpha[i];
			max--;
		}
		
		System.out.println(sum);
	}
	

}
