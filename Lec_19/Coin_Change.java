package Lec_19;

public class Coin_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] coins= {1,2,5};
		int amount=11;
		dp=new Integer[coins.length][amount+1];
		int a=solve(coins,amount,0);
		if(a==99999) {
			System.out.println(-1);
		}
		else {
			System.out.println(a);			
		}
//		System.out.println(solve(coins,amount,0));
	}
	static Integer[][] dp;

	private static int solve(int[] arr, int amount, int i) {
		// TODO Auto-generated method stub
	
		if(i>=arr.length) {
			return 99999;
		}
		if(amount==0) {
			return 0;
		}
//		if(amount<0) {
//			return -1;
//		}
		if(dp[i][amount]!=null) {
			return dp[i][amount];
		}
		int pick=99999;
		if(amount>=arr[i]) {
			pick=solve(arr,amount-arr[i],i)+1;		
		}
		int notpick=solve(arr,amount,i+1);
		
		return dp[i][amount]= Math.min(pick,notpick);
	}

}
