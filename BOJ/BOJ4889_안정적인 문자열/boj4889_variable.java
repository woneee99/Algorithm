import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj4889_variable {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = 1;
		while(true) {
			String line = br.readLine();
			if(line.charAt(0) == '-') break;
			
			int res = 0, start = 0;
			for(char ch : line.toCharArray()) {
				if(ch == '}' && start == 0) {
					res++;
					ch = '{';
				}
				if(ch == '{') start++;
				else {
					start--;
				}
			}

			sb.append(T++).append(". ").append(res + start/2).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
