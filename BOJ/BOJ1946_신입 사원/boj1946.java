import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class top implements Comparable<top>{
	int one;
	int two;
	
	public top(int one, int two) {
		this.one = one;
		this.two = two;
	}

	@Override
	public int compareTo(top o) {
		return this.one - o.one;
	}
	
}
public class boj1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<top> arr = new ArrayList<>();
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				arr.add(new top (one, two));
			}
			Collections.sort(arr);
			sb.append(cal(n, arr)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int cal(int n, ArrayList<top> arr) {
		int cnt = 1;
		for(int i=1; i<arr.size(); ) {
			if(arr.get(i-1).two > arr.get(i).two) {
				cnt++; i++;
			}
			else {
				arr.remove(i);
			}
		}
		return cnt;
	}
}
