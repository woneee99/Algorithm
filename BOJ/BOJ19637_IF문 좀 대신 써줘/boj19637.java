import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj19637 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Character> ch = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			ch.add(new Character(st.nextToken(), Integer.parseInt(st.nextToken())));
		}
	
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int strength = Integer.parseInt(br.readLine());
			
			int start = 0, end = ch.size() - 1;
			while(start < end) {
				int mid = (start + end) / 2;
				if(ch.get(mid).strength >= strength) {
					end = mid;
				}
				else {
					start = mid + 1;
				}
			}
			sb.append(ch.get(start).str).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static class Character {
		String str;
		int strength;
		
		public Character(String str, int strength) {
			this.str = str;
			this.strength = strength;
		}
	}
}
