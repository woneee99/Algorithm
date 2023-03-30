import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj2239 {
	static int[][] sudoku;
	static ArrayList<int[] > zero = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		
		
		for(int i=0; i<9; i++) {
			String line = br.readLine();
			for(int j=0; j<9; j++) {
				sudoku[i][j] = line.charAt(j) - '0';
				if(sudoku[i][j] == 0) zero.add(new int[] {i, j});
			}
		}
		cal(0);
		
	}
	static StringBuilder sb = new StringBuilder();
	static void cal(int cnt) {
		if(cnt == zero.size()) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}

		int x = zero.get(cnt)[0];
		int y = zero.get(cnt)[1];
		boolean[] chk = new boolean[10];
		
		for(int i=0; i<9; i++) {
			if(sudoku[x][i] != 0) chk[sudoku[x][i]] = true;
			if(sudoku[i][y] != 0) chk[sudoku[i][y]] = true;
		}
		
		int nx = 3 * (x / 3);
		int ny = 3 * (y / 3);
		
		for(int i=nx; i<nx+3; i++) {
			for(int j=ny; j<ny+3; j++) {
				if(sudoku[i][j] != 0) chk[sudoku[i][j]] = true;
			}
		}
		
		for(int i=1; i<=9; i++) {
			if(!chk[i]) {
				sudoku[x][y] = i;
				cal(cnt+1);
				sudoku[x][y] = 0;
			}
		}
	}
	
	
}
