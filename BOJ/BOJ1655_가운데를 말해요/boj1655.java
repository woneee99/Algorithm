import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj1655 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(left.size() == right.size()) {
				left.add(num);
			}
			else right.add(num);
			
			if(!right.isEmpty() && left.peek() > right.peek()) {
				right.add(left.poll());
				left.add(right.poll());
			}
			sb.append(left.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
