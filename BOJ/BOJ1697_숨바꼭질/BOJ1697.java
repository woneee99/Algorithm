import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.println("0");
			return;
		}
		
		int []check = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		check[N] = 0;
		
		if(N>K) {
			System.out.println(N-K);
			return;
		}
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			if(check[K] != 0) break;
			
			if((x-1 >= 0) && check[x-1] == 0 ) {
				check[x-1] = check[x] + 1;
				queue.offer(x-1);
			}
			if((x+1 < check.length) && check[x+1] == 0) {
				check[x+1] = check[x] + 1;
				queue.offer(x+1);
			}
			if((x*2<check.length) && check[x*2] == 0) {
				check[x*2] = check[x]+1;
				queue.offer(x*2);
			}
		}
		System.out.println(check[K]);
	}
}
