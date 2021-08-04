import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> []arr;
	static boolean []check;
	static int q = 0;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[num+1];
		
		for(int i=1; i<=num; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			arr[l].add(r);
			arr[r].add(l);
		}
		
		check = new boolean[num+1];
		DFS(1);
		
		System.out.println(q);
	}
	static void DFS(int nx) {
		check[nx] = true;
		
		for(int i=0; i<arr[nx].size(); i++) {
			int y = arr[nx].get(i);
			if(!check[y]) {
				DFS(y);
				q++;
			}
		}
	}
}
