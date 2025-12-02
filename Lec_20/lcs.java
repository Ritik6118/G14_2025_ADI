package Lec_20;

public class lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcdef";
		String s2="ace";
		System.out.println(longestCommonSubsequence(s1,s2));
	}

	public static int longestCommonSubsequence(String s1, String s2) {
		dp=new Integer[s1.length()][s2.length()];
		return lcs(s1,s2,0,0);
	}
	static Integer[][] dp;
	private static int lcs(String s1, String s2, int i, int j) {
		// TODO Auto-generated method stub
		if(i==s1.length()|| j==s2.length()) {
			return 0;
		}
		if(dp[i][j]!=null) {
			return dp[i][j];
		}
		int pick=0;
		int notpick=0;
		if(s1.charAt(i)==s2.charAt(j)) {
			pick=lcs(s1,s2,i+1,j+1)+1;
		}
		else {
			notpick=Math.max(lcs(s1,s2,i+1,j), lcs(s1,s2,i,j+1));
		}
		
		return dp[i][j]=Math.max(pick, notpick);
	}

}
