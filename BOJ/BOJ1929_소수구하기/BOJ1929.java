import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		prime = new boolean[p2+1];
		
		prime(p1,p2);
		StringBuilder sb = new StringBuilder();
		for(int i=p1; i<=p2; i++) {
			if(!prime[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	static void prime(int a, int b) {
			prime[0] = prime[1] = true;
			for(int i=2; i<=Math.sqrt(prime.length); i++) {
				if(prime[i] == true) continue;
				for(int j=i*i; j<prime.length; j+=i) {
					prime[j] = true;
				}
			}
	}
}
