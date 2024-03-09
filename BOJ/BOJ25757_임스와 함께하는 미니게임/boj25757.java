import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj25757 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);
		
		HashSet<String> person = new HashSet<>();
		for(int i=0; i<N; i++) {
			person.add(br.readLine());
		}
		int res = 0;
		if(game == 'Y') {
			res = person.size();
		}
		else if(game == 'F') {
			res = (person.size() / 2);
		}
		else if(game == 'O') {
			res = (person.size() / 3);
		}
		System.out.println(res);
	}

}
