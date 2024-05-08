import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1781 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Homework> homeworks = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			homeworks.add(new Homework(deadline, cnt));
		}
		
		int res = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while(!homeworks.isEmpty()) {
			Homework homework = homeworks.poll();
			pq.add(homework.cnt);
			
			if(pq.size() > homework.deadline) {
				pq.poll();
			}
		}
		
		while(!pq.isEmpty()) {
			res += pq.poll();
		}
		System.out.println(res);
	}
	
	static class Homework implements Comparable<Homework>{
		int deadline;
		int cnt;
		
		public Homework(int deadline, int cnt) {
			this.deadline = deadline;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Homework o) {
			if(this.deadline == o.deadline) return o.cnt - this.cnt;
			return this.deadline - o.deadline;
		}
	}
}
