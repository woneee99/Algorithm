import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1094_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int sum = 64;
		int min = 64, cnt = 1;
		while(sum > X) {
			int now = min / 2;
			sum -= now;
			
			if(sum < X) {
				sum += now;
				cnt++;
			}
			min = now;
		}
		
		System.out.println(cnt);
	}
}
