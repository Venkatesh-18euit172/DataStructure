package dataStructure;

import java.util.*;

public class DirectGraph1 {
	
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
	
	void BFS(LinkedList<Integer> a[],int source)
	{
		boolean visited[]=new boolean[a.length];
		
		Queue<Integer> l=new LinkedList<>();
		l.add(source);
		visited[source]=true;
		
		while(!l.isEmpty())
		{
			int temp=l.peek();
			l.remove();
			
			System.out.print(temp+" ");
			
			for(int i=0;i<a[temp].size();i++)
			{
				int n=a[temp].get(i);
				if(visited[n]==false)
				{
					l.add(n);
					visited[n]=true;
				}
			}   
		}
	}
	
	void getVertexAtLevel(LinkedList<Integer> a[],int source,int b)
	{
		boolean visited[]=new boolean[a.length];
		
		Queue<Integer> l=new LinkedList<>();
		l.add(source);
		visited[source]=true;
		int level=1;
		
		while(!l.isEmpty())
		{
			int size=l.size();
		
			if(level==b)
			{
				while(size>0)
				{
					int temp=l.peek();
					l.remove();
					
					System.out.print(temp+" ");	
					size--;
				}
				break;
			}
			while(size>0)
			{
				int temp=l.peek();
				l.remove();
				
				for(int i=0;i<a[temp].size();i++)
				{
					int n=a[temp].get(i);
					if(visited[n]==false)
					{
						l.add(n);
						visited[n]=true;
					}
				}
				size--;
			}
			level++;
		}
	}
	
	void DFS(LinkedList<Integer> a[],int source)
	{
		boolean visited[]=new boolean[a.length];
		
		Stack<Integer> l=new Stack<>();
		
		l.add(source);
		
		while(!l.isEmpty())
		{
			int temp=l.peek();
			l.pop();
			
			if(visited[temp]==false)
			{
				System.out.print(temp+" ");
				visited[temp]=true;
			}
			
			for(int i=0;i<a[temp].size();i++)
			{
				int n=a[temp].get(i);
				if(visited[n]==false)
				{
					l.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DirectGraph1 obj=new DirectGraph1();
		LinkedList<Integer> graph[]=new LinkedList[7];
		for(int i=0;i<7;i++)
			graph[i]=new LinkedList<Integer>();
		graph[0].add(1);
		graph[0].add(2);
		graph[1].add(3);
		graph[1].add(4);
		graph[1].add(5);
		graph[2].add(6);
		for(int i=1;i<=3;i++)
		{
			obj.getVertexAtLevel(graph, 0, i);
			System.out.println();
		}
	}
}