import java.util.*;
public class PG_롤케이크자르기 {
	public int solution(int[] topping) {
        int len = topping.length;

        int ans = 0;
        HashSet<Integer> left = new HashSet<>();
        HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();
        for(int i=0; i<len; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=0; i<len; i++) {
            left.add(topping[i]);
            if(right.get(topping[i]) > 1) right.replace(topping[i], right.get(topping[i]) - 1);
            else if (right.get(topping[i]) == 1) right.remove(topping[i]);
            
            if(right.size() == left.size()) ans++;
        }
        
        return ans;
    }
}
