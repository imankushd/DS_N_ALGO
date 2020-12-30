package com.dsAlgo.sort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] arr = {4,3,2,3,5};
         
         System.out.println("Array before sorting: ");
         for(int i=0;i<arr.length;i++)
        	 System.out.print(arr[i]+" ");
         System.out.println();
         
         quickSort(arr, 0, arr.length-1);
         
         System.out.println("Array after sorting: ");
         for(int i=0;i<arr.length;i++)
        	 System.out.print(arr[i]+" ");
         System.out.println();
         
	}

	private static void quickSort(int[] arr, int l, int h) {
		if(l<h)
		{
			int p = partition(arr,l,h);
			quickSort(arr, l, p-1);
			quickSort(arr, p+1, h);
		}
	}

	private static int partition(int[] arr, int l, int h) {
		// TODO Auto-generated method stub
		int pivot = arr[h];
		int i = l-1;
		
		for(int j=l;j<h;j++)
		{
			if(arr[j]<pivot)
			{
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;
		
		return i+1;
	}

}
