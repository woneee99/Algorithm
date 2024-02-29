import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj1822_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int na = Integer.parseInt(st.nextToken());
		int nb = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> ts = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<na; i++) {
			ts.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<nb; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(ts.contains(num)) {
				ts.remove(num);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ts.size()).append("\n");
		
		for(int n : ts) {
			sb.append(n).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
}
