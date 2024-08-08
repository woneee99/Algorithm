import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj25192 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();

		int res = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.equals("ENTER")) {
				res += hs.size();
				hs.clear();
			}
			else hs.add(str);
		}
		res += hs.size();
		System.out.println(res);
	}

}
