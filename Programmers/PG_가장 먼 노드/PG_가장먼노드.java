import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PG_가장먼노드 {

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<edge.length; i++) {
			arr[edge[i][0]].add(edge[i][1]);
			arr[edge[i][1]].add(edge[i][0]);
		}
		
		boolean[] chk = new boolean[n+1];
		chk[1] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int ans = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			ans = size;
			
			for(int i=0; i<size; i++) {
				int p = q.poll();
				
				for(int j=0; j<arr[p].size(); j++) {
					int node = arr[p].get(j);
					if(chk[node]) continue;
					chk[node] = true;
					q.add(node);
				}
			}
		}
		System.out.println(ans);
	}
	
}
