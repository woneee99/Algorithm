import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1522 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int length = line.length();
		int[] ch = new int[length+1];
		int cnt = 0;
		for(int i=1; i<=length; i++) {
			ch[i] = line.charAt(i-1) == 'b' ? ch[i-1] + 1 : ch[i-1];
			cnt = line.charAt(i-1) == 'b' ? cnt + 1 : cnt;
		}
		
		int min = 987654321;
		for(int i=1; i<=length; i++) {
			int n = 0;
			if(length+1-cnt >= i) {
				n = ch[i+cnt-1] - ch[i-1];
			}
			else {
				n = ch[length] - ch[i-1];
				int num = length - i + 1;
				n += ch[cnt - num];
			}
			min = Math.min(min, cnt - n);
		}
		System.out.println(min);
	}
}
