import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj1544 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> hs = new HashSet<>();
		hs.add(br.readLine());
		for(int i=1; i<N; i++) {
			String word = br.readLine();
			
			String originWord = word;
			boolean isTrue = false;
			int length = word.length();
			for(int j=0; j<length-1; j++) {
				word += word.charAt(j);
				String check = word.substring(word.length() - length, word.length());
				
				if(hs.contains(check)) {
					isTrue = true;
					break;
				}
			}
			if(!isTrue) hs.add(originWord);
		}
		
		System.out.println(hs.size());
	}

}
