import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj7682 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		StringBuilder sb = new StringBuilder();
		while(!(line = br.readLine()).equals("end")) {
			char[][] charArray = new char[3][3];
			
			int oCnt = 0; int xCnt = 0;
			boolean dot = false;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					charArray[i][j] = line.charAt(i * 3 + j);
					if(charArray[i][j] == 'O') oCnt++;
					else if(charArray[i][j] == 'X') xCnt++;
					else dot = true;
				}
			}
			
			// false �� ���
			// 1. o ���� > x ����, ( x - o ) �� ������ 1 ���� ū ���
			if(oCnt > xCnt || xCnt - oCnt > 1) {
				sb.append("invalid").append("\n");
				continue;
			}
			
			boolean chk = false;
			boolean isO = false;
			boolean isX = false;
			if(charArray[0][0] != '.' && charArray[0][0] == charArray[1][1] && charArray[1][1] == charArray[2][2]) {
				if(charArray[0][0] == 'O') isO = true;
				else isX = true;
				chk = true;
			}
			else if(charArray[0][2] != '.' && charArray[0][2] == charArray[1][1] && charArray[1][1] == charArray[2][0]) {
				if(charArray[0][2] == 'O') isO = true;
				else isX = true;
				chk = true;
			}
			for(int i=0; i<3; i++) {
				if(charArray[i][0] != '.' && charArray[i][0] == charArray[i][1] && charArray[i][1] == charArray[i][2]) {
					if(charArray[i][0] == 'O') isO = true;
					else isX = true;
					chk = true;
				}
				if(charArray[0][i] != '.' && charArray[0][i] == charArray[1][i] && charArray[1][i] == charArray[2][i]) {
					if(charArray[0][i] == 'O') isO = true;
					else isX = true;
					chk = true;
				}
			}

			if(isO && xCnt > oCnt) {
				sb.append("invalid").append("\n");
				continue;
			}
			if(isX && xCnt <= oCnt) {
				sb.append("invalid").append("\n");
				continue;
			}
			// 2. .�� �ִ� ���� ������ ���� �Ǿ�� �Ѵ�. 
			// 2-1. ���� �ƴѰ��
			// 2-2. o�� �����ε�, x�� ũ�Ⱑ ���� ���� ��� 
			if(dot) {
				if(!chk || isO && xCnt != oCnt || isX && isO ) {
					sb.append("invalid").append("\n");
					continue;
				}

			}
			sb.append("valid").append("\n");
		}
		System.out.println(sb.toString());
	}

}
