import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj6588 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		StringBuilder sb = new StringBuilder();
		
		boolean[] chk = new boolean[1000001]; // ¼Ò¼ö
		for(int i=3; i<=chk.length; i+=2) {
			if(isPrime(i)) chk[i] = true;
		}
		
		while((n = Integer.parseInt(br.readLine())) != 0) {
			int start = 3;
			int end = n-1;
			
			boolean yes = false;
			while(start <= end) {
				if(!chk[start]) {
					start += 2;
					continue;
				}
				if(!chk[end]) {
					end -= 2;
					continue;
				}
				
				if(start + end == n) {
					yes = true;
					sb.append(n).append(" = ").append(start).append(" + ").append(end).append("\n");
					break;
				}
				else if(start + end > n) end -= 2;
				else start += 2;
			}
			
			if(!yes) sb.append("Goldbach's conjecture is wrong.").append("\n");
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
