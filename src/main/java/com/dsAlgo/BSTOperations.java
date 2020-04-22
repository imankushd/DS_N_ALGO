package com.dsAlgo;

public class BSTOperations {
	
	static TreeNode root;

	public static void main(String[] args) {

		root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(7);
		
        insertNode(root,17);
        
        deleteNode(20);
        
        inorderTraversal(root);
	}

	private static void deleteNode(int key) {

		root = deleteRec(root,key);
	}

	private static TreeNode deleteRec(TreeNode root, int key) {

		if(root == null)
			return root;
		
		if(key<root.data)
			deleteRec(root.left, key);
		else if(key>root.data)
			deleteRec(root.right, key);
		else
		{
			if(root.left == null)
				return root.right;
			
			if(root.right == null)
				return root.left;
			
			root.data = minValue(root.right);
			
			root.right = deleteRec(root.right, root.data);
		}
		
		return root;
	}

	private static int minValue(TreeNode root) {
		// TODO Auto-generated method stub
		int minValue = root.data;
		
		while(root.left!=null)
		{
			minValue = root.left.data;
			root = root.left;
		}
		return minValue;
	}

	private static void inorderTraversal(TreeNode root) {

		if(root!=null)
		{
			inorderTraversal(root.left);
			System.out.print(root.data+" ");
			inorderTraversal(root.right);
		}
	}

	private static TreeNode insertNode(TreeNode root, int key) {
		
		if(root==null)
		{
			 root = new TreeNode(key);
		}
		
		if(key<root.data)
		{
			root.left = insertNode(root.left,key);
		}
		if(key>root.data)
		{
			root.right = insertNode(root.right,key);
		}
		return root;
	}

}
