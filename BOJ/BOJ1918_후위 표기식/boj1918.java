import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Line = br.readLine();

		Stack<Character> stack = new Stack<>();
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < Line.length(); i++) {
			char c = Line.charAt(i);
			if(c == '+' || c == '-' || c == '*' || c == '/') {
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
					str.append(stack.pop());
				}
				stack.add(c);
			}
			else if (c == '(') {
				stack.add(c);
			} 
			else if (c == ')') {
				while(stack.peek() != '(') {
					str.append(stack.pop());
				}
				stack.pop();
			} 
			else { // 알파벳
				str.append(c);
			}
		}

		while(!stack.isEmpty()) {
			str.append(stack.pop());
		}
		System.out.println(str.toString());
	}
	static int priority(char c) {
		if(c == '(' || c == ')') return 0;
		else if(c == '+' || c == '-') return 1;
		else return 2;
	}
}
