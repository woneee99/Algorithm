import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2891 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		boolean[] noKayak = new boolean[N+1];
		for(int i=0; i<s; i++) {
			noKayak[Integer.parseInt(st.nextToken())] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		boolean[] twoKayak = new boolean[N+1];
		for(int i=0; i<R; i++) {
			twoKayak[Integer.parseInt(st.nextToken())] = true;
		}
		
		int cnt = s;
		for(int i=1; i<=N; i++) {
			if(!noKayak[i]) continue;
			
			if(twoKayak[i]) {
				twoKayak[i] = false;
				cnt--;
			}
			else if(twoKayak[i - 1]) {
				twoKayak[i - 1] = false;
				cnt--;
			}
			else if(i + 1 <= N && twoKayak[i + 1]) {
				if(noKayak[i+1]) continue;
				twoKayak[i + 1] = false;
				cnt--;
			}
		}
		System.out.println(cnt);
	}

}
