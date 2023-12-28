import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj21736 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] school = new char[N][M];
		for(int i=0; i<N; i++) {
			school[i] = br.readLine().toCharArray();
		}
		
		int cnt = 0;
		int[] nx = {-1, 1, 0, 0};
		int[] ny = {0, 0, -1, 1};
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(school[i][j] == 'I') {
					Queue<int[] > person = new LinkedList<int[]>();
					boolean[][] isCheck = new boolean[N][M];
					
					person.add(new int[] {i, j});
					isCheck[i][j] = true;
					
					while(!person.isEmpty()) {
						int[] one = person.poll();
						
						for(int d=0; d<4; d++) {
							int dx = nx[d] + one[0];
							int dy = ny[d] + one[1];
							
							if(dx >= N || dx < 0 || dy < 0 || dy >= M) continue;
							if(isCheck[dx][dy] || school[dx][dy] == 'X') continue;
							
							if(school[dx][dy] == 'P') cnt++;

							person.add(new int[] {dx, dy});
							isCheck[dx][dy] = true;
						}
					}
					break;
				}
			}
		}
		
		System.out.println(cnt == 0 ? "TT" : cnt);
	}

}
