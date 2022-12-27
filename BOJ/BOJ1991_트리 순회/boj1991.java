import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1991 {
	static int[][] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		tree = new int[27][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = st.nextToken().charAt(0) - 'A';
			String left = st.nextToken();
			String right = st.nextToken();
			tree[node][0] = (left.equals(".")) ? -1 : left.charAt(0) - 'A';
			tree[node][1] = (right.equals(".")) ? -1 : right.charAt(0) - 'A';
		}
		pre(0);
		sb.append("\n");
		in(0);
		sb.append("\n");
		post(0);
		System.out.println(sb.toString());
	}

	static void pre(int start) { //전위
		sb.append((char) (start + 'A'));
		if(tree[start][0] >= 0) pre(tree[start][0]);
		if(tree[start][1] >= 0) pre(tree[start][1]);
	}
	static void in(int start) { //중위
		if(tree[start][0] >= 0) in(tree[start][0]);
		sb.append((char) (start + 'A'));
		if(tree[start][1] >= 0) in(tree[start][1]);
	}
	static void post(int start) { //후위
		if(tree[start][0] >= 0) post(tree[start][0]);
		if(tree[start][1] >= 0) post(tree[start][1]);
		sb.append((char) (start + 'A'));
	}
}
