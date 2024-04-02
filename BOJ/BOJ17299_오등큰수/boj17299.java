import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj17299 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			hm.put(key, hm.getOrDefault(key, 0) + 1);
			arr[i] = key;
		}
		
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[N];
		for(int i=N-1; i>=0; i--) {
			if(stack.isEmpty()) {
				res[i] = -1;
			}
			else if(hm.get(stack.peek()) > hm.get(arr[i])) {
				res[i] = stack.peek();
			}
			else {
				boolean chk = false;
				while(!stack.isEmpty()) {
					if(hm.get(stack.peek()) > hm.get(arr[i])) {
						res[i] = stack.peek();
						chk = true;
						break;
					}
					else stack.pop();
				}
				if(!chk) res[i] = -1;
			}
			stack.add(arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
