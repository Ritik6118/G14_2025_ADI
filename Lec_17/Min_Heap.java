package Lec_17;

import java.util.ArrayList;

public class Min_Heap {
	ArrayList<Integer> li=new ArrayList<>();
	
	public void add(int n) {
		li.add(n);
		upheapify(li.size()-1);
	}
	
	
	private void upheapify(int i) {
		// TODO Auto-generated method stub
		if(i==0) {
			return;
		}
		int p=getp(i);
		if(li.get(i)<li.get(p)) {
			swap(i,p);
			upheapify(p);
		}
	}


	public int remove() {
		int temp=li.get(0);
		swap(0,li.size()-1);
		li.remove(li.size()-1);
		
		downheapify(0);
		
		return temp;
		
	}
	
	private void downheapify(int i) {
		// TODO Auto-generated method stub
		int min=i;
		int lc=getlc(i);
		int rc=getrc(i);
		
		if(lc<li.size() && li.get(min)>li.get(lc)) {
			min=lc;
		}
		if(rc<li.size() && li.get(min)>li.get(rc)) {
			min=rc;
		}
		
		if(min!=i) {
			swap(min,i);
			downheapify(min);
		}
	}


	private int getlc(int i) {
		return (2*i)+1;
	}
	private int getrc(int i) {
		return (2*i)+2;
	}
	private int getp(int i) {
		return (i-1)/2;
	}
	
	private void swap(int i ,int j) {
		int temp=li.get(i);
		li.set(i, li.get(j));
		li.set(j, temp);
	}
}
