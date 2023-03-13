import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj17218 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line1 = br.readLine();
		String line2 = br.readLine();
		
		int[][] res = new int[line2.length()+1][line1.length()+1];
		String result = "";
		for(int i=1; i<=line2.length(); i++) {
			for(int j=1; j<=line1.length(); j++) {
				if(line1.charAt(j-1) == line2.charAt(i-1)) res[i][j] = res[i-1][j-1] + 1;
				else res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
			}
		}
		
		int cnt = res[line2.length()][line1.length()], idx = line1.length();
		
		for(int i=line2.length(); i>0; i--) {
			if(cnt < 0) break;
			for(int j=idx; j>0; j--) {
				if(res[i-1][j] != cnt && res[i][j-1] != cnt) {
					result += line2.charAt(i-1);
					cnt--;
				}
				else if(res[i][j] == res[i][j-1]) continue;
				if(res[i][j] != res[i][j-1] && i != 1) {
					idx = j;
					break;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(result);
		System.out.println(sb.reverse().toString());
	}
}