import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj20920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			if(word.length() < M) continue;
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		ArrayList<String> array = new ArrayList<>(map.keySet());
		array.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(map.get(o1) == map.get(o2)) {
					if(o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					else return o2.length() - o1.length();
				}
				return map.get(o2) - map.get(o1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String str : array) {
			sb.append(str).append("\n");
		}
		System.out.println(sb.toString());
	}

}
