import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj16120 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		boolean chk = false;
		for(int i=0; i<str.length; i++) {
			if(str[i] == 'A') {
				if(stack.size() >= 2 && i < str.length - 1 && str[i+1] == 'P') {
					stack.pop();
					stack.pop();
					stack.push('P');
					i++;
				}
				else {
					chk = true;
					break;
				}
			}
			else stack.push('P');
		}
		
		if(stack.size() > 1) chk = true;
		System.out.println(chk ? "NP" : "PPAP");
	}

}
