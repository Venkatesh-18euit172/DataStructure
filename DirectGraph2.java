package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectGraph2 {
		
	void insert(ArrayList<ArrayList<Integer>> a,int u,int v)
	{
		if(u<a.size())
			a.get(u).add(v);
		else
		{
			a.add(new ArrayList<Integer>());
			a.get(u).add(v);
		}
	}
		
	void delete(ArrayList<ArrayList<Integer>> a,int u)
	{
		a.remove(u);
		for(int i=0;i<a.size();i++)
		{
			for(int j=0;j<a.get(i).size();j++)
			{
				if(a.get(i).contains(u))
					a.get(i).remove(Integer.valueOf(u));
			}
		}
	}
	
	void display(ArrayList<ArrayList<Integer>> a)
	{
		for(int i=0;i<a.size();i++)
		{
			System.out.print(i+" ");
			for(int j=0;j<a.get(i).size();j++)
			{
				System.out.print("->"+a.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	void BFS(ArrayList<ArrayList<Integer>> a,int source)
	{
		boolean visited[]=new boolean[a.size()];
		
		Queue<Integer> l=new LinkedList<>();
		l.add(source);
		visited[source]=true;
		
		while(!l.isEmpty())
		{
			int temp=l.peek();
			l.remove();
			
			System.out.print(temp+" ");
			
			for(int i=0;i<a.get(temp).size();i++)
			{
				int n=a.get(temp).get(i);
				if(visited[n]==false)
				{
					l.add(n);
					visited[n]=true;
				}
			}   
		}
	}
	
	void getVertexAtLevel(ArrayList<ArrayList<Integer>> a,int source,int b)
	{
		boolean visited[]=new boolean[a.size()];
		
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
				
				for(int i=0;i<a.get(temp).size();i++)
				{
					int n=a.get(temp).get(i);
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
	
	int getLevel(ArrayList<ArrayList<Integer>> a,int source,int node)
	{
		boolean visited[]=new boolean[a.size()];
		
		Queue<Integer> l=new LinkedList<>();
		l.add(source);
		visited[source]=true;
		int level=0;
		
		while(!l.isEmpty())
		{
			int size=l.size();		
			while(size>0)
			{
				int temp=l.peek();
				l.remove();
				
				if(temp==node)
					return level;
				
				for(int i=0;i<a.get(temp).size();i++)
				{
					int n=a.get(temp).get(i);
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
		return level;
	}
	
	void DFS(ArrayList<ArrayList<Integer>> a,int source)
	{
		boolean visited[]=new boolean[a.size()];
		
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
			
			for(int i=a.get(temp).size()-1;i>=0;i--)
			{
				int n=a.get(temp).get(i);
				if(visited[n]==false)
				{
					l.add(n);
				}
			}
		}
	}
	
	void DFSrecursive(ArrayList<ArrayList<Integer>> a,boolean visited[],int source)
	{
		System.out.print(source+" ");
		visited[source]=true;
		
		for(int i=0;i<a.get(source).size();i++)
		{
			int n=a.get(source).get(i);
			if(visited[n]==false)
			{
				DFSrecursive(a, visited, n);
			}
		}
	}
	
	void DFSMatrix(int graph[][],boolean visited[],int source)
	{
		System.out.print(source+" ");
		visited[source]=true;
		
		for(int i=0;i<graph[source].length;i++)
		{
			if(graph[source][i]==1 && visited[i]==false)
			{
					DFSMatrix(graph, visited, i);
			}
		}
	}
	
    int countPath(ArrayList<ArrayList<Integer>> graph,boolean visited[],int u,int v,int count)
    {
        if(u==v)
            count++;
        else
        {
            for(int i=0;i<graph.get(u).size();i++)
            {
                if(visited[u]==false)
                {
                    visited[u]=true;
                    count=countPath(graph ,visited , graph.get(u).get(i) , v,count);
                    visited[u]=false;
                }
            }
        }
        return count;
    }
	
    boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj,int source,boolean[] recStack)  
    { 
        if (recStack[source]) 
            return true; 
        recStack[source] = true; 
        for (int i=0;i<adj.get(source).size();i++) 
            if (isCyclicUtil(adj,adj.get(source).get(i),recStack)) 
                return true; 
        recStack[source] = false; 
        return false; 
    } 
    
    
    
    boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean recStack[]=new boolean[V];
        for(int i=0;i<V;i++)
            if(isCyclicUtil(adj,i,recStack))
                return true;
        return false;
    }
    
    
    
	public static void main(String[] args) {
		DirectGraph2 obj=new DirectGraph2();
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		for(int i=0;i<7;i++)
			graph.add(new ArrayList<Integer>());
		graph.get(0).add(1);
		graph.get(0).add(2);
		graph.get(1).add(3);
		graph.get(1).add(4);
		graph.get(1).add(5);
		graph.get(2).add(6);
		obj.display(graph);
		obj.BFS(graph, 0);
		System.out.println();
		obj.DFS(graph, 0);
		System.out.println();
		boolean visited[]=new boolean[7];
		obj.DFSrecursive(graph, visited, 0);
		System.out.println();
		for(int i=1;i<=3;i++)
		{
			obj.getVertexAtLevel(graph, 0, i);
			System.out.println();
		}
		System.out.println(obj.getLevel(graph, 0, 2));
	}
}