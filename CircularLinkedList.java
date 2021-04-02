package dataStructure;

public class CircularLinkedList {

	static class Node
	{
		int data;
		Node next;
	}
	
	Node last,temp,newnode;
	
	void create(CircularLinkedList list,int element)
	{
		newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		if(list.last==null)
		{
			list.last=newnode;
			newnode.next=list.last;
		}
		else
		{
			newnode.next=list.last.next;
			list.last.next=newnode;
			list.last=newnode;
		}
	}
	
	void insert_begin(CircularLinkedList list,int element)
	{
		newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		if(list.last==null)
		{
			list.last=newnode;
			newnode.next=list.last;
		}
		else
		{
			newnode.next=list.last.next;
			list.last.next=newnode;
		}
	}
	
	void insert_end(CircularLinkedList list,int element)
	{
		newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		if(list.last==null)
		{
			list.last=newnode;
			newnode.next=list.last;
		}
		else
		{
			newnode.next=list.last.next;
			list.last.next=newnode;
			list.last=newnode;
		}
	}
	
	void insert_middle(CircularLinkedList list,int element)
	{
		newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		if(list.last==null)
		{
			list.last=newnode;
			newnode.next=list.last;
		}
		else
		{
			temp=list.last.next;
	        int length=0;
	        do
	        {
	            length++;
	           temp=temp.next;
	        } 
	        while(temp!=list.last.next);
	        int middle=length/2;
	        int a=0;
	        temp=list.last.next;
	        Node prev=null;
	        while(a!=middle)
	        {
	            prev=temp;
	            temp=temp.next;
	            a++;
	        }
	        prev.next=newnode;
	        newnode.next=temp;
		}
	}
	
	void delete_begin(CircularLinkedList list)
	{
		if(list.last==null)
		{
			System.out.println("Linked list not exist");
		}
		else
		{
			temp=list.last.next;
			list.last.next=temp.next;
			temp.next=null;
		}
	}
	
	void delete_end(CircularLinkedList list)
	{
		if(list.last==null)
		{
			System.out.println("Linked list not exist");
		}
		else
		{
			temp=list.last.next;
			while(temp.next!=last)
			{
				temp=temp.next;
			}
			temp.next=list.last.next;
			list.last.next=null;
			last=temp;
		}		
	}
	
	void delete_middle(CircularLinkedList list)
	{
		if(list.last==null)
		{
			System.out.println("Linked list not exist");
		}
		else
		{
			temp=list.last.next;
	        int length=0;
	        do
	        {
	            length++;
	           temp=temp.next;
	        } 
	        while(temp!=list.last.next);
	        int middle=length/2;
	        int a=0;
	        temp=list.last.next;
	        Node prev=null;
	        while(a!=middle)
	        {
	            prev=temp;
	            temp=temp.next;
	            a++;
	        }
	        prev.next=temp.next;
	        temp.next=null;
		}
	}
	
	void reverse(CircularLinkedList list)
	{
		Node prev=list.last,next=null,curr=list.last.next,temp=list.last;
		do
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		while(prev!=list.last);
		list.last=curr;
	}
	
	void display(CircularLinkedList list)
	{
		if(list.last==null)
		{
			System.out.println("Not exist");
		}
		else
		{
			temp=last.next;
			do
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			while(temp!=last.next);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		CircularLinkedList obj=new CircularLinkedList();
		obj.create(obj, 10);
		obj.create(obj, 20);
		obj.create(obj, 30);
		obj.create(obj, 40);
		obj.insert_begin(obj, 0);
		obj.insert_end(obj, 50);
		obj.insert_middle(obj, 25);
		obj.delete_begin(obj);
		obj.delete_end(obj);
		obj.delete_middle(obj);
		obj.display(obj);
		obj.reverse(obj);
		obj.display(obj);
	}
}
