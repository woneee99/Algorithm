import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2036 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> negative = new ArrayList<>();
		ArrayList<Long> positive = new ArrayList<>();
		int zeroCnt = 0;
		
		for(int i=0; i<N; i++) {
			long num = Long.parseLong(br.readLine());
			if(num > 0) positive.add(num);
			else if(num == 0) zeroCnt++;
			else negative.add(num);
		}
		
		Collections.sort(negative);
		Collections.sort(positive);
		
		long score = 0;
		for(int i=0; i<negative.size()-1; i+=2) {
			score += negative.get(i) * negative.get(i+1);
		}
		if(negative.size() % 2 == 1 && zeroCnt == 0) score += negative.get(negative.size()-1);
		
		for(int i=positive.size()-1; i>0; i-=2) {
			long a = positive.get(i);
			long b = positive.get(i-1);
			score += Math.max(a + b, 1l * a * b);
		}
		
		if(positive.size() % 2 == 1) score += positive.get(0);

		System.out.println(score);
	}

}
