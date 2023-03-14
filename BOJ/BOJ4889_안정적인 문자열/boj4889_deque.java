import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj4889_deque {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = 1;
		while(true) {
			String line = br.readLine();
			if(line.charAt(0) == '-') break;
			Deque<Character> dq = new ArrayDeque<>();
			
			int sz = 0;
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i) == '{') dq.add('{');
				else {
					if(dq.isEmpty()) {
						sz++;
						dq.add('}');
					}
					else dq.poll();
				}
			}
			
			sz += dq.size() / 2;
			sb.append(T++).append(". ").append(sz).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
