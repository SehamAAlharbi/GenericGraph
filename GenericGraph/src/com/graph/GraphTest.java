package com.graph;

/**
 * Test the graph - class with main method
 * 
 * @author SehamAlharbi
 */
public class GraphTest {

	public static void main(String[] args) {

		Graph<String, String> graph = new Graph<>();

		// Direct edge
//		graph.addDirectEdge("A", "B", "6");

		// Indirect edge
		graph.addIndirectEdge("A", "B", "6");
		graph.addIndirectEdge("A", "D", "1");
		graph.addIndirectEdge("D", "B", "2");
		graph.addIndirectEdge("D", "E", "1");
		graph.addIndirectEdge("B", "E", "2");
		graph.addIndirectEdge("B", "C", "5");
		graph.addIndirectEdge("E", "C", "5");

		// toString method of the class Graph is called
		System.out.println(graph);
		System.out.println(graph.hasPathDFS("A", "B"));

	}
}