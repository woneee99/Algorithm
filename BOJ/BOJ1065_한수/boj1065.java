import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1065 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int x = n / 10; 
		if (n == 1000) {
			System.out.println(144);
		} else if (x >= 10) {
			System.out.println(cal(n));
			
		} else {
			System.out.println(n);
		}
	}
	
	static int cal(int n) {
		int count = 99;
		int one = n/100;
		
		for(int i=1; i<=one; i++) {
			for(int j=0; j<=9; j++) {
				a : for(int k=0; k<=9; k++) {
					int x = i*100 + j*10 + k;
					if(x > n) break a;
					if(j-i == k-j) count++;
				}
			}
		}
		
		return count;
	}
}
