package com.dsAlgo.graph;

class BSTNode
{
	int data;
	BSTNode left;
	BSTNode right;
	
	BSTNode(int data)
	{
		this.data=data;
	}
}

public class DFSTree {

	static BSTNode root=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    root = new BSTNode(1);
    root.left = new BSTNode(2);
    root.right = new BSTNode(3);
    root.left.left = new BSTNode(4);
    root.left.right = new BSTNode(5);
    root.right.left = new BSTNode(6);
    root.right.right = new BSTNode(7);
    
    dfs(root);
	}

	private static void dfs(BSTNode root) {

		if(root==null)
			return;
		
		System.out.print(root.data+" ");
		dfs(root.left);
		dfs(root.right);
	}

}
