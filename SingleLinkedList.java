package dataStructure;

public class SingleLinkedList {

	class Node
	{
		int data;
		Node next;
	}
	
	Node head,temp,newnode;
		
	void create(SingleLinkedList list,int element)
	{
		Node newnode=new Node();
		newnode.data=element;
		newnode.next=null;
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
		}
	}
	
	void insert_begin(SingleLinkedList list,int element)
	{
		Node newnode=new Node();
		newnode.data=element;
		newnode.next=null;
		if(list.head==null)
		{
			list.head=newnode;
		}
		else
		{
			newnode.next=list.head;
			list.head=newnode;
		}
	}
	
	void insert_end(SingleLinkedList list,int element)
	{
		Node newnode=new Node();
		newnode.data=element;
		newnode.next=null;
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
		}
	}
	
	void insert_middle(SingleLinkedList list,int element)
	{
		Node newnode=new Node();
		newnode.data=element;
		newnode.next=null;
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
		    while(i!=middle+1)
		    {
		    	prev=temp;
		    	temp=temp.next;
		    	i++;
		    }
		    prev.next=newnode;
		    newnode.next=temp;
		}
	}
	
	void delete_begin(SingleLinkedList list)
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
		}
	}
	
	void delete_end(SingleLinkedList list)
	{
		if(list.head==null)
		{
			System.out.println("Linked list is not present");
		}
		else
		{
			temp=list.head;
			while(temp.next.next!=null)
			{
				temp=temp.next;
			}
			temp.next=null;
		}
	}
	
	void delete_middle(SingleLinkedList list)
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
		    while(i!=middle+1)
		    {
		    	prev=temp;
		    	temp=temp.next;
		    	i++;
		    }
		    prev.next=temp.next;
		}
	}
	
	int search(SingleLinkedList list,int element)
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
	
	void sort(SingleLinkedList list)
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
	
	void reverse(SingleLinkedList list)
	{
		Node prev=null,next=null,curr=list.head;
		while(curr!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		list.head=prev;
	}
	
	void display(SingleLinkedList list)
	{
		temp=list.head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {

		SingleLinkedList obj=new SingleLinkedList();
		obj.create(obj, 2);
		obj.create(obj, 4);
		obj.insert_begin(obj, 1);
		obj.insert_middle(obj, 3);
		obj.insert_end(obj, 5);
		obj.delete_begin(obj);
		obj.delete_end(obj);
		obj.delete_middle(obj);
		obj.insert_end(obj, 0);
		obj.insert_end(obj, -5);
		obj.display(obj);
		obj.sort(obj);
		obj.display(obj);
		obj.reverse(obj);
		obj.display(obj);
	}
}
