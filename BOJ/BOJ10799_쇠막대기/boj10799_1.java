import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10799_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int left = 0, res = 0;
		for(int i=0; i<line.length(); i++) {
			if(line.charAt(i) == '(') left++;
			else {
				left--;
				if(line.charAt(i-1) == '(') res += left;
				else res++;
			}
		}
		System.out.println(res);
	}

}
