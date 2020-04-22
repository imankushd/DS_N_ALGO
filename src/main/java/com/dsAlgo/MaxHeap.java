package com.dsAlgo;

public class MaxHeap {
	
	private int[] Heap;
	private int maxsize;
	private int size;
	private final int FRONT = 1;
	
	MaxHeap(int maxsize)
	{
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[maxsize];
		Heap[0]=Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeap maxHeap = new MaxHeap(20);
		maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9);
		
		System.out.println("After INSERTING:");
		maxHeap.print();
		
		System.out.println("Extracted max value: "+maxHeap.extractMax());
        
		System.out.println("After REMOVING:");
		maxHeap.print();
	}

	private int extractMax() {
		// TODO Auto-generated method stub
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size];
		Heap[size] = -1;
		size--;
		maxHeapify(FRONT);
		
		return popped;
	}

	private void maxHeap() {
		// TODO Auto-generated method stub
		for(int pos=size/2; pos>=1; pos--)
			maxHeapify(pos);
	}

	private void maxHeapify(int pos) {

		if(!isLeaf(pos))
		{
			if((Heap[leftChild(pos)] > Heap[pos]) || (Heap[rightChild(pos)] > Heap[pos]) )
			{
				if(Heap[leftChild(pos)] > Heap[rightChild(pos)])
				{
					swap(leftChild(pos),pos);
					maxHeapify(leftChild(pos));
				}
				else
				{
					swap(rightChild(pos),pos);
					maxHeapify(rightChild(pos));
				}
			}
		}
	}

	private void insert(int element) {
		// TODO Auto-generated method stub
		Heap[++size] = element;
		int current = size;
		
		while(Heap[current] > Heap[parent(current)])
		{
			swap(current,parent(current));
			current = parent(current);
		}
	}
	
	private int parent(int pos) {
		// TODO Auto-generated method stub
		return pos/2;
	}

	private void print() {
		// TODO Auto-generated method stub
		for(int pos = 1; pos<=size/2; pos++)
		{
			System.out.println("PARENT: "+Heap[pos]+" >> LeftChild: "+Heap[2*pos]+" >> RightChild: "+Heap[2*pos+1]);
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

	private void swap(int fpos, int spos) {
		// TODO Auto-generated method stub
		int tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

}
