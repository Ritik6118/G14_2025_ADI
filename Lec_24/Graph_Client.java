package Lec_24;

public class Graph_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g=new Graph(7);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(1, 4, 2);
		g.addEdge(4, 3, 4);
//		g.addEdge(3, 5, 2);
		g.addEdge(3, 5, 2);
		g.addEdge(5, 6, 9);
		g.addEdge(5, 7, 3);
		g.addEdge(6, 7, 3);
//		System.out.println(g.hasPath(1, 6));
//		System.out.println(g.hasPath_bfs(1, 6));
//		g.bft();
//		System.out.println(g.cycle_count());
//		g.display();
		g.dij(1);
	}

}
