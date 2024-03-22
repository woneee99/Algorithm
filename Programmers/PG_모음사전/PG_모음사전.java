class 모음사전 {
    char[] num = {'A', 'E', 'I', 'O', 'U'};
    int res;
    boolean chk;
    StringBuilder sb = new StringBuilder();
    public int solution(String word) {
        dfs(0, word);
        return res;
    }

    void dfs(int depth, String word) {
        if(word.equals(sb.toString())) {
            chk = true;
            return;
        }
        if(depth == 5 || chk) {
            return;
        }
        
        for(int i=0; i<5; i++) {
            res++;
            sb.append(num[i]);
            dfs(depth+1, word);
            sb.deleteCharAt(sb.length() - 1);
            if(chk) break;
        }
    }
}