import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Check{
	int dir;
	int dis;
	
	public Check(int dir2, int dis2) {
		this.dir = dir2;
		this.dis = dis2;
	}
}
public class boj2564 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken()); //가로
		int c = Integer.parseInt(st.nextToken()); //세로
		
		int total = r+c;
		
		int n = Integer.parseInt(br.readLine()); //상점 개수
		
		ArrayList<Check> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			arr.add(new Check(dir, dis));
		}
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int dis = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		for(int i=0; i<arr.size(); i++) {
			Check one = arr.get(i);
			int nowDir = one.dir;
			int nowDis = one.dis;
			
			if(nowDir == dir) {
				sum += Math.abs(nowDis - dis);
				continue;
			}
			
			if(dir == 1) { //북
				if(nowDir == 3) {
					sum += nowDis + dis;
				}
				else if(nowDir == 4) {
					sum += nowDis + (r-dis);
				}
				else {
					int chk = dis + c + nowDis;
					sum += total > chk ? chk : total*2-chk;
				}
			}
			else if(dir == 2) { //남
				if(nowDir == 3) {
					sum += dis + (c-nowDis);
				}
				else if(nowDir == 4) {
					sum += (r-dis) + (c-nowDis);
				}
				else {
					int chk = dis + c + nowDis;
					sum += total > chk ? chk : total*2-chk;
				}
			}
			else if(dir == 3) { //서
				if(nowDir == 1) {
					sum += dis + nowDis;
				}
				else if(nowDir == 2) {
					sum += nowDis + (c-dis);
				}
				else {
					int chk = dis + r + nowDis;
					sum += total > chk ? chk : total*2-chk;
				}
			}
			else { //동
				if(nowDir == 1) {
					sum += dis + (r-nowDis);
				}
				else if(nowDir == 2) {
					sum += (c-dis) + (r-nowDis);
				}
				else {
					int chk = dis + r + nowDis;
					sum += total > chk ? chk : total*2-chk;
				}
			}
		}
		System.out.println(sum);
		
	}

}
