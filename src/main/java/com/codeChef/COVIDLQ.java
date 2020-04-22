package com.codeChef;

import java.util.Scanner;

class COVIDLQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

			int t = sc.nextInt();
			
			for(int i=0;i<t;i++)
			{
			    int n = sc.nextInt();
			    
			    int[] a = new int[n];
			    
			    for(int j=0;j<n;j++)
			    a[j]=sc.nextInt();
			    
			    boolean flag = false;
			    int c=1;
			    
			    for(int j=0;j<n;j++)
			    {
			        if(a[j]==1 && c==1)
			        {
			        	flag=true;
			        	if(n==1)
			        	{
			        		System.out.println("YES");
			        		break;
			        	}
			        	continue;
			        }
			        
			        
			        if(flag)
			        {
			            if(a[j]==1 && c>1 && c<6)
			            {
			               System.out.println("NO");
			               break;
			            }
			            
			            if(j==n-1 && a[j]!=1)
			            {
			                System.out.println("YES");
			                break;
			            }
			            
			            if(j==n-1 && a[j]==1 && c==6)
			            {
			                System.out.println("YES");
			                break;
			            }
			            
			            if(a[j]==1 && c==6)
			            {
			                c=1;
			            }
			            c++;
			        }
			    }
			}
			
			
		
		
		sc.close();
	}
}
