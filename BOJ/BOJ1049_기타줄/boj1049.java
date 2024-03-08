import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1049 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int pack = 1001, one = 1001;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int packMoney = Integer.parseInt(st.nextToken());
			int oneMoney = Integer.parseInt(st.nextToken());
			one = Math.min(oneMoney, one);
			pack = Math.min(packMoney, pack);
		}
		
		int oneCal = one * N;
		int packCal = Math.min((N / 6) * pack + (N % 6) * one, ((N / 6) + 1) * pack) ;
		System.out.println(Math.min(oneCal, packCal));
	}

}
