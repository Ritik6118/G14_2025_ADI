package Lec_18;

public class climbing_stairs {
	static Integer [] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		dp=new Integer[n+1];
		System.out.println(climbStairs(n));
	}

	public static int climbStairs(int n) {
		if(n<0) {
			return 0;
		}
		if(n==0) {
			return 1;
		}
		if(dp[n]!=null) {
			return dp[n];
		}
		
		int a=climbStairs(n-1);
		int b=climbStairs(n-2);
		return dp[n]=a+b;
	}

}
