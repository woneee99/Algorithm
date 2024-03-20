import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		long now = (long)((double)(Y) * 100 / (double)(X));
		int start = 0, end = 1_000_000_000;
		if(now >= 99) start = -1;
		else {
			while(start <= end) {
				int mid = (start + end) / 2;
				long cal = (long)((double)(Y+mid) * 100 / (double)(X + mid));
				if(cal > now) {
					end = mid - 1;
				}
				else start = mid + 1;
			}
		}

		System.out.println(start);
	}

}
