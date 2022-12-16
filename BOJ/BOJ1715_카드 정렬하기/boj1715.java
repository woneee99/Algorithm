import java.io.*;
import java.util.*;

public class boj1715 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		while(pq.size() != 1) {
			int one = pq.poll();
			int two = pq.poll();
			
			result += one + two;
			
			pq.add(one+two);
		}
		System.out.println(result);
	}

}
