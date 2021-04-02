package dataStructure;

import dataStructure.BST.Node;
import java.lang.*;

public class SBBST {

	static class Node
	{
		int data;
		int height;
		Node left,right;
		
		Node(int element)
		{
			data=element;
			height=0;
			left=null;
			right=null;
		}
	}
	
	int height(Node temp)
	{
		return temp == null ? -1 : temp.height;
	}
	
	int max(int a,int b)
	{
		return a > b ? a : b ;
	}
	
	Node LL(Node parent)
	{
		Node child=parent.left;
		parent.left=child.right;
		child.right=parent;
		parent.height = max ( height(parent.left) , height(parent.right) ) + 1;
		child.height = max ( height(child.left) , parent.height ) + 1;
		return child;
	}
	
	Node RR(Node parent)
	{
		Node child=parent.right;
		parent.right=child.left;
		child.left=parent;
		parent.height = max ( height(parent.left) , height(parent.right) ) + 1;
		child.height = max ( parent.height , height(child.right)) + 1;
		return child;
	}
	
	Node LR(Node parent)
	{
		parent.left=RR(parent.left);
		return LL(parent);
	}
	
	Node RL(Node parent)
	{
		parent.right=LL(parent.right);
		return RR(parent);
	}
	
	
    Node insert(Node root,int value)
    {
    	if(root==null)
    		root=new Node(value);
    	else if(value<root.data)
    	{
    		root.left=insert(root.left,value);
    		if(height(root.left) - height(root.right) == 2)
    		{
    			if(value < root.left.data)
    				root=LL(root);
    			else
    				root=LR(root);
    		}
    	}
    	else if(value>root.data)
    	{
    		root.right=insert(root.right,value);
    		if(height(root.right) - height(root.left) == 2)
    		{
    			if(value > root.right.data)
    				root=RR(root);
    			else
    				root=RL(root);
    		}
    	}
    	root.height = max( height(root.left) , height(root.right) )+1;
    	return root;
    }
	
    
    
    
    int search(Node root,int value)
    {
    	while(root!=null)
    	{
    		if(value<root.data)
    			root=root.left;
    		else if(value>root.data)
    			root=root.right;
    		else
    			return 1;
    	}
    	return -1;
    }
    
    Node min(Node root)
    {
    	while(root.left!=null)
    		root=root.left;
    	return root;
    }
    
    Node maxi(Node root)
    {
    	while(root.right!=null)
    		root=root.right;
    	return root;
    }
    
    void levelorder(Node root,int level)
    {
    	if(root==null)
    		return ;
    	else if(level==1)
    		System.out.print(root.data+" ");
    	else if(level > 1)
    	{
    		levelorder(root.left,level-1);
    		levelorder(root.right,level-1);
    	}
    }
    
    void inorder(Node root)
    {
    	if(root!=null)
    	{
    		inorder(root.left);
    		System.out.print(root.data+" ");
    		inorder(root.right);
    	}
    }
    
    void preorder(Node root)
    {
    	if(root!=null)
    	{
    		System.out.print(root.data+" ");
    		preorder(root.left);
    		preorder(root.right);
    	}
    }
    
    void postorder(Node root)
    {
    	if(root!=null)
    	{
    		postorder(root.left);
    		postorder(root.right);
    		System.out.print(root.data+" ");
    	}
    }
    
    Node delete(Node root,int key)
	{
		if(key<root.data)
		{
			root.left=delete(root.left,key);
			if(height(root.right) - height(root.left) == 2)
    		{
    			if(root.right!=null && root.right.right!=null)
    				root=RR(root);
    			else
    				root=RL(root);
    		}
		}
		else if(key>root.data)
		{
			root.right=delete(root.right,key);
			if(height(root.left) - height(root.right) == 2)
    		{
    			if(root.left!=null && root.left.left!=null)
    				root=LL(root);
    			else
    				root=LR(root);
    		}
		}
		else
		{
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			
	       Node temp=min(root.right);
	       root.data=temp.data;
	       
	       root.right=delete(root.right,temp.data);
	       if(height(root.left) - height(root.right) == 2)
	   		{
	   			if(root.left!=null && root.left.left!=null)
	   				root=LL(root);
	   			else
	   				root=LR(root);
	   		}
		}
		root.height=max(height(root.left),height(root.right))+1;
		return root;
	}
    
    
	public static void main(String[] args) {
		SBBST obj=new SBBST();
		Node root=null;
		root=obj.insert(root, 4);
		root=obj.insert(root, 2);
		root=obj.insert(root, 6);
		root=obj.insert(root, 1);
		root=obj.insert(root, 3);
		root=obj.insert(root, 5);
		root=obj.insert(root, 7);
		for(int i=1;i<=3;i++)
		{
			obj.levelorder(root, i);
			System.out.println();
		}
		root=obj.delete(root, 4);
		root=obj.delete(root, 1);
		root=obj.delete(root, 3);
		root=obj.delete(root, 6);
		for(int i=1;i<=3;i++)
		{
			obj.levelorder(root, i);
			System.out.println();
		}
	}
}
