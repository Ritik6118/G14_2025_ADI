package Lec_19;

public class Knapsac_0_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {1,2,3};
		int [] arr2= {4,5,1};
		int w=4;
		System.out.println(knapsack(2,arr,arr2));
	}
	public static int knapsack(int W, int val[], int wt[]) {
        // code here
		dp=new Integer[W+1][val.length];
        return solve(W,val,wt,0);
        
    }
	static Integer[][]dp;
	private static int solve(int cap, int[] val, int[] wt, int i) {
		// TODO Auto-generated method stub
		
		if(i==val.length) {
			return 0;
		}
		
		if(dp[cap][i]!=null) {
			return dp[cap][i];
		}
		int pick=0;
		if(cap>=wt[i]) {
			pick=solve(cap-wt[i],val,wt,i+1)+val[i];
		}
		int notpick=solve(cap,val,wt,i+1);
		
		
		return dp[cap][i]=Math.max(pick,notpick);
	}
}
