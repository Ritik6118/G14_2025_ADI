package Lec_16;
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<interval> pq=new PriorityQueue<>(new Comparator<interval>() {

			@Override
			public int compare(interval o1, interval o2) {
				// TODO Auto-generated method stub
				return o1.ed-o2.ed;
			}
		});
		for(int[] arr:intervals) {
			pq.add(new interval(arr[0],arr[1]));
		}
		
		int c=1;
		int et=pq.peek().ed;
		while(!pq.isEmpty()) {
			interval i=pq.poll();
			if(i.st>=et) {
				c++;
				et=i.ed;
			}
		}
		return intervals.length-c;
    }
}
class interval{
	int st;
	int ed;
	
	interval(int s,int e){
		this.st=s;
		this.ed=e;
	}
}