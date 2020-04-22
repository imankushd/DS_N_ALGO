package com.dsAlgo;

class Node
{
	int key,height;
	Node left,right;
	
	Node(int key)
	{
		this.key = key;
	}
}

public class AVLTree {
	
	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AVLTree tree = new AVLTree();
		tree.root = insert(tree.root,10);
		tree.root = insert(tree.root, 20); 
        tree.root = insert(tree.root, 30); 
        tree.root = insert(tree.root, 40); 
        tree.root = insert(tree.root, 50); 
        tree.root = insert(tree.root, 25); 
  
        preOrder(tree.root);
        
        tree.root = deleteNodeFomAVL(tree.root, 25);
        
        System.out.println();
        
        preOrder(tree.root);
        
	}

	private static Node deleteNodeFomAVL(Node root, int key) {

		if(root == null)
			return null;
		
		if(key < root.key)
			root.left = deleteNodeFomAVL(root.left, key);
		else if(key > root.key)
			root.right = deleteNodeFomAVL(root.right, key);
		else
		{
			if(root.left == null)
				root = root.right;
			else if(root.right == null)
				root = root.left;
			else
			{
			root.key = minValue(root.right);
			
			root.right = deleteNodeFomAVL(root.right, root.key);
			}
		}
		
		if(root == null)
			return root;
		
		root.height = height(root);
		
		int balance = getBalance(root);
		
		if(balance > 1)
		{
			if(getBalance(root.left) >= 0)
				return rightRotate(root);
			else
			{
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		}
		if(balance < -1)
		{
			if(getBalance(root.right) <= 0)
				return leftRotate(root);
			else
			{
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}
			
		return root;
	}

	private static int minValue(Node root) {

		int minV = root.key;
		
		while(root.left!=null)
		{
			minV = root.left.key;
			root= root.left;
		}
		
		return minV;
	}

	private static void preOrder(Node root) {

		if(root!=null)
		{
			System.out.print(root.key+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private static Node insert(Node root, int key) {

		if(root == null)
			return new Node(key);
		
		if(key < root.key)
			root.left = insert(root.left, key);
		else if(key > root.key)
			root.right = insert(root.right, key);
		else
			return root; //if duplicate key appears
		
		int balance = getBalance(root);
		
		if(balance>1)
		{
			if(height(root.left.left)>height(root.left.right))
				return rightRotate(root);
			else
			{
				root.left=leftRotate(root.left);
				return rightRotate(root);
			}
		}
		if(balance < -1)
		{
			if(height(root.right.right)>height(root.right.left))
				return leftRotate(root);
			else
			{
				root.right=rightRotate(root.right);
				return leftRotate(root);
			}
		}
		root.height = height(root);
		
		return root;
	}

	private static Node rightRotate(Node root) {

		Node temp = root.left;
		Node c = temp.right;
		
		temp.right = root;
		root.left = c;
		
		temp.height = height(temp);
		root.height = height(root);
		
		return temp;
	}
	
	private static Node leftRotate(Node root) {

		Node temp = root.right;
		Node c = temp.left;
		
		temp.left = root;
		root.right = c;
		
		temp.height = height(temp);
		root.height = height(root);
		
		return temp;
	}

	private static int getBalance(Node root) {

		if(root == null)
			return 0;
		return height(root.left) - height(root.right);
	}

	private static int height(Node root) {

		if(root == null)
			return 0;
		else
		{
			int ah = height(root.left);
			int rh = height(root.right);
			
			if(ah>rh)
				return ah+1;
			else
				return rh+1;
		}
	}

}
