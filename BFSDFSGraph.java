package com.dsAlgo.graph;

import java.util.Iterator;
import java.util.LinkedList;

class Graph
{
	int V;
	LinkedList<Integer> adj[];
	
	Graph(int v)
	{
		V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]= new LinkedList<Integer>();
	}
	
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	
	public void dfs(int s)
	{
		boolean[] visited = new boolean[V];
		
		dfsUtil(s,visited);
	}
	
	private void dfsUtil(int s, boolean[] visited) {
		// TODO Auto-generated method stub
		
		visited[s] = true;
		
		System.out.print(s+ " ");
		
		Iterator<Integer> itr = adj[s].iterator();
		
		while(itr.hasNext())
		{
			int n = itr.next();
			if(!visited[n]) {
				visited[n]=true;
				dfsUtil(n, visited);
			}
		}
		
	}

	public void bfs(int s) {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[V];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.add(s);
		
		visited[s] = true;
		
		while(!queue.isEmpty())
		{
		   s = queue.poll();
		   
		   System.out.print(s+" ");
		   
		   Iterator<Integer> itr = adj[s].iterator();
		   
		   while(itr.hasNext())
		   {
			   int n = itr.next();
			   if(!visited[n])
			   {
				   visited[n]=true;
				   queue.add(n);
			   }
		   }
		}
	}
}

public class BFSDFSGraph
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Graph g = new Graph(4);
      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 2);
      g.addEdge(2, 0);
      g.addEdge(2, 3);
      g.addEdge(3, 3);
      
      System.out.println("BFS of the graph: ");
      g.bfs(2);
      System.out.println();
      System.out.println("DFS of the graph: ");
      
      g.dfs(2);


	}
}