import java.util.*;
public class PG_단속카메라 {

	public static void main(String[] args) {
		int[][] routes = {{-10, 0}, {-3,5}, {-5, 7}, {9, 11}};
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int answer = 1;
        int idx = 0;
        for(int i=0; i<routes.length; i++) {
            if(routes[idx][1] >= routes[i][0]) continue;
            idx = i;
            answer++;
        }

        System.out.println(answer);
	}

}
