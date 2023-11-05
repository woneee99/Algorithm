import java.util.TreeMap;
import java.util.TreeSet;

public class PG_이중우선순위큐 {

	public static void main(String[] args) throws Exception {
		
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
		for(String str : operations) {
			String[] tmp = str.split(" ");
			
			if(tmp[0].equals("I")) {
				tm.put(Integer.parseInt(tmp[1]), tm.getOrDefault(Integer.parseInt(tmp[1]), 0) + 1);
			}
			else if(!tm.isEmpty()){
				if(tmp[1].equals("1")) {
					if(tm.lastEntry().getValue() > 1) {
						tm.replace(tm.lastEntry().getKey(), tm.lastEntry().getValue() - 1);
					}
					else tm.pollLastEntry();
				}
				else {
					if(tm.firstEntry().getValue() > 1) {
						tm.replace(tm.firstEntry().getKey(), tm.firstEntry().getValue() - 1);
					}
					else tm.pollFirstEntry();
				}
			}
		}
		int[] ans = new int[2];
		if(!tm.isEmpty()) {
			ans[0] = tm.lastKey();
			ans[1] = tm.firstKey();
		}
		else {
			ans[0] = 0;
			ans[1] = 0;	
		}
		System.out.println(ans[0] + " " + ans[1]);
	}

}
