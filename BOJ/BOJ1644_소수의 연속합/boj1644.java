import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1644 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] isPrime = new boolean[N+1];
		for(int i=2; i*i<=N; i++) {
			if(isPrime[i]) continue;
			
			for(int j=i*i; j<=N; j+=i) {
				isPrime[j] = true;
			}
		}
		
		int start = 2;
		int cnt = 0;
		int sum = 0;
		for(int i=2; i<=N; i++) {
			if(isPrime[i]) continue;
			sum += i;
			if(sum == N) cnt++;
			if(sum > N) {
				while(sum >= N) {
					if(sum == N) cnt++;
					sum -= start;
					
					for(int j=start+1; j<=i; j++) {
						if(!isPrime[j]) {
							start = j;
							break;
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
