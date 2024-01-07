import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj9081 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String str = br.readLine();

			char[] charArr = str.toCharArray();
			
			int idx = -1;
			for(int j=str.length()-1; j>0; j--) {
				if(str.charAt(j) > str.charAt(j-1)) {
					idx = j-1;
					break;
				}
			}
			
			int min = Character.MAX_VALUE;
			int index = 0;
			if(idx == -1) sb.append(str).append("\n");
			else {
				for(int j=str.length()-1; j>idx; j--) {
					if(str.charAt(idx) < str.charAt(j) && min > str.charAt(j)) {
						index = j;
						min = str.charAt(j);
					}
				}
				
				char temp = charArr[idx];
				charArr[idx] = charArr[index];
				charArr[index] = temp;
				
				char[] pre = Arrays.copyOfRange(charArr, 0, idx+1);
				char[] post = Arrays.copyOfRange(charArr, idx+1, charArr.length);
				Arrays.sort(post);
				
				String res = String.valueOf(pre) + String.valueOf(post);
				sb.append(res).append("\n");
			}
		}
		System.out.println(sb);
	}
}
