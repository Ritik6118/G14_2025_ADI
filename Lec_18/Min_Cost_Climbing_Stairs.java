package Lec_18;

public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {10,11,15};
		dp=new Integer[arr.length];
		int ans=Math.min(solve(arr,0),solve(arr,1));
		System.out.println(ans);
	}
	static Integer[] dp;
	public static int solve(int[] arr,int i) {
		
		if(i>=arr.length) {
			return 0;
		}
		if(dp[i]!=null) {
			return dp[i];
		}
		
		int a=solve(arr,i+1)+arr[i];
		int b=solve(arr,i+2)+arr[i];
		
		return dp[i]=Math.min(a, b);
		
	}

}
