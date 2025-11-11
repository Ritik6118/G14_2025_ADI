package Lec_05;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr= {2,3,6,7};
		int t=7;
		List<List<Integer>> li= combinationSum(arr,t);
		for(List<Integer> l:li) {
			System.out.println(l);
		}
	}
	static List<Integer> li=new ArrayList<>();
	static List<List<Integer>> ans=new ArrayList<>();
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,0,0);
        return ans;
    }
	private static void helper(int[] arr, int target, int i,int sum) {
		// TODO Auto-generated method stub
		if(i>=arr.length) {
			return;
		}
		if(sum==target ) {
			ans.add(new ArrayList<>(li));
//			System.out.println(li);
			return;
		}
		
		if(sum+arr[i]<=target) {
			li.add(arr[i]);
			helper(arr,target,i,sum+arr[i]);
			li.remove(li.size()-1);			
		}
		
		helper(arr,target,i+1,sum);
	}
}
