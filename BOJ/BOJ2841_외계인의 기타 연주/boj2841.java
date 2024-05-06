import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2841 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		Stack<Integer>[] stack = new Stack[N+1];
		for(int i=0; i<=N; i++) {
			stack[i] = new Stack<>();
		}
		
		int res = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int pNum = Integer.parseInt(st.nextToken());
			
			while (!stack[line].isEmpty() && stack[line].peek() > pNum) {
				stack[line].pop();
				res++;
			}
			
			if(stack[line].isEmpty() || stack[line].peek() < pNum) {
				stack[line].push(pNum);
				res++;
			}
		}
		
		System.out.println(res);
	}

}
