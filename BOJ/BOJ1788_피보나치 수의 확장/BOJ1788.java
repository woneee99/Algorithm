import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int []arr;
	static int f = 1_000_000_000;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n > 0) System.out.println(1);
		else if(n == 0) System.out.println(0);
		else {
			n = -n;
			if(n % 2 == 0) System.out.println(-1);
			else System.out.println(1);
		}
		
		fib(n);
	}
	
	static void fib(int x) {
		arr = new int[1000001];
		arr[1] = 1;
		arr[0] = 0;
		if(x>1) {
			for(int i=2; i<=x; i++) {
				arr[i] = (arr[i-1]+ arr[i-2])%f;	
			}
		}
		System.out.println(arr[x]);
	}
}