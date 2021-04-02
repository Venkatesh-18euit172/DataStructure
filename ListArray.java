package dataStructure;

import java.util.Scanner;

public class ListArray {

	int list[]=new int[1000];
	int size,pos;
	
	public ListArray(int size)
	{
		this.size=size;
		pos=-1;
	}
	
	void insert(int element)
	{
		if(isFull())
			System.out.println("List Overflow");
		else
			list[++pos]=element;
	}
	
	void delete(int pos)
	{
		if(isEmpty())
			System.out.println("List Underflow");
		else
		{
			for(int i=pos-1;i<size-1;i++)
				list[i]=list[i+1];
			size--;
		}
	}
	
	int search(int element)
	{
		if(isEmpty())
			System.out.println("Element is not present");
		else
		{
			for(int i=0;i<size;i++)
			{
				if(list[i]==element)
					return i+1;
			}
		}
		return -1;
	}
	
	boolean isFull()
	{
		if(pos==size-1)
			return true;
		else
			return false;
	}
	
	boolean isEmpty()
	{
		if(pos<0)
			return true;
		else
			return false;
	}
	
	void display()
	{
		for(int i=0;i<size;i++)
			System.out.print(list[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the size of the list");
		int size=in.nextInt();
		if(size>1000)
			System.out.println("Maximum size of list is 1000");
		else
		{
			ListArray obj=new ListArray(size);
			System.out.println("List is Empty : "+obj.isEmpty());
			for(int i=1;i<size+2;i++)
				obj.insert(i);;
			obj.display();
			System.out.println("List is full : "+obj.isFull());
			System.out.println("List is Empty : "+obj.isEmpty());
			System.out.println("Element 5 is present at position "+obj.search(5));
			for(int i=1;i<4;i++)
				obj.delete(1);
			obj.display();
			for(int i=1;i<size-4;i++)
				obj.delete(1);
			System.out.println("List is full : "+obj.isFull());	
		}
		in.close();
	}
}