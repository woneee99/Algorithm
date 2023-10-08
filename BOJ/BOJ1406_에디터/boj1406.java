import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class boj1406 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String init = br.readLine();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		int idx = init.length();
		for(int i=0; i<idx; i++) {
			left.push(init.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			switch(line.charAt(0)) {
			case 'L':
				if(left.size() > 0) right.push(left.pop());
				break;
			case 'D':
				if(right.size() > 0) left.push(right.pop());
				break;
			case 'B':
				if(left.size() > 0) left.pop();
				break;
			case 'P':
				left.push(line.charAt(2));
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!right.isEmpty()) {
			left.push(right.pop());
		}
		while(!left.isEmpty()) {
			sb.append(left.pop());
		}

		System.out.println(sb.reverse());
	}

}
