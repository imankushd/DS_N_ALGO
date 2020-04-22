package com.dsAlgo;

class TrieNode
{
	public static final int ALPHA_SIZE=26;
	
	TrieNode[] children;
	
	boolean isEndOfWord;
	
	public TrieNode() {
		children = new TrieNode[ALPHA_SIZE];
		
		isEndOfWord = false;
		
		for(int i=0;i<ALPHA_SIZE;i++)
			children[i]=null;
	}
	
}

//Java implementation of search and insert operations 
//on Trie 
public class Trie { 
	
	static TrieNode root;
	// Driver 
	public static void main(String args[]) 
	{
		root = new TrieNode(); 
		
		insert("ankush");
		insert("disha");
		insert("dish");
		insert("ankur");
		
		if(search("ankur"))
			System.out.println("Ankur is present in trie.");
		else
			System.out.println("Not Present");
		if(search("disha"))
			System.out.println("Disha is present in trie.");
		else
			System.out.println("Not Present");
		if(search("ankush"))
			System.out.println("Ankush is present in trie.");
		else
			System.out.println("Not Present");
		
		remove(root,"disha",0);
		
		if(search("disha"))
			System.out.println("Disha is present in trie.");
		else
			System.out.println("Not Present");
		if(search("dish"))
			System.out.println("Dish is present in trie.");
		else
			System.out.println("Not Present");
	}
	
	private static TrieNode remove(TrieNode root, String key, int depth) {
		// TODO Auto-generated method stub
		if(root==null)
			return null;
		
		if(depth == key.length())
		{
			if(root.isEndOfWord)
				root.isEndOfWord = false;
			
			if(isEmpty(root))
			{
				root = null;
			}
			
			return root;
		}
		
		int index = key.charAt(depth) - 'a';
		
		root.children[index] = remove(root.children[index], key, depth+1);
		
		if(isEmpty(root) && root.isEndOfWord==false)
		{
			root = null;
		}
		
		return root;
	}

	private static boolean isEmpty(TrieNode root) {
		// TODO Auto-generated method stub
		
		for(int i= 0; i<root.ALPHA_SIZE; i++)
		{
			if(root.children[i]!=null)
				return false;
		}
		
		return true;
	}

	private static boolean search(String key) {
		// TODO Auto-generated method stub
		
		TrieNode current = root;
		
		for(int l=0; l<key.length(); l++)
		{
			int index = key.charAt(l) - 'a';
			
			if(current.children[index] == null)
				return false;
			
			current = current.children[index];
		}
		
		return (current!=null && current.isEndOfWord==true);
	}

	private static void insert(String key) {
		// TODO Auto-generated method stub
		TrieNode current = root;
		
		for(int level=0 ; level<key.length();level++)
		{
			int index = key.charAt(level) - 'a';
			
			if(current.children[index]==null)
				current.children[index] = new TrieNode();
			
			current = current.children[index];
		}

		current.isEndOfWord = true;
	} 
}