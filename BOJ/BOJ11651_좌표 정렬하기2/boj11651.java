import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj11651 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Node> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Node(x, y));
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.size(); i++) {
			sb.append(arr.get(i).x).append(" ").append(arr.get(i).y).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static class Node implements Comparable<Node> {
		int x; int y;
		
		Node(int nx, int ny) {
			this.x = nx;
			this.y = ny;
		}
		
		@Override
		public int compareTo(Node o) {
			if(o.y == this.y) return this.x - o.x;
			return this.y - o.y;
		}
		
	}
}
