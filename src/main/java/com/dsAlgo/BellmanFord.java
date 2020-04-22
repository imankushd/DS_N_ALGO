package com.dsAlgo;

import java.util.GregorianCalendar;

public class BellmanFord {
	
	private int V;
	private int E;
	private Edge[] edge;
	
	class Edge
	{
		int src;
		int dest;
		int weight;
		Edge()
		{
			src = dest = weight =0;
		}
	}
	
	public BellmanFord(int V, int E) {
		
		this.V = V;
		this.E = E;
		edge = new Edge[E];
		for(int i=0;i<E;i++)
			edge[i] = new Edge();

	}
	
	
	public static void main(String... args)
	{
		BellmanFord graph = new BellmanFord(5, 8);
		
		// add edge 0-1 (or A-B in above figure) 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = -1; 
  
        // add edge 0-2 (or A-C in above figure) 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 4; 
  
        // add edge 1-2 (or B-C in above figure) 
        graph.edge[2].src = 1; 
        graph.edge[2].dest = 2; 
        graph.edge[2].weight = 3; 
  
        // add edge 1-3 (or B-D in above figure) 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 2; 
  
        // add edge 1-4 (or A-E in above figure) 
        graph.edge[4].src = 1; 
        graph.edge[4].dest = 4; 
        graph.edge[4].weight = 2; 
        
     // add edge 3-2 (or D-C in above figure) 
        graph.edge[5].src = 3; 
        graph.edge[5].dest = 2; 
        graph.edge[5].weight = 5; 
  
        // add edge 3-1 (or D-B in above figure) 
        graph.edge[6].src = 3; 
        graph.edge[6].dest = 1; 
        graph.edge[6].weight = 1; 
  
        // add edge 4-3 (or E-D in above figure) 
        graph.edge[7].src = 4; 
        graph.edge[7].dest = 3; 
        graph.edge[7].weight = -3; 
        
        graph.bellmanFord(graph, 0);
        
	}


	private void bellmanFord(BellmanFord graph, int src) {
		
		int dist[] = new int[V];
		
		for(int v=0;  v<V; v++)
		{
			dist[v] = Integer.MAX_VALUE;
		}
		
		dist[src] = 0;
		for(int i=0; i< V-1; i++)
		{
			for(int j=0; j<E; j++)
			{
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				
				if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}
		
		for(int j=0; j<E ;j++)
		{
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			
			if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight < dist[v])
			{
				System.out.println("Graph has negative weight cycle. Please check");
				return;
			}
			
		}
		
		printSolution(dist);
		
	}


	private void printSolution(int[] dist) {
		// TODO Auto-generated method stub
		for(int i=0; i<V; i++)
		{
			System.out.println(i+" >> "+dist[i]);
		}
	}

}
