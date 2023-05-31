import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


public class boj22860 {
	static HashMap<String, ArrayList<Node>> hm;
	static HashSet<String> check;
	static int file;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		hm = new HashMap<>();
		
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			String P = st.nextToken();
			String F = st.nextToken();
			int C = Integer.parseInt(st.nextToken());
			
			if(hm.containsKey(P)) {
				ArrayList<Node> arr = hm.get(P);
				arr.add(new Node(F, C));
				hm.put(P, arr);
			}
			else hm.put(P, new ArrayList<>(Arrays.asList(new Node(F, C))));
		}
		
		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Q; i++) {
			file = 0;
			check = new HashSet<>();
			String[] line = br.readLine().split("/");
			cal(line[line.length-1]);
			sb.append(check.size()).append(" ").append(file).append("\n");
		}
		System.out.println(sb.toString());
	}
	static void cal(String str) {
		ArrayList<Node> arr = hm.get(str);
		if(arr == null) return;
		for(Node node : arr) {
			if(node.folder == 1) {
				cal(node.node);
			}
			else {
				check.add(node.node);
				file++;
			}
		}
	}
	
	static class Node{
		String node;
		int folder;

		public Node(String node, int folder) {
			this.node = node;
			this.folder = folder;
		}
	}
}
