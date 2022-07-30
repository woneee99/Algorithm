import java.util.*;
import java.io.*;

public class boj1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
			arr[i][1] = Integer.parseInt(st.nextToken()); // 가격
		}

		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

		int[] bag = new int[k];
		for (int i = 0; i < k; i++) {
			bag[i] = Integer.parseInt(br.readLine()); // 가방 무게
		}
		Arrays.sort(bag);

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		long max = 0;
		int index = 0;
		for (int i = 0; i < k; i++) {
			while (index < n && arr[index][0] <= bag[i]) {
				queue.add(arr[index++][1]);
			}
			if(!queue.isEmpty()) max += (long)queue.poll();
		}

		System.out.println(max);
	}

}
