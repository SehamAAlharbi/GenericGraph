package com.graph;

import java.util.*;


/**
 * @author SehamAlharbi
 * The whole graph is represented by K keys - start - vertices and a list of their neighbours - Node objects
 * @param <K> vertices 
 * @param <E> relationships
 */

public class Graph <K,E> {
	
	// Representation of each node, and its edges with the other nodes
	Map <K, List<Node<K,E>>> graph = null;
	
	public Graph (){
		graph = new HashMap <> ();
	}
	
	/**
	 * This adds a direct edge from v1 to v2 in directed graph
	 * @param v1 start vertex 
	 * @param v2 end vertex
	 * @param edgeLable the weight 
	 * @return
	 */
	public boolean addDirectEdge( K v1 , K v2, E edgeLabel) {
		
		if (!graph.containsKey(v1)) {
			graph.put(v1, new LinkedList<>());
		}
		
		graph.get(v1).add(new Node<>(v1,v2,edgeLabel));
	
	return true;
}
	
	/**
	 * This adds an undirected edge between both v1 and v2 in undirected graph
	 * @param v1 start vertex
	 * @param v2 end vertex
	 * @param edgeLabel the weight
	 * @return
	 */
	public boolean addIndirectEdge (K v1 , K v2, E edgeLabel) {
		addDirectEdge (v1, v2, edgeLabel);
		addDirectEdge (v2, v1, edgeLabel);
		
		return true;
	}
	
	/**
	 * get the nodes and send them to the method that implements the DFS algorithm
	 */
	public boolean hasPathDFS(K source, K destination) {


		// a flag to keep track of the visited node to avoid infinite calls
		HashSet<K> visited = new HashSet<K>();

		// sending the nodes after retrieving them using their id's - calling the other
		// overloaded method
		return hasPathDFS(source, destination, visited);

	}
	
	
	/**
	 * overloaded recursive method that does the DFS algorithm implementation, stack-like implementation
	 * @param source
	 * @param destination
	 * @param visited
	 * @return
	 */
	private boolean hasPathDFS(K source, K destination, HashSet<K> visited) {

		// if the node has been visited before and no path found - using id because the
		// hash set keep only integers
		if (visited.contains(source)) {
			return false;
		}

		// if not visited, then put it in the visited hash set
		visited.add(source);

		// if the node we look for is the node we start from itself - if -d- is -s-
		// basically
		if (source.equals(destination)) {
			return true;
		}

		// final option is to start looping through all adjacent nodes and their
		// adjacent nodes till finding -d-
		
		for (K child : graph.keySet()) {
			if (hasPathDFS(child, destination, visited)) {
				return true;
			}
		}
		
		
//		for (Node child : source.adjacent) {
//			// recursive call
//			if (hasPathDFS(child, destination, visited)) {
//				return true;
//			}
//		}

		// if after all, no path is found
		return false;
	}
	
	
	/**
	 *  To print the graph data whenever needed
	 */
	public String toString () {
		String data = "";
		for (K key : graph.keySet()) {
			
			// print the value of the key - the value is nothing but a list of Node objects - ..
			// toString method of the class Node is called in each loop
			data += key + "==> [ " + graph.get(key) + "] \n";
		}
		
		return data;
	}

}
