import java.util.HashSet;

public class PG_영어끝말잇기 {

	public static void main(String[] args) {
		int n = 2;
		int[] answer = new int[2];
		
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        
        char c = words[0].charAt(words[0].length()-1);
        for(int i=1; i<words.length; i++) {
            char f = words[i].charAt(0);
            if(!hs.contains(words[i]) && c == f) {
                hs.add(words[i]);
                c = words[i].charAt(words[i].length()-1);
            }
            else {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
	}

}
