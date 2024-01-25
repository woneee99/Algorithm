import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9935 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        
        int bombLength = bomb.length();
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
        	char c = str.charAt(i);
    		s.push(c);

        	if(c == bomb.charAt(bombLength - 1)) {
        		if(s.size() < bombLength) continue;
        		
        		boolean chk = false;
        		int idx = 1;
        		for(int j=bombLength-1; j>=0; j--, idx++) {
        			if(s.get(s.size() - idx) != bomb.charAt(j)) {
        				chk = true;
        				break;
        			}
        		}
        		
        		if(!chk) {
        			for(int j=0; j<bombLength; j++) {
        				s.pop();
            		}
        		}
        	}
        }
        
        if(!s.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while(!s.isEmpty()) {
            	sb.append(s.pop());
            }
            System.out.println(sb.reverse());
        }
        else System.out.println("FRULA");
	}
}
