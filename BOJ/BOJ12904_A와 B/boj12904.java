import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj12904 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		Deque<Character> q = new ArrayDeque<>();
		for(int i=0; i<T.length(); i++) {
			q.add(T.charAt(i));
		}
		
		int dir = 0;
		for(int i=T.length()-1; i>=S.length(); i--) {
			char c = dir == 0 ? q.pollLast() : q.pollFirst();
			if(c == 'B') {
				dir = dir == 1 ? 0 : 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			sb.append(q.poll());
		}
		
		String res = "";
		res = dir == 1 ? sb.reverse().toString() : sb.toString();
		System.out.println(res.equals(S) ? 1 : 0);
	}

}
