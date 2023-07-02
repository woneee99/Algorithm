import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj11478 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		b = br.readLine();
		
		hs = new HashSet<>();
		for(int i=0; i<b.length(); i++) {
			cal(i, b.charAt(i) + "");
		}
		
		System.out.println(hs.size());
	}
	
	static HashSet<String> hs;
	static String b;
	static void cal(int depth, String str) {
		hs.add(str);
		if(depth >= b.length() - 1) {
			return;
		}
		
		cal(depth+1, str + b.charAt(depth+1));
	}
}
