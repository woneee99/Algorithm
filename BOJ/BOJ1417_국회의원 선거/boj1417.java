import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj1417 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		int dasom = Integer.parseInt(br.readLine());
		for(int i=1; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int cnt = 0;
		while(!pq.isEmpty()) {
			int person = pq.poll();
			
			if(dasom > person) break;
			
			dasom++;
			cnt++;
			pq.add(person-1);
		}
		
		System.out.println(cnt);
	}
}
