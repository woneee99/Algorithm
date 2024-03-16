import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj19942 {
	static int N;
	static int minP, minF, minS, minV;
	static ArrayList<Food> food;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		minP = Integer.parseInt(st.nextToken());
		minF = Integer.parseInt(st.nextToken());
		minS = Integer.parseInt(st.nextToken());
		minV = Integer.parseInt(st.nextToken());
		
		food = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			food.add(new Food(p, f, s, v, c));
		}
		chk = new boolean[N];
		res = new boolean[N];
		
		dfs(0, 0, 0, 0, 0, 0, 0);
		if(min != 987654321) {
			bw.write(min + "\n");
			for(int i=0; i<res.length; i++) {
				if(res[i]) bw.write((i+1) + " ");
			}
		}
		else bw.write("-1");
		bw.flush();
		bw.close();
	}
	static boolean[] chk, res;
	static int min = 987654321;
	static void dfs(int depth, int idx, int a, int b, int c, int d, int money) {
		if(a >= minP && b >= minF && c >= minS && d >= minV && min > money) {
			min = money;
			res = Arrays.copyOf(chk, chk.length);
			return;
		}
		if(depth == N) {
			return;
		}
		
		for(int i=idx; i<N; i++) {
			Food now = food.get(i);
			chk[i] = true;
			dfs(depth + 1, i+1, a + now.p, b+ now.f, c+now.s, d+now.v, money+now.c);
			chk[i] = false;
		}
	}
	
	static class Food {
		int p, f, s, v, c;

		public Food(int p, int f, int s, int v, int c) {
			this.p = p;
			this.f = f;
			this.s = s;
			this.v = v;
			this.c = c;
		}
	}
}
