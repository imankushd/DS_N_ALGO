package com.dsAlgo.graph;

import java.util.*;

public class Graph {

	private int V;
	private LinkedList<Integer> adj[];

	Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public static void main(String[] args) {

		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);

		// For Topological Sort
		Graph gg = new Graph(6);
		gg.addEdge(5, 2);
		gg.addEdge(5, 0);
		gg.addEdge(4, 0);
		gg.addEdge(4, 1);
		gg.addEdge(2, 3);
		gg.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		gg.topologicalSort();
	}

	private void topologicalSort() {

		Stack<Integer> stack = new Stack<Integer>();

		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++)
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {

		visited[v] = true;

		Iterator<Integer> itr = adj[v].listIterator();

		while (itr.hasNext()) {
			int n = itr.next();
			if (!visited[n])
				topologicalSortUtil(n, visited, stack);
		}

		stack.push(new Integer(v));

	}

	private void DFS(int s) {
		// TODO Auto-generated method stub

		boolean visited[] = new boolean[V];

		DFSUtil(s, visited);

		System.out.println();

	}

	private void DFSUtil(int s, boolean[] visited) {
		// TODO Auto-generated method stub

		System.out.print(s + " ");
		visited[s] = true;

		Iterator<Integer> itr = adj[s].listIterator();

		while (itr.hasNext()) {
			int n = itr.next();
			if (!visited[n])
				DFSUtil(n, visited);
			;
		}
	}

	private void BFS(int s) {

		LinkedList<Integer> queue = new LinkedList<Integer>();

		boolean visited[] = new boolean[V];

		queue.add(s);
		visited[s] = true;

		while (!queue.isEmpty()) {
			int ss = queue.poll();
			System.out.print(ss + " ");

			Iterator<Integer> itr = adj[ss].listIterator();

			while (itr.hasNext()) {
				int n = itr.next();
				if (!visited[n]) {
					queue.add(n);
					visited[n] = true;
				}
			}

		}

		System.out.println();
	}

}
