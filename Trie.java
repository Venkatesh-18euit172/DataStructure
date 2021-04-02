package dataStructure;


import java.util.*;

class Trie {
    
    static class Node
    {
        Node child[]=new Node[26];
        boolean endWord;
    }
    
    Node insert(Node root,String key)
    {
        Node temp;
        if(root==null)
            root=new Node();
        temp=root;
        for(int i=0;i<key.length();i++)
        {
            int pos=key.charAt(i)-'a';
            if(temp.child[pos]==null)
                temp.child[pos]=new Node();
            temp=temp.child[pos];
        }
        temp.endWord=true;
        return root;
    }
    
    boolean search(Node root,String key)
    {
        for(int i=0;i<key.length();i++)
        {
            int pos=key.charAt(i)-'a';
            if(root.child[pos]==null)
                return false;
            root=root.child[pos];
        }
        return (root!=null && root.endWord);
    }
    
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		Trie obj=new Trie();
		int n=in.nextInt();
		Node root=null;
		while(n-->0)
		{
		    root=obj.insert(root,in.next().toLowerCase());
		}
		if(obj.search(root,in.next().toLowerCase()))
		    System.out.println(1);
		else
		    System.out.println(0);
		in.close();
	}
}