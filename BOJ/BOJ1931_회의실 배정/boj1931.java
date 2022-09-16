import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Classroom implements Comparable<Classroom>{
	int start;
	int end;
	
	Classroom(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Classroom o) {
		if(this.end == o.end) return this.start - o.start;
		return this.end - o.end;
	}
}
public class boj1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Classroom> arr = new ArrayList<>();
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Classroom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr);
		
		int tmp = 0, count = 0;
		for(int i=0; i<n; i++) {
			if(arr.get(i).start >= tmp) {
				tmp = arr.get(i).end;
				count++;
			}
		}
		System.out.println(count);
	}

}
