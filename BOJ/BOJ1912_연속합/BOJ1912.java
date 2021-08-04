import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr,a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[num];
		for(int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sum(num);
	}
	static void sum(int num) {
		a = new int[num];
		a[0] = arr[0];
		int max = arr[0];
		for(int i=1; i<num; i++) {
			a[i] = Math.max(a[i-1] + arr[i], arr[i]);
			max = Math.max(a[i], max);
		}
		System.out.println(max);
	}
}
