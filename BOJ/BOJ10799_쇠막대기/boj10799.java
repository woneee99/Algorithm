import java.io.*;
import java.util.*;

public class boj10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		Stack<Character> s = new Stack<>();
		int result = 0;
		for(int i=0; i<line.length(); i++){
			char ch = line.charAt(i);
			
			if(ch == '(') {
				s.add(ch);
			}
			else { // ')'
				s.pop();
				
				if(line.charAt(i-1) == ')') {
					result++;
				}
				else {
					result += s.size();
				}
			}
		}
		System.out.println(result);
	}
}
