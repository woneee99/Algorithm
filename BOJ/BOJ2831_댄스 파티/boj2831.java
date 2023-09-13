import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj2831 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer manSt = new StringTokenizer(br.readLine());
		StringTokenizer womanSt = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> manMinus = new ArrayList<>();
		ArrayList<Integer> manPlus = new ArrayList<>();
		ArrayList<Integer> womanMinus = new ArrayList<>();
		ArrayList<Integer> womanPlus = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int manNum = Integer.parseInt(manSt.nextToken());
			int womanNum = Integer.parseInt(womanSt.nextToken());
			
			if(manNum < 0 ) manMinus.add(Math.abs(manNum));
			else manPlus.add(manNum);
			
			if(womanNum < 0 ) womanMinus.add(Math.abs(womanNum));
			else womanPlus.add(womanNum);
		}
		
		Collections.sort(manMinus);
		Collections.sort(manPlus);
		Collections.sort(womanMinus);
		Collections.sort(womanPlus);
		
		int res = 0;
		
		if(!manPlus.isEmpty() && !womanMinus.isEmpty()) {
			int idx = womanMinus.size()-1;
			for(int i = manPlus.size()-1; i>=0 && idx >= 0; i--) {
				int manNum = manPlus.get(i);
				int womanNum = womanMinus.get(idx);
				
				if(manNum < womanNum) { // 조건 부합
					res++;
					idx--;
				}
			}
		}
		
		if(!womanPlus.isEmpty() && !manMinus.isEmpty()) {
			int idx = manMinus.size()-1;
			for(int i = womanPlus.size()-1; i>=0 && idx >= 0; i--) {
				int womanNum = womanPlus.get(i);
				int manNum = manMinus.get(idx);
				
				if(womanNum < manNum) { // 조건 부합
					res++;
					idx--;
				}
			}
		}
		
		System.out.println(res);
		
	}

}
