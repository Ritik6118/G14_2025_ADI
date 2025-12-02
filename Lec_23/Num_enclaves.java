package Lec_23;

import java.util.LinkedList;
import java.util.Queue;

public class Num_enclaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numEnclaves(int[][] arr) {
		
		boolean [][] vis=new boolean[arr.length][arr[0].length];
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0]==1 && vis[i][0]==false) {
				bfs(arr,i,0,vis);
			}
			if(arr[i][arr[0].length-1]==1 && vis[i][arr[0].length-1]==false) {
				bfs(arr,i,arr[0].length,vis);
			}
		}
		
		for(int i=0;i<arr[0].length;i++) {
			if(arr[0][i]==1 && vis[0][i]==false) {
				bfs(arr,0,i,vis);
			}
			if(arr[arr.length-1][i]==1 && vis[arr.length-1][i]==false) {
				bfs(arr,arr.length-1,i,vis);
			}
		}
		int c=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==1 && vis[i][j]==false) {
					c++;
				}
			}
		}
		return c;
	}
	int [] r= {0,0,-1,1};
	int [] c= {-1,1,0,0};
	private void bfs(int[][] arr, int row, int col, boolean[][] vis) {
		// TODO Auto-generated method stub
		Queue<pair> q=new LinkedList<pair>();
		q.add(new pair(row,col));
		while(!q.isEmpty()) {
			pair p=q.poll();
			if(vis[p.row][p.col]==true) {
				continue;
			}
			vis[p.row][p.col]=true;
			for(int i=0;i<4;i++) {
				int nr=p.row+r[i];
				int nc=p.col+c[i];
				if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && arr[nr][nc]==1 && vis[nr][nc]==false) {
					q.add(new pair(nr,nc));
				}
				
			}
			
		}
	}

}
class pair{
	int row;
	int col;
	
	pair(){}
	pair(int r,int c){
		this.row=r;
		this.col=c;
	}
}
