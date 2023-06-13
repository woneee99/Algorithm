import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class boj5397 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			
			LinkedList<Character> ll = new LinkedList<>();
			ListIterator<Character> li = ll.listIterator();
			
			for(int j=0; j<line.length(); j++) {
				char c = line.charAt(j);
				if(c == '<') {
					if(li.hasPrevious()) li.previous();
				}
				else if(c == '>') {
					if(li.hasNext()) li.next();
				}
				else if(c == '-'){
					if(li.hasPrevious()) {
						li.previous();
						li.remove();
					}
				}
				else {
					li.add(c);
				}
			}
			
			for(char c : ll) {
				sb.append(c);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
