import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
   static StringBuilder sb = new StringBuilder();
   static boolean []check;
   static ArrayList<Integer>[]list;
   
   static void DFS(int start) {
	   sb.append(start).append(" ");
	   check[start] = true;
	   for(int i=0; i<list[start].size(); i++) {
		   int x = list[start].get(i);
		   if(!check[x]) DFS(x);
	   }
   }
   static void BFS(int start) {
	   Queue<Integer> queue = new LinkedList<>();
	   queue.offer(start);
	   check[start] = true;
	   while(!queue.isEmpty()) {
		   int node = queue.poll(); 
		   sb.append(node).append(" ");
		   
		   for(int i=0; i<list[node].size(); i++) {
			   int x = list[node].get(i);
			   if(!check[x]) {
				   check[x] = true;
				   queue.offer(x);
			   }
		   }
	   }
   }
   
   @SuppressWarnings("unchecked")   
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   int N = Integer.parseInt(st.nextToken()); 
	   int M = Integer.parseInt(st.nextToken()); 
	   int V = Integer.parseInt(st.nextToken()); 
	   
	   check = new boolean[N+1];
	   list = new ArrayList[N+1];
	   
	   for(int i=0; i<N+1; i++) {
		   list[i] = new ArrayList<Integer>();
	   }
	   for(int i=0; i<M; i++) {
		   st = new StringTokenizer(br.readLine());
		   int x = Integer.parseInt(st.nextToken());
		   int y = Integer.parseInt(st.nextToken());
		   list[x].add(y);
		   list[y].add(x);
	   }
	   for(int i=0; i<N+1; i++) {
		   Collections.sort(list[i]);
	   }
	   
	   DFS(V);
	   sb.append("\n");
	   for(int i=0; i<N+1; i++) {
		   check[i] = false;
	   }
	   BFS(V);
	   System.out.println(sb);
   }
}