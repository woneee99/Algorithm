import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj1235 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] str = new String[N];
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}
		
		int length = str[0].length();
		for(int i=0; i<length; i++) {
			HashSet<String> hs = new HashSet<>();
			for(int j=0; j<N; j++) {
				hs.add(str[j].substring(length-i-1, length));
			}
			if(hs.size() == N) {
				System.out.println(i+1);
				break;
			}
		}
	}
}
