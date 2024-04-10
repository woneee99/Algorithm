import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1700 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] tap = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			tap[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<K; i++) {
			if(!arr.contains(tap[i]) && arr.size() < N) {
				arr.add(tap[i]);
				continue;
			}
			if(arr.contains(tap[i])) continue;
			
			int max = 0, idx = 0;
			cnt++;
			boolean check = false;
			for(int j=0; j<arr.size(); j++) {
				boolean chk = false;
				for(int m=i+1; m<K; m++) {
					if(arr.get(j) == tap[m]) {
						if(max < m) {
							max = m;
							idx = j;
						}
						chk = true;
						break;
					}
				}
				if(!chk) {
					arr.remove(j);
					check = true;
					break;
				}
			}
			if(!check) arr.remove(idx);
			arr.add(tap[i]);
		}
		System.out.println(cnt);
	}

}
