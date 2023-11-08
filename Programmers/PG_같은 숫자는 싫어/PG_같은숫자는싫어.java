import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++) {
            if(!dq.isEmpty() && dq.peekFirst() == arr[i]) {
                continue;
            }
            dq.push(arr[i]);
        }
        
        int[] answer = new int[dq.size()];
        int idx = 0;
        while(!dq.isEmpty()) {
            answer[idx++] = dq.pollLast();
        }
        
        return answer;
    }
}