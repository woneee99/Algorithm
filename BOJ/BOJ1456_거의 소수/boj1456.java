import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1456 {
	static final int LIMIT = 10_000_000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		boolean[] isNotPrime = new boolean[LIMIT+1];
		isNotPrime[0] = isNotPrime[1] = true;
		for(int i=2; i*i<=LIMIT; i++) {
			if(isNotPrime[i]) continue;
			for(int j=i*i; j<=LIMIT; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		long res = 0;
		for(long i=2; i<=LIMIT; i++) {
			if(isNotPrime[(int)i]) continue;
			
			long num = i * i;
			while(num <= B) {
				if(num >= A) res++;
				if(i > 100_000) break;
				num *= i;
			}
		}
		
		System.out.println(res);
	}
	
}
