package Lec_07;

public class Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcabcbb";
		solve(s);
	}

	private static void solve(String s) {
		// TODO Auto-generated method stub
		
		// window initialization
		int si=0;
		int ei=0;
		int ans=0;
		int [] arr=new int[128];
		while(ei<s.length()) {
			arr[s.charAt(ei)]++;   // expansion of window
			while(si<ei && arr[s.charAt(ei)]>1) {  // shrinking if invalid
				arr[s.charAt(si)]--;
				si++;
			}
			ans=Math.max(ans, ei-si+1); // ans calculation
			ei++;
		}
		System.out.println(ans);
	}

}
