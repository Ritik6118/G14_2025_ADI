package Lec_12;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {

	public static void main(String[] args) {
		
		List<List<String>> li=solveNQueens(4);
		for(List<String> l:li) {
			for(String s:l) {
				System.out.println(s);				
			}
			System.out.println();
			System.out.println();
		}
	}
	static List<List<String>> ans=new ArrayList<>();
	public static List<List<String>> solveNQueens(int n) {
		boolean [][] arr=new boolean [n][n];
		solve(arr,0);
		return ans;
		
	}

	private static void solve(boolean[][] arr, int r) {
		// TODO Auto-generated method stub
		if(r==arr.length) {
			addAns(arr);
			return;
		}
		for(int i=0;i<arr[0].length;i++) {
			if(isPossible(arr,r,i)) {
				arr[r][i]=true;
				solve(arr,r+1);
				arr[r][i]=false;
			}
		}
	}

	private static void addAns(boolean[][] arr) {
		// TODO Auto-generated method stub
		List<String> l=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			String s="";
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==true) {
					s+="Q";
				}
				else {
					s+='.';
				}
			}
			l.add(s);
		}
		ans.add(l);
	}

	private static boolean isPossible(boolean[][] arr, int r, int c) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++) {
			if(arr[r][i]==true ||arr[i][c]==true) {
				return false;
			}
		}
//		upper left diagonal
		int row=r;
		int col=c;
		while(row>=0 && col>=0) {
			if(arr[row][col]==true) {
				return false;
			}
			row--;
			col--;
		}
		// upper right diagonal
		row=r;
		col=c;
		while(row>=0 && col<arr[0].length) {
			if(arr[row][col]==true) {
				return false;
			}
			row--;
			col++;
		}
		return true;
	}
}
