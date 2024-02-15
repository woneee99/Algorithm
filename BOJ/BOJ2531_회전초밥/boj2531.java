import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj2531 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); // ¿¬¼ÓÀ¸·Î ¸Ô´Â ÃÊ¹ä ¼ö
		int c = Integer.parseInt(st.nextToken());
		
		int[] rail = new int[N];
		for(int i=0; i<N; i++) {
			rail[i] = Integer.parseInt(br.readLine());
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<k; i++) {
			hm.put(rail[i], hm.getOrDefault(rail[i], 0) + 1);
		}
		
		int max = hm.containsKey(c) ? hm.size() : hm.size() + 1;
		for(int i=k, cnt=0; i<N+k-1; i++) {
			if(i < N) hm.put(rail[i], hm.getOrDefault(rail[i], 0) + 1);
			else {
				hm.put(rail[cnt], hm.getOrDefault(rail[cnt], 0) + 1);
				cnt++;
			}
			
			if(hm.containsKey(rail[i-k])) {
				int val = hm.get(rail[i-k]);
				if(val == 1) hm.remove(rail[i-k]);
				else hm.replace(rail[i-k], val - 1);	
			}

			int cal = hm.containsKey(c) ? hm.size() : hm.size() + 1;
			max = Math.max(max, cal);
		}
		
		System.out.println(max);
	}

}
