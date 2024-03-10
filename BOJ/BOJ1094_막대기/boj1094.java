import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1094 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(64);
		int sum = 64;
		while(sum > X) {
			int min = pq.poll() / 2;
			sum -= min;
			
			if(sum >= X) {
				pq.add(min);
			}
			else {
				sum += min;
				pq.add(min);
				pq.add(min);
			}
		}
		
		System.out.println(pq.size());
	}
}
