package dataStructure;

class Node
{
	int data;
    Node next;
}

public class StackLinkedlst {

	  Node head,tail,newnode,temp;
	
	 public void push(StackLinkedlst stack,int element)
	 {
		 newnode=new Node();
		 newnode.data=element;
		 newnode.next=null;
		 
		 if(stack.head==null)
		 {
			 stack.head=newnode;
			 stack.tail=newnode;
		 }
		 else
		 {
			 stack.tail.next=newnode;
			 stack.tail=newnode;
		 }
	 }
	
	 public void pop(StackLinkedlst stack)
	 {
		 if(stack.head==null)
		 {
			 return;
		 }
		 else
		 {
			 temp=stack.head;
			 if(temp.next==null)
			 {
				 stack.head=null;
			 }
			 else
			 {
				 while(temp.next.next!=null)
				 {
					 temp=temp.next;
				 }
				 stack.tail=temp;
				 temp.next=null; 
			 }
		 }
	 }
	 
	 public void display(StackLinkedlst stack)
	 {
	     	 if(head==null)
	     	 {
	     		 System.out.println("Stack is Empty");
	     	 }
	     	 else
	     	 {
	     		 temp=stack.head;
	     		 while(temp!=null)
	     		 {
	     			 System.out.print(temp.data+" ");
	     			 temp=temp.next;
	     		 }
	     		 System.out.println();
	     	 }
	 }
	 
	public static void main(String[] args) {
		StackLinkedlst obj=new StackLinkedlst();
		for(int i=1;i<=5;i++)
		{
			obj.push(obj, i);
		}
		obj.display(obj);
		for(int i=1;i<=5;i++)
		{
			obj.pop(obj);
		}
		obj.display(obj);
		obj.push(obj, 25);
		obj.display(obj);
	}
}
