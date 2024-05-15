import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1475 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		int[] arr = new int[10];
		for(int i=0; i<N.length(); i++) {
			arr[N.charAt(i) - '0']++;
		}
		
		int cnt = (arr[6] + arr[9]) / 2;
		int cntChk = (arr[6] + arr[9]) % 2;
		arr[6] = cnt;
		arr[9] = cnt + cntChk;
		
		Arrays.sort(arr);
		System.out.println(arr[9]);
	}
}
