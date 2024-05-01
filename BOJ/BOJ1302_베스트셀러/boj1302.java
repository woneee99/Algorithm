import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class boj1302 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> tm = new TreeMap<>();
		for(int i=0; i<N; i++) {
			String book = br.readLine();
			tm.put(book, tm.getOrDefault(book, 0) + 1);
		}
		
		String res = "";
		int max = 0;
		for(String str : tm.keySet()) {
			if(tm.get(str) > max) {
				res = str;
				max = tm.get(str);
			}
		}
		
		System.out.println(res);
	}

}
