import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();

		int start = 0;
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if (start < num) {
				for (int i = start + 1; i <= num; i++) {
					stack.add(i);
					sb.append("+").append("\n");
				}
				start = num;
			} else if (stack.peek() != num) {
				System.out.println("NO");
				System.exit(0);
			}
			stack.pop();
			sb.append("-").append("\n");

		}

		System.out.println(sb.toString());
	}

}
