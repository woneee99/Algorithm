import java.io.*;
import java.util.*;

public class boj1927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				}
				else sb.append(0).append("\n");
			}
			else {
				pq.add(num);
			}
		}
		System.out.println(sb.toString());
		
	}

}
