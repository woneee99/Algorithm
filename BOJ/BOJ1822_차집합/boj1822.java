import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1822 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int na = Integer.parseInt(st.nextToken());
		int nb = Integer.parseInt(st.nextToken());
		
		String line = br.readLine();
		
		HashSet<Integer> hs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<nb; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		st = new StringTokenizer(line);
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<na; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!hs.contains(num)) {
				cnt++;
				arr.add(num);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++) {
			sb.append(arr.get(i)).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
}
