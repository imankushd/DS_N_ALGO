package com.dsAlgo;

public class MinHeap {

	int[] Heap;
	private int maxsize ;
	private int size;
	private final int FRONT = 1;
	
	MinHeap(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[maxsize];
		Heap[0]=-1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinHeap minHeap = new MinHeap(20);
		minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9);
        
        //Print Normally
        minHeap.print();
        
        //MinHeap method
        minHeap.minHeap();
        
        System.out.println("Extracted min value: "+minHeap.extractMin());
        
        System.out.println("After Removing");
        minHeap.print();
        
	}


	private int extractMin() {
		// TODO Auto-generated method stub
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size];
		Heap[size]=-1;
		size--;
		minHeapify(FRONT);
		
		return popped;
		
	}


	private void print() {
		// TODO Auto-generated method stub
		for(int pos = 1; pos<=size/2; pos++)
		{
			System.out.println("PARENT: "+Heap[pos]+" >> LeftChild: "+Heap[2*pos]+" >> RightChild: "+Heap[2*pos+1]);
		}
	}


	private void minHeap() {
		// TODO Auto-generated method stub
		
		for(int pos=size/2 ; pos>=1 ;pos--)
			minHeapify(pos);
		
	}


	private void minHeapify(int pos) {
		// TODO Auto-generated method stub
		if(!isLeaf(pos))
		{
			if((Heap[leftChild(pos)] < Heap[pos]) || (Heap[rightChild(pos)] < Heap[pos]) )
					{
				      if(Heap[leftChild(pos)] < Heap[rightChild(pos)])
				      {
				    	  swap(leftChild(pos), pos);
				    	  minHeapify(leftChild(pos));
				      }
				      else
				      {
				    	  swap(rightChild(pos), pos);
				    	  minHeapify(rightChild(pos));
				      }
					}
		}
	}


	private int rightChild(int pos) {
		// TODO Auto-generated method stub
		return 2*pos+1;
	}


	private int leftChild(int pos) {
		// TODO Auto-generated method stub
		return 2*pos;
	}


	private boolean isLeaf(int pos) {
		// TODO Auto-generated method stub
		if(pos>=size/2 && pos <= size)
			return true;
		return false;
	}


	private void insert(int element) {
		// TODO Auto-generated method stub
		if(size>=maxsize)
			return;
		Heap[++size] = element;
		int current = size;
		
		while(Heap[current] < Heap[parent(current)])
		{
			swap(current,parent(current));
			current = parent(current);
		}
	}


	private void swap(int fpos, int spos) {
		// TODO Auto-generated method stub
		int tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}


	private int parent(int pos) {
		// TODO Auto-generated method stub
		return pos/2;
	}

}
