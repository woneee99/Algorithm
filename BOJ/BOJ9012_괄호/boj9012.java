import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9012 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			Stack<Character> stack = new Stack<>();
			
			String line = br.readLine();
			
			boolean chk = false;
			for(int j=0; j<line.length(); j++) {
				if(line.charAt(j) == '(') {
					stack.add('(');
				}
				else {
					if(!stack.isEmpty()) {
						stack.pop();
					}
					else {
						chk = true;
						break;
					}
				}
			}
			
			if(chk || !stack.isEmpty()) {
				sb.append("NO").append("\n");
			}
			else sb.append("YES").append("\n");
		}
		System.out.println(sb.toString());
	}

}
