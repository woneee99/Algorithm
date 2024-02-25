import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj1141 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] line = new String[N];
		for(int i=0; i<N; i++) {
			line[i] = br.readLine();
		}
		
		Arrays.sort(line);
		ArrayList<String> arr = new ArrayList<>();
		for(int i=N-1; i>=0; i--) {
			boolean chk = false;
			
			for(int j=0; j<arr.size(); j++) {
				if(arr.get(j).startsWith(line[i])) {
					chk = true;
					break;
				}
			}
			
			if(!chk) arr.add(line[i]);
		}
		System.out.println(arr.size());
	}

}

/**

hello
hi
rerun
running

h
run

**/