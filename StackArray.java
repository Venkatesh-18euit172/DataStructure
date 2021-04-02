package dataStructure;

import java.util.Scanner;

public class StackArray {

	int stack[]=new int[1000];
	int top;
	int size;
	
	StackArray(int size)
	{
		top=-1;
		this.size=size;
	}
	
	void push(int element)
	{
		if(isFull())
			System.out.println("Stack Overflow");
		else
		{
			top++;
			stack[top]=element;			
		}
	}
	
	void pop()
	{
		if(isEmpty())
			System.out.println("Stack Underflow");
		else
		{
			stack[top]=0;
			top--;
		}
	}

	void peek()
	{
		System.out.println("Stack top element is "+stack[top]);
	}
	
	void display()
	{
		System.out.print("Elements present in Stack are ");
		for(int i=0;i<=top;i++)
			System.out.print(stack[i]+" ");
		System.out.println();
	}
	
	boolean isFull()
	{
		if(top>=size-1)
			return true;
		else
			return false;
	}
	
	boolean isEmpty()
	{
		if(top<0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
	
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the size of the Stack");
		int size=in.nextInt();
		if(size>1000)
			System.out.println("Maximum size of Stack is 1000");
		else
		{
			StackArray obj=new StackArray(size);
			System.out.println("Stack is Empty : "+obj.isEmpty());
			for(int i=1;i<size+2;i++)
				obj.push(i);
			obj.display();
			System.out.println("Stack is full : "+obj.isFull());
			System.out.println("Stack is Empty : "+obj.isEmpty());
			obj.peek();
			for(int i=0;i<5;i++)
				obj.pop();
			obj.display();
			for(int i=0;i<size-4;i++)
				obj.pop();
			System.out.println("Stack is full : "+obj.isFull());	
		}
		in.close();
	}
}