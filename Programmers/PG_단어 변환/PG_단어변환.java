
public class PG_단어변환 {

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		chk = new boolean[words.length];

        dfs(0, begin, target, words);
        max = max == 12 ? 0 : max;
        System.out.println(max);
	}

    static int max = 12;
    static boolean[] chk;
    static void dfs(int depth, String begin, String target, String[] words) {
        if(begin.equals(target)) {
            max = max > depth ? depth : max;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(chk[i]) continue;
            String word = words[i];
            
            int cnt = 0;
            for(int j=0; j<begin.length(); j++) {
                if(begin.charAt(j) != word.charAt(j)) {
                    cnt++;
                }
            }
            if(cnt == 1) {
                chk[i] = true;
                dfs(depth+1, word, target, words);
                chk[i] = false;
            }
        }
    }
}
