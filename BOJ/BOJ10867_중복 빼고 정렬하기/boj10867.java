import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj10867 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeSet<Integer> ts = new TreeSet<>();
		for(int i=0; i<N; i++) {
			ts.add(Integer.parseInt(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!ts.isEmpty()) {
			sb.append(ts.pollFirst()).append(" ");
		}
		
		System.out.println(sb);
	}
}
