package com.dsAlgo;

public class Dijkstra {

	int[] dist;
	boolean[] sptSet;
	int V;
	
	public Dijkstra(int V) {
		this.V = V;
		this.dist = new int[V];
		this.sptSet = new boolean[V];
	}
	
	
	public static void main(String[] args)
	{
		int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            
           Dijkstra d = new Dijkstra(9);
           d.dijkstra(graph, 0);
           
           d.printSolu();
	}


	private void printSolu() {
		// TODO Auto-generated method stub
		for(int v=0; v<V ;v++)
		{
			System.out.println(v+ " >>min Dist>> "+dist[v]);
		}
	}


	private void dijkstra(int[][] graph, int src) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<V;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src] = 0;
		
		for(int count=0; count < V-1; count++)
		{
			int u = minDist(dist,sptSet);
			
			sptSet[u]=true;
			
			for(int v=0; v<V; v++)
			{
				if(!sptSet[v] && graph[u][v] != 0 && dist[u]!=Integer.MAX_VALUE && (dist[u]+graph[u][v]) < dist[v])
				{
					dist[v] = dist[u]+graph[u][v];
				}
			}
			
		}
	}


	private int minDist(int[] dist, boolean[] sptSet) {
		// TODO Auto-generated method stub
		int min=Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int i=0; i<V; i++)
		{
			if(!sptSet[i] && dist[i]<=min)
			{
				min = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}

}