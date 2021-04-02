package dataStructure;

import java.util.LinkedList;

public class Linkedlist_collection {

	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		list.add(2);
		list.add(1, 3);
		list.addFirst(1);
		list.addLast(4);
		list.remove(3);
		list.removeFirst();
		list.removeLast();
		System.out.println(list.contains(2));
		list.addFirst(5);
		list.addLast(0);
		list.add(25);
		list.sort(null);
		
		for(Integer i:list)
		{
			System.out.print(i+" ");
		}
	}
}
