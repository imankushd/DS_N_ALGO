package com.dsAlgo.math;

import java.util.ArrayList;

//Sieve Of Eratosthenes Algorithm
//Complexity- O(nloglogn)
public class SieveAlgo_AllPrimesUptoN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number =36;
		
		int[] primes = new int[number+1];
		
		for(int i=0;i<=number;i++)
			primes[i]=1;
			
		primes[0]=primes[1]=0;
		
		for(int i=2;i<=Math.sqrt(number);i++)
		{
			if(primes[i]==1)
			{
				for(int j=2;i*j<=number;j++)
					primes[i*j]=0;
			}
		}
		
		for(int i=0;i<=number;i++)
		{
			if(primes[i]==1)
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}

}
