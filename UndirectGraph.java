package dataStructure;

import java.util.*;

public class UndirectGraph {

	void edges(LinkedList<Integer> a[],int u,int v)
	{
		a[u].add(v);
		a[v].add(u);
	}
	
	void display(LinkedList<Integer> a[])
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(i+" ");
			for(int j=0;j<a[i].size();j++)
			{
				System.out.print("->"+a[i].get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
	
		UndirectGraph obj=new UndirectGraph();
		
		LinkedList<Integer> graph[]=new LinkedList[5];
		for(int i=0;i<5;i++)
		{
			graph[i]=new LinkedList<Integer>();
		}
		
		obj.edges(graph, 0, 1);
		obj.edges(graph, 0, 4);
		obj.edges(graph, 1, 2);
		obj.edges(graph, 1, 3);
		obj.edges(graph, 1, 4);
		obj.edges(graph, 2, 3);
		obj.edges(graph, 3, 4);
		obj.display(graph);
	}
}