import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj8979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 국가의 수
        int K = Integer.parseInt(st.nextToken()); // 등수 알고 싶은 국가

        ArrayList<Medal> medals = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            medals.add(new Medal(nation, gold, silver, bronze));
        }

        Collections.sort(medals);
        int rank = 0, cnt = 1;
        int gold = 0, silver = 0, bronze = 0;
        for(Medal medal : medals) {
            if(medal.gold != gold || medal.silver != silver || medal.bronze != bronze) {
                gold = medal.gold;
                silver = medal.silver;
                bronze = medal.bronze;

                rank = cnt == 0 ? ++rank : rank + cnt;
                cnt = 1;
            }
            else {
                cnt++;
            }

            if(medal.nation == K) {
                System.out.println(rank);
                break;
            }
        }
    }

    static class Medal implements Comparable<Medal>{
        int nation;
        int gold;
        int silver;
        int bronze;

        public Medal(int nation, int gold, int silver, int bronze) {
            this.nation = nation;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Medal o) {
            if(o.gold == this.gold) {
                if(o.silver == this.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }
}