import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        TreeMap<Integer, Long> tm = new TreeMap<>();
        for(int i=0; i<works.length; i++) {
            tm.put(works[i], tm.getOrDefault(works[i], 0L) + 1);
        }
        
        while(n > 0) {
            int now = tm.lastKey();
            long nowVal = tm.get(now);
            
            if(now == 0) {
                return 0;
            }
            
            if(nowVal <= n) { 
                n -= nowVal;
                tm.remove(now);
                tm.put(now-1, tm.getOrDefault(now-1, 0L) + nowVal);
            }
            else {
                tm.put(now, nowVal - n);
                tm.put(now-1, tm.getOrDefault(now-1, 0L) + n);
                break;
            }
        }
        
        Iterator<Integer> it = tm.keySet().iterator();
        while(it.hasNext()){
            int key = it.next();
            answer += (key * key * tm.get(key));
        }
        return answer;
    }
}