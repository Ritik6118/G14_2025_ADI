package Lec_02;

import java.util.ArrayList;
import java.util.List;

public class balanced_parenthesis {
	public static void main(String[] args) {

		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> li =new ArrayList<>();
		solve(n,"",li,0,0);
		return li;
	}

	private static void solve(int n, String ans, List<String> li, int o, int c) {
		// TODO Auto-generated method stub
		if(o>n ||c>n) {
			return;
		}
		
		if(n==o && n==c) {
			li.add(ans);
//			System.out.println(ans);
			return;
		}
		if(o<n) {
			solve(n,ans+"(",li,o+1,c);			
		}
		if(o>c) {
			solve(n,ans+")",li,o,c+1);			
		}
	}
}
