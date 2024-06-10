import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj2002 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<String> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			q.add(str);
		}
		
		int res = 0;
		for(int i=0; i<N; i++) {
			String now = br.readLine();
			
			if(now.equals(q.peek())) {
				q.poll();
			}
			else {
				q.remove(now);
				res++;
			}
		}
		System.out.println(res);
	}

}
