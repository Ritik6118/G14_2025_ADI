package Lec_21;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	HashMap<Integer,HashMap<Integer,Integer>> map;
	
	Graph(){
		map=new HashMap<>();
	}
	Graph(int n){
		map=new HashMap<>();
		for(int i=1;i<=n;i++) {
			map.put(i, new HashMap<>());
		}
	}
	
	public void addVtx(int v) {
		map.put(v, new HashMap<>());
	}
	public void removeVtx(int v) {
		for(int i:map.get(v).keySet()) {  // loop for neighbours
			map.get(i).remove(v);         // removal of current vtx ftom neighbours hashmap
		}
		map.remove(v);   // removal of vtx from map
	}
	
	public void addEdge(int v1, int v2,int wt) {
		map.get(v1).put(v2,wt);
		map.get(v2).put(v1,wt);
	}
	public void updateEdge(int v1, int v2,int wt) {
		addEdge(v1,v2,wt);
	}
	public void removeEdge(int v1, int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}
	public void display() {
		System.out.println(map);
	}
	HashSet<Integer> vis=new HashSet<>();
	public boolean hasPath(int src,int des) {    // dfs
		
		if(src==des) {
			return true;
		}
		if(vis.contains(src)) {
			return false;
		}
		for(int i:map.get(src).keySet()) {
			vis.add(src);
			if(hasPath(i,des)==true) {
				return true;
			}
		}
		return false;
	}
	

}
