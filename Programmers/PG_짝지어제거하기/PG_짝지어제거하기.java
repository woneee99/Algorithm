import java.util.Stack;

public class PG_짝지어제거하기 {

	public static void main(String[] args) {
		String s = "cdcd";
		
		int answer = 1;

		Stack<Character> stack = new Stack<>();
		for(char i : s.toCharArray()) {
			if(!stack.isEmpty() && stack.peek() ==  i) stack.pop();
			else stack.push(i);
		}
		if(stack.isEmpty()) answer = 1;
		else answer = 0;
		System.out.println(answer);
	}
	

}
