import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1439 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int oneCnt = 0, zeroCnt = 0;
		int past = 0;
		for(int i=0; i<line.length(); i++) {
			int now = line.charAt(i) - '0';
			if(i == 0 || past != now) {
				if(now == 0) zeroCnt++;
				else oneCnt++;
			}
			past = now;
		}
		
		System.out.println(Math.min(oneCnt, zeroCnt));
	}

}
