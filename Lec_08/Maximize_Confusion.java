package Lec_08;

public class Maximize_Confusion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="TFFT";
		int k=1;
		System.out.println(Math.max(findMax(s,k,'T'),findMax(s,k,'F')));
	}

	private static int findMax(String s, int k, char c) {
		// TODO Auto-generated method stub
		int si=0;
		int ei=0;
		int ans=0;
		while(ei<s.length()) {
			if(s.charAt(ei)!=c) {
				k--;
			}
			while(si<ei && k<0) {
				if(s.charAt(si)!=c) {
					k++;
				}
				si++;
			}
			ans=Math.max(ans, ei-si+1);
			ei++;
		}
		return ans;
	}

}
