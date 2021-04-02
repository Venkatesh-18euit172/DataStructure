package dataStructure;

import java.util.Scanner;

public class QueueArray {

	int queue[]=new int[1000];
	int front,rear,size;
	
	public QueueArray(int size) {
		this.size=size;
		front=-1;
		rear=-1;
	}
	
	void enqueue(int element)
	{
		if(isFull())
			 System.out.println("Queue Overflow");
		else
		{
			if(front==-1)
				front=0;
			queue[++rear]=element;
		}
	}
	
	void dequeue()
	{
		if(isEmpty())
			System.out.println("Queue Underflow");
		else
		{
			if(front==rear)
			{
				front=-1;rear=-1;
			}
			else
				front++;
		}
	}
	
	boolean isFull()
	{
		if(rear==size-1)
			return true;
		else
			return false;
	}
	
	boolean isEmpty()
	{
		if(front==-1 && rear==-1)
			return true;
		else
			return false;
	}
	
	void display()
	{
		for(int i=front;i<=rear;i++)
			System.out.print(queue[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the size of the Queue");
		int size=in.nextInt();
		if(size>1000)
			System.out.println("Maximum size of Queue is 1000");
		else
		{
			QueueArray obj=new QueueArray(size);
			System.out.println("Queue is Empty : "+obj.isEmpty());
			for(int i=1;i<size+2;i++)
				obj.enqueue(i);
			obj.display();
			System.out.println("Queue is full : "+obj.isFull());
			System.out.println("Queue is Empty : "+obj.isEmpty());
			for(int i=0;i<5;i++)
				obj.dequeue();
			obj.display();
			for(int i=0;i<size-4;i++)
				obj.dequeue();
			System.out.println("Queue is full : "+obj.isFull());	
		}
		in.close();
	}
}
