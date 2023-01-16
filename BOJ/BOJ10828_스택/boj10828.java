import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10828 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if(command.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(command.equals("pop")) {
				if(stack.size() == 0) sb.append(-1).append("\n");
				else sb.append(stack.pop()).append("\n");
			}
			else if(command.equals("size")) {
				sb.append(stack.size()).append("\n");
			}
			else if(command.equals("empty")) {
				if(stack.size() == 0) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(command.equals("top")) {
				if(stack.size() == 0) sb.append(-1).append("\n");
				else sb.append(stack.peek()).append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
