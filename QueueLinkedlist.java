package dataStructure;

public class QueueLinkedlist {

	class Node
	{
		int data;
		Node next;
	}

	Node front,rear,newnode,temp;
	
	 public void enqueue(QueueLinkedlist queue,int element)
	 {
		 newnode=new Node();
		 newnode.data=element;
		 newnode.next=null;
		 
		 if(queue.front==null)
		 {
			 queue.front=newnode;
			 queue.rear=newnode;
		 }
		 else
		 {
			 queue.rear.next=newnode;
			 queue.rear=newnode;
		 }
	 }
	
	 public void dequeue(QueueLinkedlist queue)
	 {
		 if(front==null)
			 return;
		 else
		 {
			 temp=queue.front;
			 queue.front=queue.front.next;
			 temp.next=null;
		 }
	 }
	 
	 public void display(QueueLinkedlist queue)
	 {
	     	 if(front==null)
	     	 {
	     		 System.out.println("Queue is Empty");
	     	 }
	     	 else
	     	 {
	     		 temp=queue.front;
	     		 while(temp!=null)
	     		 {
	     			 System.out.print(temp.data+" ");
	     			 temp=temp.next;
	     		 }
	     		 System.out.println();
	     	 }
	 }
	 
	public static void main(String[] args) {
		QueueLinkedlist obj=new QueueLinkedlist();
		for(int i=1;i<=5;i++)
		{
			obj.enqueue(obj, i);
		}
		obj.display(obj);
		for(int i=1;i<=5;i++)
		{
			obj.dequeue(obj);
		}
		obj.display(obj);
		obj.enqueue(obj, 25);
		obj.display(obj);
	}
}
