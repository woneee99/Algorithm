import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int jm = Integer.parseInt(st.nextToken());
		int hs = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while(jm != hs) {
			cnt++;
			jm = jm / 2 + (jm % 2);
			hs = hs / 2 + (hs % 2);
		}
		System.out.println(cnt);
	}

}
