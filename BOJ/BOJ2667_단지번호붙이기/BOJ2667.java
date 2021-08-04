import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static boolean[][] list;
	static boolean[][] check;
	static int num, cnt;
	static int arrnum = 1;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		list = new boolean[num][num];
		check = new boolean[num][num];
		
		for(int i=0; i<num; i++) {
			String line = br.readLine();
			for(int j=0; j<num; j++) {
				int a = line.charAt(j) - '0';
				if(a == 1) {
					list[i][j] = true;
				}
				else list[i][j] = false;
			}
		}
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(checkList(i, j) == true) {
					cnt++;
					BFS(i,j);
					arr.add(arrnum);
					arrnum = 1;
				}
			}
		} 
		
		System.out.println(cnt);
		Collections.sort(arr);
		for(int i=0; i<cnt; i++) {
			System.out.print(arr.get(i) + "\n");
		}
	}
	static boolean checkList(int x, int y) {
		if(x<0 || x>=num || y<0 || y>=num ) return false;
		if(list[x][y] == false || check[x][y] == true) return false;
		return true;
	}
	static void BFS(int x, int y) {
		check[x][y] = true;
		if(checkList(x+1, y)) {
			arrnum++;
			BFS(x+1, y);
		}
		if(checkList(x, y+1)) {
			arrnum++;
			BFS(x, y+1);
		}
		if(checkList(x-1, y)) {
			arrnum++;
			BFS(x-1, y);
		}
		if(checkList(x, y-1)) {
			arrnum++;
			BFS(x, y-1);
		}
	}
}
