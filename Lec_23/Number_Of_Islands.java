package Lec_23;

import java.util.LinkedList;
import java.util.Queue;

public class Number_Of_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public int numIslands(char[][] arr) {
		int c=0;
		boolean [][] vis=new boolean[arr.length][arr[0].length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]=='1' && vis[i][j]==false) {
					bfs(arr,i,j,vis);
					c++;
				}
			}
		}
		return c;
	}
	int [] r= {0,0,-1,1};
	int [] c= {-1,1,0,0};
	private void bfs(char[][] arr, int row, int col, boolean[][] vis) {
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
				if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && arr[nr][nc]=='1') {
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
