package com.dsAlgo;

public class LvlOrderTraversal {

	static TreeNode root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           root = new TreeNode(20);
           root.left = new TreeNode(10);
           root.right = new TreeNode(30);
           root.left.left = new TreeNode(5);
           root.left.right = new TreeNode(15);
           root.right.left = new TreeNode(25);
           root.right.right = new TreeNode(35);
           
           printLevelOrder(root);
	}

	//Zig-Zag order Traversal
	private static void printLevelOrder(TreeNode root) {
		// TODO Auto-generated method stub
		int h = getHeight(root);
		
		for(int i=1;i<=h;i++)
		{
			if(i%2==0)
				printLevelOrderUtil(root,i,true);
			else
				printLevelOrderUtil(root,i,false);
				
		}
	}

	private static void printLevelOrderUtil(TreeNode root, int level, boolean flag) {
		// TODO Auto-generated method stub
		if(level == 1)
			System.out.print(root.data+" ");
		else
		{
			if(flag)
			{
				printLevelOrderUtil(root.right,level-1,flag);
				printLevelOrderUtil(root.left,level-1,flag);
			}
			else
			{
				printLevelOrderUtil(root.left,level-1,flag);
				printLevelOrderUtil(root.right,level-1,flag);
			}
		}
	}

	private static int getHeight(TreeNode root) {
		// TODO Auto-generated method stub
		
		if(root == null)
			return 0;
		else
		{
			int lh = getHeight(root.left);
			int rh = getHeight(root.right);
			
			if(lh > rh)
				return lh+1;
			else
				return rh+1;
		}
	}

}
