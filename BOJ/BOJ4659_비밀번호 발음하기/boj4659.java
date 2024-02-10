import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj4659 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null) {
			if(line.equals("end")) break;
			
			if(!line.contains("a") && !line.contains("e") && !line.contains("i") && !line.contains("o") && !line.contains("u")) {
				sb.append("<").append(line).append(">").append(" ").append("is").append(" ").append("not acceptable.").append("\n");
				continue;
			}
			
			int cntConsonant = 0, cntGather = 0;
			if(line.charAt(0) == 'a' || line.charAt(0) == 'e' || line.charAt(0) == 'i' || line.charAt(0) == 'o' || line.charAt(0) == 'u') {
				cntConsonant = 1;
			}
			else cntGather = 1;
			
			boolean chk = false;
			for(int i=1; i<line.length(); i++) {
				if(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u') {
					cntConsonant++;
					cntGather = 0;
				}
				else {
					cntGather++;
					cntConsonant = 0;
				}
				
				if(cntGather == 3 || cntConsonant == 3) {
					chk = true;
					break;
				}
				if(line.charAt(i-1) == line.charAt(i)) {
					if(line.charAt(i) == 'e' || line.charAt(i) == 'o') continue;
					chk = true;
					break;
				}
			}
			
			if(chk) {
				sb.append("<").append(line).append(">").append(" ").append("is").append(" ").append("not acceptable.").append("\n");
				continue;
			}
			sb.append("<").append(line).append(">").append(" ").append("is").append(" ").append("acceptable.").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
