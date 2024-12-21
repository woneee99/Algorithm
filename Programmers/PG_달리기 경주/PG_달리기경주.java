import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
      HashMap<String, Integer> hm = new HashMap<>();
      for(int i = 0; i<players.length; i++) {
        hm.put(players[i], i);
      }
  		
      for(String str : callings) {
        int nowRanking = hm.get(str);
        String before = players[nowRanking-1];
        
        hm.replace(before, nowRanking);
        players[nowRanking] = before;
        
        hm.replace(str, nowRanking-1);
        players[nowRanking-1] = str;
      }

        return players;
    }
}
