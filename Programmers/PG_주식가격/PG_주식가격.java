public class PG_주식가격 {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int length = prices.length;
		int[] answer = new int[length];
		
		for(int i=0; i<length; i++) {
			for(int j=i+1; j<length; j++) {
				if(prices[i] > prices[j] || j == length-1) {
					answer[i] = j-i;
					break;
				}
			}
		}
		
		for(int i=0; i<length; i++) {
			System.out.print(answer[i]);
		}
	}

}
