package dataStructure;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList; 
import java.util.TreeMap; 

public class BT {

	static class Node
	{
		int data;
		Node left,right;
		
		Node(int element)
		{
			data=element;
			left=null;
			right=null;
		}
	}
	
	Node insert(Node root,int value)
	{
		if(root==null)
		{
			return new Node(value);
		}
		else
		{
			Queue<Node> a=new LinkedList<Node>();	
			a.add(root);
			//10
			while(!a.isEmpty())
			{
				Node temp=a.peek();//11 
				a.remove();// 9 
				
				if(temp.left==null)
				{
					temp.left=new Node(value);
					return root;
				}
				else
					a.add(temp.left);//11  7
				
				if(temp.right==null)
				{
					temp.right=new Node(value);
					return root;
				}
				else
					a.add(temp.right);//11 7 12 
			}
		}
		return root;
	}
	
    void deleteDeepest(Node root,Node delNode)
	{
		Queue<Node> l=new LinkedList<>();
		l.add(root);
		
		Node temp=null;
		
		while(!l.isEmpty())
		{
			temp=l.peek();
			l.remove();
			
			if(temp==delNode)
			{
				root=temp.left;
				temp=null;
				return ;
			}
			if(temp.left!=null)
			{
				if(temp.left==delNode)
				{
					temp.left=null;
					return;
				}
				else
					l.add(temp.left);
			}
			if(temp.right!=null)
			{
				if(temp.right==delNode)
				{
					temp.right=null;
					return;
				}
				else
					l.add(temp.right);
			}
		}
	}
	
	
	void delete(Node root,int key)
	{
		if(root==null)
			return ;
		if(root.left==null && root.right==null)
		{
			if(root.data==key)
			{
				root=null;
				return ;
			}
			else
			{
				return ;
			}
		}
		Queue<Node> l=new LinkedList<>();
		l.add(root);
		
		Node keyNode=null , temp=null ; 
		while(!l.isEmpty())
		{
			temp=l.peek();
			l.remove();
			
			if(temp.data==key)
				keyNode=temp;
			if(temp.left!=null)
				l.add(temp.left);
			if(temp.right!=null)
				l.add(temp.right);
		}
		if(keyNode!=null)
		{
			int t=temp.data;
			deleteDeepest(root,temp);
			keyNode.data=t;
		}
	}
	
	
	boolean search(Node root,int value)
	{
		if(root==null)
			return false;
		Queue<Node> l=new LinkedList<>();
		
		l.add(root);
		while(!l.isEmpty())
		{
			Node temp=l.peek();
			l.remove();
			
			if(temp.data==value)
				return true;
			
			if(temp.left!=null)
				l.add(temp.left);
			if(temp.right!=null)
				l.add(temp.right);
		}
		return false;
	}
	
	int min(Node root)
	{
		if(root==null)
			return 0;
		Queue<Node> l=new LinkedList<>();
		
		l.add(root);
		int min=root.data;
		while(!l.isEmpty())
		{
			Node temp=l.peek();
			l.remove();
			
			if(temp.data<min)
				min=temp.data;
			
			if(temp.left!=null)
				l.add(temp.left);
			if(temp.right!=null)
				l.add(temp.right);
		}
		return min;
	}
	
	int max(Node root)
	{
		if(root==null)
			return 0;
		Queue<Node> l=new LinkedList<>();
		
		l.add(root);
		int max=root.data;
		while(!l.isEmpty())
		{
			Node temp=l.peek();
			l.remove();
			
			if(temp.data>max)
				max=temp.data;
			
			if(temp.left!=null)
				l.add(temp.left);
			if(temp.right!=null)
				l.add(temp.right);
		}
		return max;
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
	
	void inorderIterative(Node root)
	{
		if(root==null)
			return ;
		Stack<Node> l=new Stack<>();
		
		Node temp=root;
		while(!l.isEmpty() || temp!=null)
		{
			while(temp!=null)
			{
				l.push(temp.left);
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
	
	void preorderIterative(Node root)
	{
		if(root==null)
			return ;
		Stack<Node> l=new Stack<>();
		l.push(root);
		
		while(!l.isEmpty())
		{
			Node temp=l.pop();
			System.out.print(temp.data+" ");
			
			if(temp.right!=null)
				l.push(temp.right);
			if(temp.left!=null)
				l.push(temp.left);
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
	
	void horizontalLevelOrder(Node root)
	{
		if(root==null)
			return ;
		Queue<Node> l=new LinkedList<>();
		
		l.add(root);
		while(!l.isEmpty())
		{
			Node temp=l.peek();
			l.remove();
			
			System.out.print(temp.data+" ");
			
			if(temp.left!=null)
				l.add(temp.left);
			if(temp.right!=null)
				l.add(temp.right);
		}
	}
	
	static class Qobj
	{
		//Horizontal distance
		int hd;
		Node node;
		
		Qobj(int hd,Node node)
		{
			this.hd=hd;
			this.node=node;
		}
	}
	
	void verticalLevelOrder(Node root)
	{
		if(root==null)
			  return ;
		
		TreeMap<Integer , ArrayList<Integer>> m=new TreeMap<>();
		Queue<Qobj> l=new LinkedList<>();
		
		l.add(new Qobj(0, root));
		while(!l.isEmpty())
		{
			Qobj temp=l.peek();
			l.remove();
			
			int hd=temp.hd;
			Node node=temp.node;
			
			if(m.containsKey(hd))
			{
				m.get(hd).add(node.data);
			}
			else
			{
				ArrayList<Integer> a=new ArrayList<>();
				a.add(node.data);
				m.put(hd, a);
			}
			
			
			if(node.left!=null)
				l.add(new Qobj(hd-1,node.left));
			if(node.right!=null)
				l.add(new Qobj(hd+1,node.right));
		}
		for(Map.Entry<Integer, ArrayList<Integer>> i:m.entrySet())
		{
			for(Integer j:i.getValue())
			{
				System.out.print(j+" ");
			}
		}
	}
	
	void diagonalTraversal(Node root)
	{
		if(root==null)
			return ;
		Queue<Node> l=new LinkedList<>();
		l.add(root);
		
		while(!l.isEmpty())
		{
			int size=l.size();
			while(size>0)
			{
				Node temp=l.peek();
				l.remove();
				
				while(temp!=null)
				{
					System.out.print(temp.data+" ");
					if(temp.left!=null)
						l.add(temp.left);
				    temp=temp.right;
				}
				size--;
			}
			System.out.println();
		}
	}
	
	int height(Node root)
	{
		if(root==null)
			return 0;
		else
		{
			int l=height(root.left);
			int r=height(root.right);
			
			if(l>r)
				return l+1;
			else
				return r+1;
		}
	}
	
	void invert(Node root)
	{
		if(root!=null)
		{
			invert(root.left);
			invert(root.right);
			Node temp=root.right;
			root.right=root.left;
			root.left=temp;
		}
	}
	
	int index(int inorder[],int value,int start,int end)
	{
		for(int i=start;i<=end;i++)
		{
			if(inorder[i]==value)
				return i;
		}
		return start;
	}
	
	int preindex=0;
	
	Node buildTreeInPre(int inorder[],int preorder[],int start,int end)
	{
		if(start>end)
			return null;
		if(start==end)
			return new Node(preorder[preindex++]);
		
		//Finding root
		Node root=new Node(preorder[preindex]);
		preindex++;
		
		//Dividing the inorder to get left subTree subarray and right subTree Subarray by finding index of root in inorder
		int index=index(inorder,root.data,start,end);
		
		//Passing left subarray
		root.left=buildTreeInPre(inorder, preorder, start, index-1);
		
		//passing right subarray
		root.right=buildTreeInPre(inorder, preorder, index+1 , end);
		
		return root;
	}
	
	int postindex=0;
	
	Node buildTreeInPost(int inorder[],int postorder[],int start,int end)
	{
		if(start>end)
			return null;
		if(start==end)
			return new Node(postorder[postindex--]);
		
		//Finding root
		Node root=new Node(postorder[postindex]);
		postindex--;
		
		//Dividing the inorder to get left subTree subarray and right subTree Subarray by finding index of root in inorder
		int index=index(inorder,root.data,start,end);
		
		//passing right subarray
		root.right=buildTreeInPost(inorder, postorder, index+1 , end);
		
		//Passing left subarray
		root.left=buildTreeInPost(inorder, postorder, start, index-1);
		
		return root;
	}
	
	Node buildTreeInLevel(int inorder[],int levelorder[],int start,int end)
	{
		if(start>end)
			 return null;
		if(start==end)
			return new Node(inorder[start]);
		
		Node root=null;int inindex=0;
		
		for(int levelindex=0;levelindex<levelorder.length;levelindex++)
		{
			for(inindex=start;inindex<=end;inindex++)
			{
				if(levelorder[levelindex]==inorder[inindex])
				{
					root=new Node(levelorder[levelindex]);
					break;
				}
			}
			if(root!=null)
				break;
		}
		
		root.left=buildTreeInLevel(inorder, levelorder, start, inindex-1);
		root.right=buildTreeInLevel(inorder, levelorder, inindex+1, end);
		return root;
	}
	
	public static void main(String[] args) {
		
			BT obj=new BT();
			Node root=null;
			int a[]= {1,2,3,4,5,6,7};
			for(int i=0;i<a.length;i++)
				root=obj.insert(root, a[i]);
			System.out.println(obj.search(root, 20)+" "+obj.search(root, 50));
			System.out.println(obj.min(root)+" "+obj.max(root));
			obj.inorder(root);
			System.out.println();
			obj.preorder(root);
			System.out.println();
			obj.postorder(root);
			System.out.println();
			obj.horizontalLevelOrder(root);
			System.out.println();
			System.out.println(obj.height(root));
			obj.diagonalTraversal(root);
	}
}