import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int r = Integer.parseInt(st.nextToken()); 
		int c = Integer.parseInt(st.nextToken()); 
		
		
		int x = 0; 
		
		for(int i=0; r!=0 || c !=0 ; i+=2) {
			if(r%2 == 1) x += Math.pow(2, i+1);
			if(c%2 == 1) x += Math.pow(2, i);
			
			r = r/2;
			c = c/2;
		}
		System.out.println(x);
	}

}
