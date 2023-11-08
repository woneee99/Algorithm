import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        Arrays.sort(costs, (a, b) -> Integer.compareTo(a[2], b[2]));
        
        for(int i=0; i<costs.length; i++) {
            if(union(parent, costs[i][0], costs[i][1])) {
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    int find(int[] parent, int num) {
        if(parent[num] == -1) return num;
        
        return find(parent, parent[num]);
    }
    
    boolean union(int[] parent, int first, int second) {
        int f = find(parent, first);
        int s = find(parent, second);
        
        if(f != s) {
            parent[f] = s;
            return true;
        }
        
        return false;
    }
}