import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class boj2910_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new LinkedHashMap<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		
		List<Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(Entry<Integer, Integer> entry : list) {
			for(int i=0; i<entry.getValue(); i++) {
				sb.append(entry.getKey()).append(" ");
			}
		}
		System.out.println(sb.toString());
	}

}
