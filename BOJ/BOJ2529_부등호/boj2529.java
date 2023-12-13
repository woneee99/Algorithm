import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2529 {
    static int N;
    static char[] sign;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sign = br.readLine().replaceAll(" ", "").toCharArray();
        chk = new boolean[10];

        max(0, "");
        isTrue = false;
        Arrays.fill(chk, false);
        min(0, "");
    }

    static boolean[] chk;
    static boolean isTrue;
    static void min(int depth, String str) {
        if(isTrue) return;
        if(depth == N + 1) {
            System.out.println(str);
            isTrue = true;
            return;
        }

        for(int i=0; i<=9; i++) {
            if(chk[i]) continue;
            String strCopy = str;
            if(check(depth, str, i)) {
                str += i;
                chk[i] = true;
                min(depth+1, str);
                str = strCopy;
            }
            chk[i] = false;
        }
    }

    static void max(int depth, String str) {
        if(isTrue) return;
        if(depth == N + 1) {
            System.out.println(str);
            isTrue = true;
            return;
        }

        for(int i=9; i>=0; i--) {
            if(chk[i]) continue;
            String strCopy = str;
            if(check(depth, str, i)) {
                str += i;
                chk[i] = true;
                max(depth+1, str);
                str = strCopy;
            }
            chk[i] = false;
        }
    }

    static boolean check(int depth, String str, int i) {
        if(depth == 0) {
            return true;
        }
        else if(sign[depth-1] == '<' && str.charAt(str.length() - 1) - '0' < i) {
            return true;
        }
        else if(sign[depth-1] == '>' && str.charAt(str.length() - 1) - '0' > i) {
            return true;
        }
        return false;
    }
}