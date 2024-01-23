import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14940 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        int x = 0, y = 0;
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 2) {
        			x = i; y = j;
        		}
        	}
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int[][] res = new int[N][M];
        
        boolean[][] chk = new boolean[N][M];
        chk[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        
        int depth = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int s=0; s<size; s++) {
        		int[] xy = q.poll();
        		
        		for(int d=0; d<4; d++) {
        			int nx = xy[0] + dx[d];
        			int ny = xy[1] + dy[d];
	        		
        			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        			if(chk[nx][ny] || map[nx][ny] == 0) continue;
        			res[nx][ny] = depth+1;
        			q.add(new int[] {nx, ny});
        			chk[nx][ny] = true;
        		}
        	}
        	depth++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(map[i][j] == 1 && res[i][j] == 0) res[i][j] = -1;
        		sb.append(res[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
	}

}
