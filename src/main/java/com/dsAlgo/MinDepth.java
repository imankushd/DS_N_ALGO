package com.dsAlgo;

public class MinDepth {

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
        
        System.out.println(getMinDepth(root));
	}

	private static int getMinDepth(TreeNode root) {

		if(root == null)
			return 0;
		
		if(root.left == null)
			return getMinDepth(root.right);
		
		if(root.right == null)
			return getMinDepth(root.left);
		
		return Math.min(getMinDepth(root.left), getMinDepth(root.right))+1;
	}

}
