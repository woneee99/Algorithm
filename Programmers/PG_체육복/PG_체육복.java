import java.util.*;
public class PG_체육복 {

	public static void main(String[] args) {
		int n = 3;
		int[] lost = {3};
		int[] reserve = {1};
        int answer = n;
        boolean[] check = new boolean[n+2];
        Arrays.sort(reserve);
        Arrays.sort(lost);
        int s = 0;
        for(int i=0; i<reserve.length; i++){
            for(int j=s; j<lost.length; j++){
                if(lost[j] == reserve[i]) {
                    s = j+1;
                    lost[j] = -1;
                    reserve[i] = -1;
                    break;
                 }
            }
            if(reserve[i] != -1) check[reserve[i]] = true;
        }

        for(int i=0; i<lost.length; i++){
            if(lost[i] == -1) continue;
            else if(check[lost[i] - 1]){
                check[lost[i] - 1] = false;
            }
            else if(check[lost[i] + 1]){
                check[lost[i] + 1] = false;
            }
            else answer--;
        }
        
        System.out.println(answer);
	}

}
