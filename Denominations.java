
public class Denominations {
	public static void main(String[] args){
		getChange(20,1.25);
	}

	private static void getChange(double money, double prize) {
		// TODO Auto-generated method stub
		double difference = money-prize;
		double[] denominations = {0.01,0.05,0.10,0.25,0.50,1};
		int[] count = new int[denominations.length];
		while(difference>0){
			int max = getMaxDenominationToDivide(denominations,difference);
			difference -= denominations[max];
			difference = (double)Math.round(difference*100)/100;
			count[max] = count[max]+1;
		}
		System.out.print("[");
		for(int i = 0 ; i < count.length;i++){
			System.out.print(count[i]);
			if(i!=count.length-1)
				System.out.print(",");
		}
		System.out.print("]");
	}

	private static int getMaxDenominationToDivide(double[] denominations, double difference) {
		// TODO Auto-generated method stub
		int i;
		for(i = 0 ; i < denominations.length;i++){
			if(difference%denominations[i]<0 || difference/denominations[i]<1){
				break;
			}
		}
		return i-1;
	}
}
