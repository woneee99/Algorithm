package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_6808 {
	static int[] arr, brr, chk;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr = new int[9];
			brr = new int[9];
			chk = new int[19];
			for(int i=0; i<9; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				chk[arr[i]] = 1;
			}
			
			int bIdx = 0;
			for(int i=1; i<=18; i++) {
				if( chk[i] != 1) brr[bIdx++] = i;
			}
			
			Arrays.sort(brr);
			
			int win = 0, lose = 0;
			while(true) {
				int one = 0, two = 0;
				for(int i=0; i<9; i++) {
					if(arr[i] > brr[i]) {
						one += arr[i] + brr[i];
					}
					else two += arr[i] + brr[i];
				}
				
				if(one > two) win++;
				else if(one < two) lose++;
				if(!cal()) break;
			}
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean cal() {
		int i = brr.length - 1;
		
		while( i > 0 && brr[i-1] >= brr[i]) --i;
		
		if( i == 0 ) return false;
		
		int j = brr.length - 1;
		
		while( brr[i-1] >= brr[j]) j--;
		swap(i-1, j);
		
		int k = brr.length - 1;
		
		while(k > i) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	static void swap(int i, int j) {
		int tmp = brr[i];
		brr[i] = brr[j];
		brr[j] = tmp;
	}
}
