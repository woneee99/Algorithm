import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1083 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int S = Integer.parseInt(br.readLine());
		for(int i = 0; i < N && S > 0; i++) {
			int max = 0, maxIdx = 0;
			for(int j = i; j < N && j <= S+i; j++) {
				if(max <= arr.get(j)) {
					max = arr.get(j);
					maxIdx = j;
				}
			}

			arr.remove(maxIdx);
			arr.add(i, max);
			S -= (maxIdx-i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
