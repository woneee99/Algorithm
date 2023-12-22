import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long sum = 0;
		Stack<Integer> write = new Stack<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) sum -= write.pop();
			else {
				sum += num;
				write.push(num);
			}
		}
		
		System.out.println(sum);
	}

}
