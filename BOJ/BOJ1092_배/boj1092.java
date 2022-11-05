import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj1092 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 무게 제한
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> limit = new ArrayList<>();
		for(int i=0; i<n; i++) {
			limit.add(Integer.parseInt(st.nextToken()));
		}
		limit.sort(Collections.reverseOrder());
		
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> weight = new ArrayList<>();
		
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			weight.add(Integer.parseInt(st.nextToken()));
		}
		
		weight.sort(Collections.reverseOrder());
		
		if(weight.get(0) > limit.get(0)) {
			System.out.println("-1");
			System.exit(0);
		}
		
		int count = 0;

		while(!weight.isEmpty()) {
			int index = 0;
			for(int i=0; i<n; ) {
				if(index == weight.size()) break;
				else if(limit.get(i) >= weight.get(index)) {
					 weight.remove(index);
					 i++;
				}
				else index++;
			}
			count++;
		}
		
		System.out.println(count);
	}

}
