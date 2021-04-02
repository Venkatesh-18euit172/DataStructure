package dataStructure;

import dataStructure.CircularLinkedList.Node;

public class CircularDoubleLinkedList {

	static class Node
	{
		Node prev;
		int data;
		Node next;
	}
	
	Node start,temp,newnode;
	
	void create(CircularDoubleLinkedList list,int element)
	{
		newnode=new Node();
		newnode.data=element;
		newnode.prev=null;
		newnode.next=null;
		if(list.start==null)
		{
			list.start=newnode;
			newnode.prev=list.start;
			newnode.next=list.start;
		}
		else
		{
			temp=list.start.prev;
			temp.next=newnode;
			newnode.prev=temp;
			newnode.next=start;
			list.start.prev=newnode;
		}
	}
	
	void insert_begin(CircularDoubleLinkedList list,int element)
	{
		newnode=new Node();
		newnode.data=element;
		newnode.prev=null;
		newnode.next=null;
		if(list.start==null)
		{
			list.start=newnode;
			newnode.prev=list.start;
			newnode.next=list.start;
		}
		else
		{
			newnode.next=list.start;
			newnode.prev=list.start.prev;
			list.start.prev=newnode;
			newnode.prev.next=newnode;
			start=newnode;
		}
	}
	
	void insert_end(CircularDoubleLinkedList list,int element)
	{
		newnode=new Node();
		newnode.data=element;
		newnode.prev=null;
		newnode.next=null;
		if(list.start==null)
		{
			list.start=newnode;
			newnode.prev=list.start;
			newnode.next=list.start;
		}
		else
		{
			temp=list.start.prev;
			temp.next=newnode;
			newnode.prev=temp;
			newnode.next=start;
			list.start.prev=newnode;
		}
	}
	
	void inset_middle(CircularDoubleLinkedList list,int element)
	{
		newnode=new Node();
		newnode.data=element;
		newnode.prev=null;
		newnode.next=null;
		if(list.start==null)
		{
			list.start=newnode;
			newnode.prev=list.start;
			newnode.next=list.start;
		}
		else
		{
		       temp=list.start;int length=0;
		        do
		        {
		            temp=temp.next;
		            length++;
		        }
		        while(temp!=list.start);
		        int middle=length/2,a=0;Node prev=null;
		        while(a!=middle)
		        {
		            prev=temp;
		            temp=temp.next;
		            a++;
		        }
		        prev.next=newnode;
		        newnode.next=temp;
		        newnode.prev=prev;
		        temp.prev=newnode;
		}
	}
	
	void delete_begin(CircularDoubleLinkedList list)
	{
		if(list.start==null)
		{
			System.out.println("Not exist");
		}
		else
		{
			temp=list.start.next;
			temp.prev=list.start.prev;
			list.start.prev.next=temp;
			list.start.prev=null;
			list.start.next=null;
			list.start=temp;
		}
	}
	
	void delete_end(CircularDoubleLinkedList  list)
	{
		if(list.start==null)
		{
			System.out.println("Not exist");
		}
		else
		{
			Node last=list.start.prev;
			temp=last.prev;
			temp.next=list.start;
			list.start.prev=temp;
			last.next=null;
			last.prev=null;
		}
	}
	
	void delete_middle(CircularDoubleLinkedList list)
	{
		if(list.start==null)
		{
			System.out.println("Not exist");
		}
		else
		{
			   temp=list.start;int length=0;
		        do
		        {
		            temp=temp.next;
		            length++;
		        }
		        while(temp!=list.start);
		        int middle=length/2,a=0;Node prev=null;
		        while(a!=middle)
		        {
		            prev=temp;
		            temp=temp.next;
		            a++;
		        }
		        prev.next=temp.next;
		        temp.next.prev=prev;
		        temp.next=null;
		        temp.prev=null;
		}
	}
	
	void reverse(CircularDoubleLinkedList list)
	{
		//1 2 3 4 5
		Node prev=list.start.prev,next=null,curr=list.start;
		do
		{
			next=curr.next;
			curr.next=prev;
			curr.prev=next;
			prev=curr;
			curr=next;
		}
		while(curr!=list.start);
		list.start=prev;
	}
	
	void display(CircularDoubleLinkedList list)
	{
		if(list.start==null)
		{
			System.out.println("Not exist");
		}
		else
		{
			temp=list.start;
			do
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			while(temp!=list.start);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularDoubleLinkedList obj=new CircularDoubleLinkedList();
		obj.create(obj, 10);
		obj.create(obj, 20);
		obj.create(obj, 30);
		obj.create(obj, 40);
		obj.insert_begin(obj, 0);
		obj.insert_end(obj, 50);
		obj.inset_middle(obj, 25);
		obj.delete_begin(obj);
		obj.delete_end(obj);
		obj.delete_middle(obj);
		obj.display(obj);
		obj.reverse(obj);
		obj.display(obj);
	}
}
