import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj2170 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Line> line = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			line.add(new Line(x, y));
		}
		
		Line start = line.poll();
		int sum = 0, s = start.x, e = start.y;
		for(int i=1; i<N; i++) {
			Line now = line.poll();
			
			if(now.x <= e) {
				e = now.y > e ? now.y : e;
			}
			else {
				sum += e - s;
				s = now.x;
				e = now.y;
			}
		}
		sum += e - s;
		System.out.println(sum);
	}
	
	static class Line implements Comparable<Line>{
		int x;
		int y;
		
		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Line o) {
			return this.x - o.x;
		}
		
	}
}
