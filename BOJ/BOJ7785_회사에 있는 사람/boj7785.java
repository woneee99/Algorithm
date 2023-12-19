import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj7785 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<String> ts = new TreeSet<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();
			
			if(log.equals("enter")) ts.add(name);
			else ts.remove(name);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!ts.isEmpty()) {
			sb.append(ts.pollLast()).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
