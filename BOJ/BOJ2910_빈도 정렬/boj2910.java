import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class boj2910 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		List<Integer> origin = new ArrayList<>();
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			origin.add(Integer.parseInt(st.nextToken()));
			arr.add(origin.get(i));
			hm.put(origin.get(i), hm.getOrDefault(origin.get(i), 0) + 1);
		}
		
		Collections.sort(arr, (o1, o2) -> {
			if(hm.get(o1) == hm.get(o2)) {
				return origin.indexOf(o1) - origin.indexOf(o2);
			}
			else return hm.get(o2) - hm.get(o1);
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}

}
