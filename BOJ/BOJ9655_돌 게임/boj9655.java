import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9655 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 1) System.out.println("SK");
		else System.out.println("CY");
	}

}
