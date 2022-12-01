import java.util.*;

public class Lab12 {

	public static void main(String[] args) {
		//creates the graph
		Graph g = new Graph(7);
		
		//adds the edges
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(1, 3);
		g.addEdge(3, 5);
		
		//starts the print statement
		System.out.print("Depth First Traversal: ");
		
		//starts the search at vertex 0
		g.search(0);
		
		//test case starting at vertex 3
		//g.search(3);

	}
	
	static class Graph {
		//number of vertices
		int V;
		//makes an array of lists for usage
		LinkedList<Integer>[] adj;
		
		//graph constructor
		Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];
			
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		//adds an edge to the graph
		void addEdge(int v, int w) {
			adj[v].add(w);
		}
		
		//the main dps method, traverses and prints out the vertexes as it does
		void print(int v, boolean visited[]) {
			//if its been visited, print
			visited[v] = true;
			System.out.print(v + " ");
			
			//if it hasnt been visited, call the print method again
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext()) {
				int j = i.next();
				if (!visited[j]) {
					print(j, visited);
				}
			}
		}
		
		//calls the print method and makes the visited boolean
		void search(int v) {
			boolean visited[] = new boolean[V];
			print(v, visited);
		}
	}

}
