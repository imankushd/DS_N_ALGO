package com.dsAlgo;

public class Tree {
	
	static TreeNode root;
	
	public static void main(String[] args)
	{
		root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(7);
		
        int key =2;
        
        System.out.println(searchNode(root,key));
	}

	private static boolean searchNode(TreeNode root, int key) {

		if(root==null)
			return false;
		
		if(root.data==key)
			return true;
		else
		{
			return searchNode(root.left, key) || searchNode(root.right, key);
		}
		
	}

}
