package com.dsAlgo.math;

import java.util.*;

public class FactorsOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number = 123456789;
		
		//Compare time differences
		
		//Using Optimized Algorithm
		System.out.println(System.currentTimeMillis());
		System.out.println(findFactors(number));
		System.out.println(System.currentTimeMillis());
		
		//Just running loop from 1 to number
		System.out.println(System.currentTimeMillis());
		System.out.println(findFactors1(number));
		System.out.println(System.currentTimeMillis());
	}

	private static Set<Integer> findFactors(int number) {
		// TODO Auto-generated method stub
		Set<Integer> result = new HashSet<Integer>();
		
		result.add(1);
		result.add(number);
		
		
		for(int i=2;i<=Math.sqrt(number);i++)
		{
			if(number%i==0)
			{
				result.add(i);
				if(i!=Math.sqrt(number))
					result.add(number/i);
			}
		}
		
		return result;
	}
	
	private static Set<Integer> findFactors1(int number) {
		// TODO Auto-generated method stub
		Set<Integer> result = new HashSet<Integer>();
		
		for(int i=1;i<=number;i++)
		{
			if(number%i==0)
			{
				result.add(i);
			}
		}
		
		return result;
	}

}
