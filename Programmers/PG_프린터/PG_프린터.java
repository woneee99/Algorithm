import java.util.*;

public class PG_프린터 {

	public static void main(String[] args) {
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;

		Queue<Integer> q = new LinkedList<>();

		for (int i : priorities) {
			q.add(i);
		}

		Arrays.sort(priorities);
		int length = priorities.length - 1;
		int i = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			location--;

			if (priorities[length] == x) {
				length--;
				if (location < 0) {
					break;
				}
			}
			else {
				if (location < 0) {
					location = q.size();
				}
				q.add(x);
			}
		}

		System.out.println(priorities.length - 1 - length);
	}

}
