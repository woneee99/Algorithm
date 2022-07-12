import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] brr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();

		stack.add(0);
		for(int i=1; i<n; i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				brr[stack.pop()] = arr[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			brr[stack.pop()] = -1;
		}
		
		for(int i=0; i<n; i++) {
			sb.append(brr[i]).append(" ");
		}
		System.out.println(sb.toString());
		
	}

}
