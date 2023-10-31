import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj4836 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null) {
			String[] str = line.split(" ");
			ArrayList<Integer> num = new ArrayList<>();
			boolean isTwirl = false, isHop = false, isDip = false;
			boolean oneCheck = false;
			
			for(int i=0; i<str.length; i++) {
				String isD = str[i];
				if(isD.equals("dip")) {
					isDip = true;
					if(i != 0 && str[i-1].equals("jiggle")) {
					}
					else if(i > 1 && str[i-2].equals("jiggle")) {
					}
					else if(i+1 < str.length && str[i+1].equals("twirl")) {
					}
					else if(!oneCheck){
						num.add(1);
						oneCheck = true;
						str[i] = "DIP";
					}
					else str[i] = "DIP";
				}
				else if(isD.equals("twirl")) isTwirl = true;
				else if(isD.equals("hop")) isHop = true;
			}
			
			if(str.length <= 3 || !str[str.length-1].equals("clap") || !str[str.length-2].equals("stomp") || !str[str.length-3].equals("clap")) {
				num.add(2);
			}
			
			if(isTwirl && !isHop) num.add(3);
			
			if(str[0].equals("jiggle")) num.add(4);
			
			if(!isDip) num.add(5);
			
			sb.append("form ");
			if(num.size() == 1) sb.append("error ").append(num.get(0)).append(":");
			else if(num.size() > 1) {
				sb.append("errors ").append(num.get(0));
				for(int i = 1; i<num.size(); i++) {
					if(i == num.size()-1) sb.append(" and ");
					else sb.append(", ");
					sb.append(num.get(i));
				}
				sb.append(":");
			}
			else sb.append("ok:");
			
			for(String s : str) {
				sb.append(" ").append(s);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
