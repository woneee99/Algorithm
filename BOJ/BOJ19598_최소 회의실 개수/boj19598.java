import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj19598 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		PriorityQueue<Meeting> meeting = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meeting.add(new Meeting(start, end));
		}
		
		int cnt = 1;
		List<Integer> last = new ArrayList<>();
		last.add(0);
		while(!meeting.isEmpty()) {
			Meeting poll = meeting.poll();
			
			boolean chk = false;
			for(int i=0; i<last.size(); i++) {
				if(poll.start >= last.get(i)) {
					last.remove(i);
					last.add(poll.end);
					chk = true;
					break;
				}
			}
			if(!chk) {
				cnt++;
				last.add(poll.end);
			}
		}
		
		System.out.println(cnt);
	}
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}
		
	}
}
