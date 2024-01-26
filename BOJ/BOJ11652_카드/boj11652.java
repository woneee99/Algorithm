import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj11652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Long, Integer> hm = new HashMap<>();
		int max = 0;
		long res = 0;
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
			
			if(max < hm.get(num)) {
				max = hm.get(num);
				res = num;
			}
			else if(max == hm.get(num)) {
				res = Math.min(res, num);
			}
		}
		
		System.out.println(res);
	}

}
