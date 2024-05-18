import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj2109 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Lecture> q = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			q.add(new Lecture(d, p));
		}
		
		int day = 0, res = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while(!q.isEmpty()) {
			Lecture lec = q.poll();
			if(lec.d == day) {
				if(pq.peek() < lec.p) {
					res -= pq.poll();
					res += lec.p;
					pq.add(lec.p);
				}
				continue;
			}
			pq.add(lec.p);
			day++;
			res += lec.p;
		}
		
		System.out.println(res);
	}
	
	static class Lecture implements Comparable<Lecture>{
		int d;
		int p;
		
		public Lecture(int d, int p) {
			this.d = d;
			this.p = p;
		}

		@Override
		public int compareTo(Lecture o) {
			if(o.d == this.d) return o.p - this.p;
			return this.d - o.d;
		}
	}
}
