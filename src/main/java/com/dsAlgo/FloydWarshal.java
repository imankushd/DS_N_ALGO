package com.dsAlgo;

//All pair shortest path Algo.
public class FloydWarshal {
	
	static final int INF=999999, V=4;	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int graph[][] = { {0,   5,  INF, 10}, 
                {INF, 0,   3, INF}, 
                {INF, INF, 0,   1}, 
                {INF, INF, INF, 0} 
              };
		
		FloydWarshal f = new FloydWarshal();
		f.floydWarshal(graph);
	}

	public void floydWarshal(int[][] graph) {
		// TODO Auto-generated method stub
		int[][] dist = new int[V][V];
		
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
				dist[i][j] = graph[i][j];
			}
		}
		
		for(int k=0;k<V;k++)
		{
			for(int i=0;i<V;i++)
			{
				for(int j=0;j<V;j++)
				{
					if(dist[i][j] > dist[i][k]+dist[k][j])
						dist[i][j] = dist[i][k]+dist[k][j];
				}
			}
		}
		printSolution(dist);
	}

	private void printSolution(int[][] dist) {
		// TODO Auto-generated method stub
	
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
				if(dist[i][j]==INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}

}
