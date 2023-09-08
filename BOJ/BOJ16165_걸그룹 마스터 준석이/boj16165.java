import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj16165 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		TreeMap<String, String> tm = new TreeMap<String, String>();
		for(int i=0; i<N; i++) {
			String team = br.readLine();
			
			int num = Integer.parseInt(br.readLine());
			for(int j=0; j<num; j++) {
				String mem = br.readLine();
				tm.put(mem, team);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String who = br.readLine();
			int quiz = Integer.parseInt(br.readLine());
			
			if(quiz == 1) { // 멤버 이름
				sb.append(tm.get(who)).append("\n");
			}
			else { // 팀 이름
				for(String str : tm.keySet()) {
					if(tm.get(str).equals(who)) sb.append(str).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}
