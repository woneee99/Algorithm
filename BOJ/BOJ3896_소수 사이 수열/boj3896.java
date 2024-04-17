import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj3896 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] primeNumber = new boolean[1299710];
		for(int i=3; i<=1299709; i+=2) {
			if(isPrime(i)) primeNumber[i] = true;
		}
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			if(primeNumber[k] || k < 3) {
				sb.append(0).append("\n");
				continue;
			}
			
			int end = k, start = k;
			while(end < 1299709 && !primeNumber[++end]) {
			}
			while(start > 1 && !primeNumber[--start]) {
			}
			
			sb.append(end - start).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean isPrime(int n) {
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n % i == 0) return false; 
		}
		return true;
	}
}
