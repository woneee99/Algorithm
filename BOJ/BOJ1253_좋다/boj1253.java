import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1253 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		for(int i=0; i<N; i++) {
			int start = 0, end = N-1;
			while(start < end) {
				int sum = arr[start] + arr[end];
				
				if(sum == arr[i]) {
					if(start != i && end != i) {
						cnt++; 
						break;	
					}
					else if(start == i) start++;
					else if(end == i) end--;
				}
				else if(sum < arr[i]) start++;
				else end--;
			}
		}
		
		System.out.println(cnt);
	}

}
