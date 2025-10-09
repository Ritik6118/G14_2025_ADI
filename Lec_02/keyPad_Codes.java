package Lec_02;

import java.util.ArrayList;
import java.util.List;

public class keyPad_Codes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> li=letterCombinations("23");
		System.out.println(li);
	}
	
	static String [] arr= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
	public static List<String> letterCombinations(String digits) {
		List<String> li=new ArrayList<>();
		solve(digits,li,"");
		return li;
	}

	private static void solve(String digits, List<String> li,String ans) {
		// TODO Auto-generated method stub
		
		if(digits.length()==0) {
			li.add(ans);
			return ;
		}
		char ch=digits.charAt(0);
		String s=arr[ch-'0'];
		for(int i=0;i<s.length();i++) {
			solve(digits.substring(1),li,ans+s.charAt(i));
		}
	}

}
