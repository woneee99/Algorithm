import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2828 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(br.readLine());
		
		int start = 1, end = M;
		int res = 0;
		for(int i=0; i<J; i++) {
			int loc = Integer.parseInt(br.readLine());
			if(loc >= start && loc <= end) continue;
			if(loc < start) {
				res += start - loc;
				end -= start - loc;
				start = loc;
			}
			else if(loc > end){
				res += loc - end;
				start += loc - end;
				end = loc;
			}
		}
		System.out.println(res);
	}

}
