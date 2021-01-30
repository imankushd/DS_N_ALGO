package com.dsAlgo.string;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String s = "BABCDEFG";
         String ss = "BAEGFTSG";
         
         System.out.println(lcs(s,ss));
	}

	private static int lcs(String s, String ss) {
		// TODO Auto-generated method stub
		
		int[][] lcs = new int[s.length()+1][ss.length()+1];
		
		char[]  X = s.toCharArray();
		char[] Y = ss.toCharArray();
		
		for(int i=0;i<=s.length();i++)
		{
			for(int j=0;j<=ss.length();j++)
			{
				if(i==0 || j==0)
					lcs[i][j]=0;
				else if(X[i-1]==Y[j-1])
				{
					lcs[i][j] = 1+lcs[i-1][j-1];
				}
				else
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		
		return lcs[s.length()][ss.length()];
	}

}
