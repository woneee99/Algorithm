import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		StringBuilder sb = new StringBuilder();
		
		while((line = br.readLine()) != null){
			if(line.charAt(0) == '.') {
				break;
			}
			Stack<Character> s = new Stack<>();
			boolean check = true;
			for(int i=0; i<line.length()-1; i++) {
				if(line.charAt(i) == '[' || line.charAt(i) == '(') {
					s.add(line.charAt(i));
				}
				else if(line.charAt(i) == ']') {
					if(s.isEmpty() || s.pop() != '[') {
						check = false;
						break;
					}
				}
				else if(line.charAt(i) == ')'){
					if(s.isEmpty() || s.pop() != '(') {
						check = false;
						break;
					}
				}
			}
			if(check && s.isEmpty()) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
