package Lec_15;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Fractional_knapsac {
	public double fractionalKnapsack(int[] val, int[] wt, int cap) {
        // code here
        PriorityQueue<item> pq=new PriorityQueue<item>(new  Comparator<item>() {

			@Override
			public int compare(item o1, item o2) {
				// TODO Auto-generated method stub
				double v1=o1.val*1.0/o1.wt*1.0;
				double v2=o2.val*1.0/o2.wt*1.0;
				
//				return (int)(v2-v1);
				if(v1<v2) {
					return 1;
				}
				else if(v1==v2){
					return 0;
				}
				else {
					return -1;
				}
//				return 0;
			}
		
        });
        for(int i=0;i<val.length;i++) {
        	pq.add(new item(val[i],wt[i]));
        }
        
        double ans=0;
        while(!pq.isEmpty()) {
        	item i=pq.poll();
        	if(cap>=i.wt) {
        		ans+=i.val;
        		cap-=i.wt;
        	}
        	else {
        		double v=i.val*1.0/i.wt*1.0;
        		ans+=v*cap;
        		break;
        	}
        }
        return ans;
    }
}
class item{
	int val;
	int wt;
	
	item(int v, int w){
		int val=v;
		int wt=w;
	}
}
