package dataStructure;

import java.util.Scanner;

import dataStructure.SingleLinkedList.Node;

public class DoubleLinkedlist {

	static class Node
	{
		Node prev;
		int data;
		Node next;
	}
	
	Node head,temp,newnode;

	void create(DoubleLinkedlist list,int element)
	{
		Node newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		newnode.prev=null;
		if(list.head==null)
			list.head=newnode;
		else
		{
			temp=list.head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newnode;
			newnode.prev=temp;
		}
	}
	
	void insert_begin(DoubleLinkedlist list,int element)
	{
		Node newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		newnode.prev=null;
		if(list.head==null)
		{
			list.head=newnode;
		}
		else
		{
			head.prev=newnode;
			newnode.next=head;
			head=newnode;
		}
	}
	
	void insert_end(DoubleLinkedlist list,int element)
	{
		Node newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		newnode.prev=null;
		if(list.head==null)
		{
			list.head=newnode;
		}
		else
		{
			temp=list.head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newnode;
			newnode.prev=temp;
		}
	}
	
	void insert_middle(DoubleLinkedlist list,int element)
	{
		Node newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		newnode.prev=null;
		if(list.head==null)
		{
			list.head=newnode;
		}
		else
		{
			int length=0;
		    temp=list.head;
		    while(temp!=null)
		    {
		        temp=temp.next;
		        length++;
		    }
		    int middle=length/2; 
		    int i=0;
		    temp=list.head;
		    Node prev=null;
		    while(i!=middle)
		    {
		    	prev=temp;
		    	temp=temp.next;
		    	i++;
		    }
		    prev.next=newnode;
		    newnode.next=temp;
		    newnode.prev=prev;
		    temp.prev=newnode;
		}
	}
	
	void delete_begin(DoubleLinkedlist list)
	{
		if(list.head==null)
		{
			System.out.println("Linked list is not present");
		}
		else
		{
			temp=list.head;
			list.head=list.head.next;
			temp.next=null;	
			list.head.prev=null;
		}
	}
	
	void delete_end(DoubleLinkedlist list)
	{
		if(list.head==null)
		{
			System.out.println("Linked list is not present");
		}
		else
		{
			temp=list.head;Node prev=null;
			while(temp.next!=null)
			{
				prev=temp;
				temp=temp.next;
			}
			prev.next=null;
			temp.prev=null;
		}
	}
	
	void delete_middle(DoubleLinkedlist list)
	{
		if(list.head==null)
		{
			System.out.println("Linked list is not present");
		}
		else
		{
			int length=0;
		    temp=list.head;
		    while(temp!=null)
		    {
		        temp=temp.next;
		        length++;
		    }
		    int middle=length/2; 
		    int i=0;
		    temp=list.head;
		    Node prev=null;
		    while(i!=middle)
		    {
		    	prev=temp;
		    	temp=temp.next;
		    	i++;
		    }
		    prev.next=temp.next;
		    temp.next.prev=prev;
		    temp.prev=null;
		    temp.next=null;
		}
	}
	
	int search(DoubleLinkedlist list,int element)
	{
		temp=list.head;int i=0;
		while(temp!=null)
		{
			if(temp.data==element)
				return i;
			i++;
			temp=temp.next;
		}
		return -1;
	}
	
	void sort(DoubleLinkedlist list)
	{
		Node temp1=list.head,temp2;int a;
		while(temp1!=null)
		{
			temp2=temp1.next;
			while(temp2!=null)
			{
				if(temp1.data>temp2.data)
				{
					a=temp1.data;
					temp1.data=temp2.data;
					temp2.data=a;
				}
				temp2=temp2.next;
			}
			temp1=temp1.next;
		}
	}

	//1 2 3 4 5
	void reverse(DoubleLinkedlist list)
	{
	   Node prev=null,next=null,curr=list.head;
	   while(curr!=null)
	   {
		   next=curr.next;
		   curr.next=prev;
		   curr.prev=next;
		   prev=curr;
		   curr=next;
	   }
	   list.head=prev;
	}
	
	void display(DoubleLinkedlist list)
	{
		temp=list.head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			newnode=temp;
			temp=temp.next;
		}
		System.out.println();
		temp=newnode;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.prev;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	
		DoubleLinkedlist obj=new DoubleLinkedlist();
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number of node in linked list");
		int ch=in.nextInt();
		for(int i=0;i<ch;i++)
		{
			System.out.println("Enter the node value");
			int a=in.nextInt();
			obj.create(obj,a);
		}
		obj.insert_begin(obj, 0);
		obj.insert_end(obj, 50);
		obj.insert_middle(obj, 25);
		obj.delete_begin(obj);
		obj.delete_end(obj);
		obj.delete_middle(obj);
		obj.insert_begin(obj, 50);
		obj.insert_end(obj, 0);
		obj.display(obj);
		System.out.println(obj.search(obj, 20));
		obj.sort(obj);
		obj.display(obj);
		obj.reverse(obj);
		obj.display(obj);
	}
}
