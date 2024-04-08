import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1107 {
	static boolean[] chk = new boolean[10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				chk[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		int now = Integer.parseInt(N), idx = 0;
		int start = 100, cnt = Math.abs(now - start);
		if(start == Integer.parseInt(N)) {
			System.out.println(0);
			return;
		}
		
		while(idx < cnt) {
			String str = String.valueOf(now + idx);
			if(!check(str)) {
				cnt = Math.min(cnt, idx + str.length());
			}
			
			str = String.valueOf(now - idx);
			if(now - idx >= 0 && !check(str)) {
				cnt = Math.min(cnt, idx + str.length());
				break;
			}
			idx++;
		}
		
		if(cnt == 0) cnt = Math.abs(now - start);
		else {
			cnt = cnt < Math.abs(now - start) ? cnt : Math.abs(now - start);
		}
		System.out.println(cnt);
	}
	
	static boolean check(String str) {
		boolean check = false;
		for(int i=0; i<str.length(); i++) {
			if(chk[str.charAt(i) - '0']) {
				check = true;
				break;
			}
		}
		return check ? true : false;
	}
}


