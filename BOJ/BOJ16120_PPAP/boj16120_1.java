import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj16120_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		
		String res = "PPAP";
		int pCnt = 0;
		for(int i=0; i<str.length; i++) {
			if(str[i] == 'A') {
				if(pCnt >= 2 && i < str.length - 1 && str[i+1] == 'P') {
					pCnt--;
					i++;
				}
				else {
					res = "NP";
					break;
				}
			}
			else pCnt++;
		}
		
		if(pCnt > 1) res = "NP";
		System.out.println(res);
	}
}
