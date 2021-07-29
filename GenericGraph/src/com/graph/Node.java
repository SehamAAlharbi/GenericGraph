package com.graph;

import java.util.UUID;

/**
 * class to represent each vertex - each got key value -> edgeLabel to -> end
 * node
 * 
 * @author SehamAlharbi
 * @param <K> vertices
 * @param <E> relationships
 */

public class Node<K, E> {

	K key = null;
	K endNode = null;
	E edgeLabel = null;

	public Node(K key, K endNode, E edgeLable) {
		this.key = key;
		this.endNode = endNode;
		this.edgeLabel = edgeLable;

	}

	/**
	 * Because the key -K- is not represented by any type e.g., String, Integer ..
	 * that would be easy to be compared to each other .. We need to override the
	 * equals method to do the equality check
	 */
	@Override
	public boolean equals(Object node) {
		return key.equals(node);
	}

	/**
	 * If two objects are equal according to the equals(Object) method, calling the
	 * hashCode() method on each of the two objects must produce the same value.
	 */
	@Override
	public int hashCode() {
		return key.hashCode();
	}

	public UUID generateID() {
		return UUID.randomUUID();
	}

	/**
	 * To print the node data whenever needed
	 */
	public String toString() {
		return " { Key: " + key + " , End Node: " + endNode + " , Edge Label: " + edgeLabel + " } ";
	}
}
