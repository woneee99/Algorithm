
public class PG_네트워크 {
	static boolean[] chk;
	static int[] com;
	public static void main(String[] args) throws Exception {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		com = new int[computers.length];
		chk = new boolean[com.length];
		int cnt = 0;
		for (int i = 0; i < com.length; i++) {
			if (!chk[i]) {
				cnt++;
				cal(i, computers);
			}
		}
		
		System.out.println(cnt);
	}

	static void cal(int idx, int[][] computers) {
		chk[idx] = true;
		for (int j = 0; j < computers[idx].length; j++) {
			if(computers[idx][j] == 1 && !chk[j]) {
				cal(j, computers);
			}
		}
	}
}
