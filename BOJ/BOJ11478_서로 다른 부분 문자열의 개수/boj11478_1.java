import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj11478_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String b = br.readLine();
		
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<b.length(); i++) {
			for(int j=i; j<b.length(); j++) {
				hs.add(b.substring(i, j+1));
			}
		}
		System.out.println(hs.size());
	}
}
