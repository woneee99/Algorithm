import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj19598_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		PriorityQueue<Meeting> meeting = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			meeting.add(new Meeting(Integer.parseInt(st.nextToken()), true));
			meeting.add(new Meeting(Integer.parseInt(st.nextToken()), false));
		}
		
		int cnt = 0, res = 0;
		while(!meeting.isEmpty()) {
			Meeting poll = meeting.poll();
			
			if(poll.isStart) {
				cnt++;
				res = Math.max(res, cnt);
			}
			else cnt--;
		}
		
		System.out.println(res);
	}
	static class Meeting implements Comparable<Meeting>{
		int time;
		boolean isStart;
		
		public Meeting(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}

		@Override
		public int compareTo(Meeting o) {
			return this.time - o.time;
		}
		
	}
}
