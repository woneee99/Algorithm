import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1138 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> person = new ArrayList<>();
		int[] check = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=N; i>0; i--) {
			person.add(check[i-1], i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num : person) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString());
	}

}
