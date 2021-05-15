package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import util.Message;

/**
 * Use LinkedList to implement the directed graph
 * 
 * @param <V>
 * @author wangs and you
 */
public class ListDGraph<V> implements DGraph<V> {

	/** list of the vertices in a graph */
	private LinkedList<Vertex<V>> vList;

	/**
	 * constructor
	 */
	public ListDGraph() {
		vList = new LinkedList<Vertex<V>>();
	}

	@Override
	public int addV(V v) {
		/**
		 * TODO: implement the addV function;
		 */
		for (Vertex<V> vert : this.vList) {
			if (vert.getV().equals(v)) {
				System.out.println(Message.M2);
				return -1;
			}
		}

		Vertex<V> my_V = new Vertex<V>(v);
		vList.add(my_V);
		return this.vList.size();
	}

	@Override
	public boolean addE(Edge<V> e) {
		/**
		 * TODO: implement the addE function;
		 */
		boolean flagSrc = false;
		boolean flagDest = false;
		for (Vertex<V> v : this.vList) {
			if (v.getV().equals(e.getSource())) {
				flagSrc = true;
			}
			if (v.getV().equals(e.getDest())) {
				flagDest = true;
			}
		}
		
		if(!flagSrc || !flagDest ) {
			System.out.println(Message.M5);
			return false;
		}else {
			for (Vertex<V> vert : this.vList) {
				if (vert.getV().equals(e.getSource())) {
					for (Edge<V> edge : vert.getEdgeList()) {
						if (edge.equals(e)) {
							System.out.println(Message.M3);
							return false;
						}
					}
					vert.addEdge(e);
					return true;
				}
			}
		}
		
		return false;

		
	}

	@Override
	public V removeV(V v) {
		/**
		 * TODO: implement the removeV function;
		 */
		for (Vertex<V> vert : this.vList) {
			if (vert.getV().equals(v)) {
				return v;
			}
		}

		System.out.println(Message.M5);
		return null;
	}

	@Override
	public Edge<V> removeE(Edge<V> e) {
		/**
		 * TODO: implement the removeE function;
		 */

		for (Vertex<V> vert : this.vList) {

			if (vert.getV().equals(e.getSource())) {

				for (Edge<V> edge : vert.getEdgeList()) {

					if (edge.equals(e)) {
						Edge<V> myEdge = vert.getEdge(e.getDest());
						vert.removeEdge(e.getDest());
						return myEdge;
					}
				}
			}
		}

		System.out.println(Message.M6);
		return null;
	}

	@Override
	public V getV(int index) {
		/**
		 * TODO: implement the getV function;
		 */
		if (index >= this.vList.size()) { // Index out of range
			System.out.println(Message.M4);
			return null;
		} else {
			return this.vList.get(index).getV();
		}
	}

	@Override
	public Edge<V> getE(int src, int dest) {
		/**
		 * TODO: implement the getE function;
		 */
		boolean flagSrc = false;
		boolean flagDest = false;
		for (Vertex<V> v : this.vList) {
			if (v.getV().equals(this.getV(src))) {
				flagSrc = true;
			}
			if (v.getV().equals(this.getV(dest))) {
				flagDest = true;
			}
		}

		if (flagSrc && flagDest) {
			Edge<V> myEdge = new Edge<V>(this.getV(src), this.getV(dest));
			return myEdge;
		} else {
			System.out.println(Message.M4);
			return null;
		}
	}

	public void my_DFS(Vertex<V> vertex, ArrayList<V> branch, ArrayList<ArrayList<V>> branches) {
		
		Iterator<Edge<V>> itr = vertex.getEdgeList().iterator(); // getting vertex's edges
		
		while (itr.hasNext()) {

			////////////////////////////////////////////////////////////////////////////////////////////////////
			Edge<V> tmp_Edge = itr.next(); // get the edge
			V child = tmp_Edge.getDest(); // get the edge.dest
			Vertex<V> Child_Vertex = null; // create new vertex(edge.dest)
			// checking for a similar node
			for (Vertex<V> vert : this.vList) {
				if (vert.getV().equals(child)) {									///// get a child vertex (i.e. Child_Vertex) 
					Child_Vertex = vert;
					break;
				}
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////
			
			//===================================================================================================
			if(Child_Vertex != null) {
				branch.add(vertex.getV());													//// add node to the branch
			}
			//===================================================================================================
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////
			if(Child_Vertex.getEdgeList().isEmpty()) {	// base condition
				branch.add(child);
				ArrayList<V> new_branch = new ArrayList<V>(branch);
				branches.add(new_branch);										///// if that child vertex's has no child, add child ,EOF branch
				branch.remove(child);
				
			}else {
				my_DFS(Child_Vertex, branch, branches);
			}
			
			branch.remove(vertex.getV());										///// removing the parent node from list after it has no child left
		}
			
	}

	@Override
	public ArrayList<ArrayList<V>> branches(V v) {
		/**
		 * TODO: iterate the Graph from a given vertex and return all the branches from
		 * it;
		 */
		for (Vertex<V> vert : this.vList) {
			if (vert.getV().equals(v)) {
				ArrayList<ArrayList<V>> branches = new ArrayList<ArrayList<V>>();
				ArrayList<V> branch = new ArrayList<V>();
				this.my_DFS(vert, branch, branches);
				return branches;
			}
		}

		System.out.println(Message.M5);
		return null;
	}

	@Override
	public int[][] matrix() {
		/**
		 * TODO: generate the adjacency matrix of a graph;
		 */
		int size = vList.size();
		int[][] mtx = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				for(Vertex<V> vert : this.vList) {
					for(Edge<V> edge: vert.getEdgeList()) {
						if(edge.equals(this.getE(i, j))) {
							mtx[i][j] = 1;
						}
					}
				}
			}
		}
		return mtx;

	}
}