import java.io.*;
import java.util.StringTokenizer;

public class boj1987 {
    static char[][] board;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for(int i=0; i<R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        chk = new boolean[26];
        chk[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(res);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] chk;
    static int res;
    static void dfs(int x, int y, int depth) {
        res = Math.max(res, depth);

        for(int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            int now = board[nx][ny] - 'A';
            if(chk[now]) continue;
            chk[now] = true;
            dfs(nx, ny, depth+1);
            chk[now] = false;
        }
    }
}