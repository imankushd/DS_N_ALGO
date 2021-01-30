package com.dsAlgo.string;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "aeeabcdefedcdef";
        
        System.out.println(longestPalindrome(s));
	}
	
	private static int longestPalindrome(String s)
	{
		int maxLength=1;
		
		int start=0;
		
		int low,high;
		
		for(int i=1;i<s.length();i++)
		{
			//for even palindromes
			low=i-1;
			high=i;
			while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
			{
				if(high-low+1>maxLength)
				{
					start=low;
					maxLength = high - low +1;
				}
				low--;
				high++;
			}
			
			//for odd palindromes
			low=i-1;
			high=i+1;
			while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
			{
				if(high-low+1>maxLength)
				{
					start=low;
					maxLength = high - low +1;
				}
				low--;
				high++;
			}
		}
		
		System.out.println(s.substring(start,start+maxLength));
		
		return maxLength;
	}

}
