import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1269 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ACnt = Integer.parseInt(st.nextToken());
		int BCnt = Integer.parseInt(st.nextToken());

		HashSet<Integer> hs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<ACnt; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<BCnt; i++) {
			int b = Integer.parseInt(st.nextToken());
			if(hs.contains(b)) hs.remove(b);
			else hs.add(b);
		}
		
		System.out.println(hs.size());
	}

}
