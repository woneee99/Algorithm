import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3649 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String line = "";
		while((line = br.readLine()) != null) {
			int x = Integer.parseInt(line) * 10_000_000; // cm
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(br.readLine()); // nm
			}
			Arrays.sort(arr);
			
			int start = 0, end = n - 1;
			boolean chk = false;
			while(start < end) {
				if(arr[start] + arr[end] > x) end--;
				else if(arr[start] + arr[end] == x) {
					sb.append("yes ").append(arr[start]).append(" ").append(arr[end]).append("\n");
					chk = true;
					break;
				}
				else start++;
			}
			if(!chk) sb.append("danger \n");
		}
		System.out.println(sb.toString());
	}
}
