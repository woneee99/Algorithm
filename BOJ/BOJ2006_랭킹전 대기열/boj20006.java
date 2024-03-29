import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj20006 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()); // 플레이어 수
		int m = Integer.parseInt(st.nextToken()); // 정원
	
		ArrayList<ArrayList<Game>> game = new ArrayList<>();
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String id = st.nextToken();
			
			boolean chk = false;
			for(ArrayList<Game> now : game) {
				if(now.size() == m) continue;
				if(Math.abs(now.get(0).level - level) <= 10) {
					chk = true;
					now.add(new Game(level, id));
					break;
				}
			}
			
			if(!chk) {
				ArrayList<Game> here = new ArrayList();
				here.add(new Game(level, id));
				game.add(here);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(ArrayList<Game> now : game) {
			Collections.sort(now);
			if(now.size() == m) sb.append("Started!");
			else sb.append("Waiting!");
			
			sb.append("\n");
			for(Game player : now) {
				sb.append(player.level).append(" ").append(player.id).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	static class Game implements Comparable<Game>{
		int level;
		String id;

		public Game(int level, String id) {
			this.level = level;
			this.id = id;
		}

		@Override
		public int compareTo(Game o) {
			return this.id.compareTo(o.id);
		}
	}
}
