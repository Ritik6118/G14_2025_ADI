package Lec_22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	HashMap<Integer, HashMap<Integer, Integer>> map;

	Graph() {
		map = new HashMap<>();
	}

	Graph(int n) {
		map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addVtx(int v) {
		map.put(v, new HashMap<>());
	}

	public void removeVtx(int v) {
		for (int i : map.get(v).keySet()) { // loop for neighbours
			map.get(i).remove(v); // removal of current vtx ftom neighbours hashmap
		}
		map.remove(v); // removal of vtx from map
	}

	public void addEdge(int v1, int v2, int wt) {
		map.get(v1).put(v2, wt);
		map.get(v2).put(v1, wt);
	}

	public void updateEdge(int v1, int v2, int wt) {
		addEdge(v1, v2, wt);
	}

	public void removeEdge(int v1, int v2) {
		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}

	public void display() {
		System.out.println(map);
	}

	HashSet<Integer> vis = new HashSet<>();

	public boolean hasPath(int src, int des) { // dfs

		if (src == des) {
			return true;
		}
		if (vis.contains(src)) {
			return false;
		}
		for (int i : map.get(src).keySet()) {
			vis.add(src);
			if (hasPath(i, des) == true) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPath_bfs(int src, int des) {
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> vis = new HashSet<>();

		q.add(src);
		while (!q.isEmpty()) {
			int n = q.poll();
			if (vis.contains(n)) {
				continue;
			}
			vis.add(n);

			if (n == des) {
				return true;
			}
			for (int i : map.get(n).keySet()) {
				q.add(i);
			}
		}
		return false;
	}

	public void bft() {

		HashSet<Integer> vis = new HashSet<>();

		for (int i : map.keySet()) {
			if (!vis.contains(i)) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				while (!q.isEmpty()) {
					int n = q.poll();
					if (vis.contains(n)) {
						continue;
					}
					vis.add(n);
					System.out.println(n);
					for (int j : map.get(n).keySet()) {
						q.add(j);
					}
				}
			}
		}
	}

	public int cycle_count() {
		HashSet<Integer> vis = new HashSet<>();

		int c = 0;
		for (int i : map.keySet()) {
			if (!vis.contains(i)) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				while (!q.isEmpty()) {
					int n = q.poll();
					if (vis.contains(n)) {
						c++;
						continue;
					}
					vis.add(n);
//					System.out.println(n);
					for (int j : map.get(n).keySet()) {
						if (!vis.contains(j)) {
							q.add(j);
						}
					}
				}
			}
		}
		return c;
	}

}
