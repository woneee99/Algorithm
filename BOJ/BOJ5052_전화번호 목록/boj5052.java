import java.io.*;
import java.util.Arrays;


public class boj5052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			
			for(int j=0; j<n; j++) {
				arr[j] = br.readLine();
			}
			
			Arrays.sort(arr);
			
			boolean check = false;
			for(int k=1; k<n; k++) {
				if(arr[k].startsWith(arr[k-1])) {
					sb.append("NO").append("\n");
					check = true;
					break;
				}
			}
			if(!check) sb.append("YES").append("\n");
		
		}
		System.out.println(sb.toString());
	}

}
