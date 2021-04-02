package dataStructure;

public class AVL {

	static class Node
	{
		int data;
		int height;
		Node left;
		Node right;
		
		Node(int element)
		{
			data=element;
			height=1;
		}
	}
	
	int getHeight(Node node)
	{
		if(node==null)
			 return 0;
		return node.height;
	}
	
	int max(int a,int b)
	{
		return a > b ? a : b;
	}
	
	//Left rotation
	Node LL(Node parent)
	{
		Node child=parent.left;
		parent.left=child.right;
		child.right=parent;
		
		parent.height = max(getHeight(parent.left),getHeight(parent.right))+1;
		child.height = max(getHeight(child.left) , parent.height)+1;
		
		return child;
	}
	
	
	//Right rotation
	Node RR(Node parent)
	{
		Node child=parent.right;
		parent.right=child.left;
		child.left=parent;
		
		parent.height = max(getHeight(parent.left),getHeight(parent.right))+1;
		child.height = max(getHeight(child.right) , parent.height)+1;
		
		return child;
	}
		
	
	//LR rotation
	Node LR(Node parent)
	{
		parent.left=RR(parent.left);
		return LL(parent);
	}
	
	//RL rotation
	Node RL(Node parent)
	{
		parent.right=LL(parent.right);
		return RR(parent);
	}
		
	int getBalance(Node root)
	{
		if(root==null)
			 return 0;
		return getHeight(root.left) - getHeight(root.right);
	}
	
	Node insert(Node root,int value)
	{
		if(root==null)
			return new Node(value);
		else if(value<root.data)
		{
			root.left= insert(root.left,value);
		}
		else if(value>root.data)
		{
			root.right=insert(root.right,value);
		}
		else
			 return root;
		
		
		root.height = max(getHeight(root.left) , getHeight(root.right)) + 1;
		
		int balance = getBalance(root);
		
		
		if(balance > 1 && value<root.left.data)
			return LL(root);
		else if(balance < -1 && value > root.right.data)
			return RR(root);
		else if(balance > 1 && value > root.left.data)
			return LR(root);
		else if(balance < -1 && value < root.right.data)
			return RL(root);
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
	
	Node deleteNode(Node root,int value)
	{
		if(root==null)
			return root;
		if(value<root.data)
			root.left=deleteNode(root.left,value);
		else if(value>root.data)
			root.right=deleteNode(root.right,value);
		else
		{
			if(root.left==null || root.right==null)
			{
				Node temp=null;
				if(temp==root.left)
					temp=root.right;
				else
					temp=root.left;
				
				if(temp==null)
				{
					root=null;
				}
				else
				{
					root=temp;
				}
			}
			else
			{
				Node temp =min(root.right);
				root.data=temp.data;
				root.right = deleteNode(root.right , temp.data);
			}
		}
		
		if(root==null)
			return root;
		
		root.height = max(getHeight(root.left), getHeight(root.right))+1;
		
		int balance = getBalance(root);
		
		if(balance>1 && getBalance(root.left)>=0)
			return LL(root);
		
		else if(balance < -1 && getBalance(root.right)<=0)
			return RR(root);
		
		else if(balance > 1 && getBalance(root.left)<0)
			return LR(root);
		
		else if(balance < -1 && getBalance(root.right)>0)
			return RL(root);
		
		return root;
	}
	
	void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.println(root.data+" ");
			inorder(root.right);
		}
	}
	
	void preorder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.data+" ");
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
			System.out.println(root.data+" ");
		}
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
	
	public static void main(String[] args) {
		
	}
}