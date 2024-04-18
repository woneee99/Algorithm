import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13335 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<w; i++) {
			q.add(0);
		}
		
		int idx = 0, sum = 0, time = 0;	
		while(!q.isEmpty()) {
			time++;
			sum -= q.poll();
			
			if(idx >= n) continue;
			
			if(sum + arr[idx] <= L) {
				sum += arr[idx];
				q.add(arr[idx]);
				idx++;
			}
			else q.add(0);
		}
		
		System.out.println(time);
	}

}
