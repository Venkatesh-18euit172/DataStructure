package dataStructure;

public class MinHeap {

	int harr[],heap_size,capacity;
	
	public MinHeap(int capacity) {
		this.capacity=capacity;
		this.heap_size=0;
		harr=new int[capacity];
	}
	
	int parent(int i)
	{
		return (i-1)/2;
	}
	
	int left(int i)
	{
		return (2*i + 1);
	}
	
	int right(int i)
	{
		return (2*i + 2);
	}
	
	void MinHeapify(int i)
	{
		int l=left(i);
		int r=right(i);
		int smallest=i;
		if(l<heap_size && harr[i]>harr[l])
			smallest=l;
		if(r<heap_size && harr[smallest]>harr[r])
			smallest=r;
		if(smallest!=i)
		{
			int temp=harr[smallest];
			harr[smallest]=harr[i];
			harr[i]=temp;
			MinHeapify(smallest);
		}
	}
	
	void bringFirst(int i)
	{
		int temp=0;
		harr[i]=Integer.MIN_VALUE;
		while(i>0 && harr[parent(i)]>harr[i])
		{
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	void insert(int value)
	{
		if(heap_size==capacity)
			return ;
		else
		{
			harr[heap_size]=value;
			int i=heap_size,temp;
			while(i>0 && harr[parent(i)]>harr[i])
			{
				temp = harr[parent(i)];
				harr[parent(i)]=harr[i];
				harr[i]=temp;
				i=parent(i);
			}
		}
	}
	
	int extractMin()
	{
		if(heap_size<=0)
			return -1;
		if(heap_size==1)
		{
			heap_size--;
			return harr[0];
		}
		int temp=harr[0];
		harr[0]=harr[heap_size-1];
		heap_size--;
		MinHeapify(0);
		return temp;
	}
	
	void deleteKey(int pos)
	{
		if(pos<0 || pos>=heap_size)
			return ;
		//Bringing node to first to delete
		bringFirst(pos);
		//Deleteing the 1st element
		extractMin();
	}
}