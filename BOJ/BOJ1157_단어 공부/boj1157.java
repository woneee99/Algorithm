import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class boj1157 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0; i<N.length(); i++) {
			char now = Character.toUpperCase(N.charAt(i));
			hm.put(now, hm.getOrDefault(now, 0) + 1);
		}
		
		List<Entry<Character, Integer>> list = new LinkedList<>(hm.entrySet());
		list.sort((o1, o2) -> hm.get(o2.getKey()) - hm.get(o1.getKey()));
		
		char chk = list.get(0).getKey();
		if(list.size() > 1) {
			chk = list.get(0).getValue().equals(list.get(1).getValue()) ? '?' : chk;
		}
		System.out.println(chk);
	}

}
