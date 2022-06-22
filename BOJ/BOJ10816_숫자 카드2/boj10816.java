import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10816 {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			sb.append(upperBinary(x, 0, n)- lowerBinary(x, 0, n)).append(" ");
		}
		System.out.println(sb);
	}
	static int upperBinary(int key, int start, int end) {
		int mid;
		while(start < end) {
			mid = (start+end)/2;
			
			if(key < arr[mid]) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return start;
	}
	static int lowerBinary(int key, int start, int end) {
		int mid;
		while(start < end) {
			mid = (start+end)/2;
			
			if(key <= arr[mid]) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return start;
	}
}
