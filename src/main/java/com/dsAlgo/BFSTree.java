package com.dsAlgo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTree {

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
	    
	    bfs(root);
	}
	private static void bfs(BSTNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			BSTNode temp = queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
			queue.add(temp.left);
			if(temp.right!=null)
			queue.add(temp.right);
		}
		
	}

}
