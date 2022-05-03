import java.io.*;
import java.util.*;

public class PG_위장 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] clothes = { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } };

		Map<String, Integer> map = new HashMap<String, Integer>();

		int j = 1;
		for (int i = 0; i < clothes.length; i++) {
			if (map.containsKey(clothes[i][1])) {
				int val = map.get(clothes[i][1]);
				map.put(clothes[i][1], val + 1);
			} else {
				map.put(clothes[i][1], 1);
			}
		}

		int result = 1;
		Collection<Integer> val = map.values();
		for (int k : val) {
			result *= k + 1;
		}

		System.out.println(result - 1);
	}

}
