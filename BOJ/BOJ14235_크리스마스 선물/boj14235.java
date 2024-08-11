import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj14235 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			if(a == 0) {
				sb.append(pq.isEmpty() ? -1 : pq.poll()).append("\n");
				continue;
			}
			
			for(int j=1; j<str.length; j++) {
				pq.add(Integer.parseInt(str[j]));
			}
		}
		
		System.out.println(sb.toString());
	}

}
