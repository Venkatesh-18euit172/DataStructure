package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

	static class Node
	{
		int data;
		Node left,right;
		
		Node(int element)
		{
			this.data=element;
			this.left=null;
			this.right=null;
		}
	}
	
	Node insert(Node root,Node newnode)
	{
		if(root==null)
			return newnode;
		if(newnode.data<root.data)
		{
			if(root.left==null)
			{
				root.left=newnode;
			}
			else
			{
				insert(root.left,newnode);
			}
		}
		else if(newnode.data>root.data)
		{
			if(root.right==null)
			{
				root.right=newnode;
			}
			else
			{
				insert(root.right,newnode);
			}
		}
		return root;
	}
	
	Node buildTreefromIn(int a[],int start,int end)
	{
		if(start>end)
			return null;
		
		int mid=(start + end )/2;
		Node root=new Node(a[mid]);
		
		root.left=buildTreefromIn(a, start, mid-1);
		root.right=buildTreefromIn(a, mid-1 , end);
		return root;
	}
	
    Node buildTreefromPre(int a[])
    {
        Stack<Node> l=new Stack<>();
        
        Node root=new Node(a[0]);
        l.add(root);
        
        for(int i=1;i<a.length;i++)
        {
            Node temp=null;
            
            //Adding element to right logic start
            while(!l.isEmpty() && a[i]>l.peek().data)
            {
                temp=l.peek();
                l.pop();
            }
            if(temp!=null)
            {
                temp.right=new Node(a[i]);
                l.push(temp.right);
            }
            //right logic end and left logic start
            else
            {
                temp=l.peek();
                temp.left=new Node(a[i]);
                l.push(temp.left);
            }
        }
        return root;
    }
	
	Node min(Node root)
	{
		while(root.left!=null)
			root=root.left;
		return root;
	}
	
	Node max(Node root)
	{
		while(root.right!=null)
			root=root.right;
		return root;
	}
	
	Node delete(Node root,int key)
	{
		if(key<root.data)
			root.left=delete(root.left,key);
		else if(key>root.data)
			root.right=delete(root.right,key);
		else
		{
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			
	       Node temp=min(root.right);
	       root.data=temp.data;
	       
	       root.right=delete(root.right,temp.data);
		}
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
	
	void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	void inorderNR(Node root)
	{
		if(root==null)
			return ;
		Stack<Node> l=new Stack<Node>();
		
		Node temp=root;
		
		while(temp!=null || l.size()>0)
		{
			while(temp!=null)
			{
				l.add(temp);
				temp=temp.left;
			}
			
			temp=l.pop();
			System.out.print(temp.data+" ");
			temp=temp.right;
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
	
	void levelorder(Node root,int level)
	{
		if(root==null)
			 return ;
		if(level==1)
			System.out.print(root.data+" ");
		else if(level>1)
		{
			levelorder(root.left,level-1);
			levelorder(root.right,level-1);
		}
	}
	
//   10
// 5     15
//1   6   12   20


	void levelorder_Queue(Node root)
	{
		if(root==null)
			 return ;
		Queue<Node> a=new LinkedList<Node>();
		
		a.add(root);//10 
		while(!a.isEmpty())
		{
			Node temp=a.peek();//15
			a.remove();//  
			System.out.print(temp.data+" ");
			
			if(temp.left!=null)
				a.add(temp.left);//1 6 12  
			
			if(temp.right!=null)
				a.add(temp.right);//
		}
	}
	
	int iterativeHeight(Node root)
	{
	   if(root==null)
		   return 0;
	   else
	   {
		   Queue<Node> a=new LinkedList();
		   a.add(root);
		   
		   int height=0;
		   
		   while(true)
		   {
			   int nodeCount=a.size();
			   if(nodeCount==0)
				   return height;
			   height++;
			   
			   while(nodeCount>0)
			   {
				   Node temp=a.peek();
				   a.remove();
				   if(temp.left!=null)
					    a.add(temp.left);
				   if(temp.right!=null)
					    a.add(temp.right);
				   nodeCount--;
			   }
		   }
	   }
	}                                          
		
//r(10)	
//r(5) -- l=1 r=2
//r(6) -- l=0 r=1 
//r(7) -- l=0 r=0 
//r(null)	
	
	int recursiveHeight(Node root)
	{
		if(root==null)
			return 0;
		else
		{
			int leftHeight=recursiveHeight(root.left);//0
			int rightHeight=recursiveHeight(root.right);//0
			
			if(leftHeight>rightHeight)
				return leftHeight+1;
			else
				return rightHeight+1;
		}
	}
	
	public static void main(String[] args) {
		BST obj=new BST();
	    Node root=obj.insert(null,new Node(100));
	    root=obj.insert(root,new Node(40));
	    root=obj.insert(root,new Node(50));
	    root=obj.insert(root,new Node(10));
	    root=obj.insert(root,new Node(15));
	    root=obj.insert(root,new Node(30));
	    root=obj.insert(root,new Node(20));
	    obj.postorder(root);
	    obj.delete(root, 25);
	    /*for(int i=1;i<=3;i++)
	    {
	    	obj.levelorder(root, i);
	        System.out.println();
	    }
	    obj.levelorder_Queue(root);
	    System.out.println();
        obj.inorder(root);
        System.out.println();
        obj.preorder(root);
        System.out.println();
        obj.postorder(root);
        System.out.println();
        System.out.println(obj.search(root, 15)+" "+obj.search(root, 25));
        System.out.println("Max = "+obj.max(root).data+" Min = "+obj.min(root).data);
        System.out.println("Height of tree "+obj.iterativeHeight(root)+" "+obj.recursiveHeight(root));*/
	}
}
