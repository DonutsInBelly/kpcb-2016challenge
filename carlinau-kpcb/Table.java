public class Table
{
    public Object[] table;
    public int size;
    public int capacity;
    
	public Table(int capacity) 
	{
		this.capacity = capacity;
		this.size = 0;
		this.table = new Object[capacity];
	}
	/*
	 * Set uses linear probing to handle collisions
	 * landing: resulting integer from the key to be used as an index
	 */
	public boolean set(String key, Object element)
    {
		int landing = key.hashCode()%capacity;
		if(landing<0)
		{
			landing = Math.abs(landing);
		}
		//System.out.println("Setting at index: "+landing);
		if(table[landing]==null)
		{
			table[landing] = element;
			size++;
			return true;
		}
		else
		{
			int iter = landing+1;
			while(iter!=landing)
			{
				if(table[iter]==null)
				{
					table[iter] = element;
					size++;
					return true;
				}
				else
				{
					if(iter+1==capacity)
					{
						iter = 0;
					}
					iter++;
					continue;
				}
			}
		}
    	return false;
    }
    public String get(String key)
    {
    	int landing = key.hashCode()%capacity;
    	if(landing<0)
    	{
    		landing=Math.abs(landing);
    	}
    	if(table[landing]==null)
    	{
    		return null;
    	}
    	return table[landing].toString();
    }
    public String delete(String key)
    {
    	int landing = key.hashCode()%capacity;
    	if(landing<0)
    	{
    		landing=Math.abs(landing);
    	}
    	if(table[landing]==null)
    	{
    		return null;
    	}
    	else
    	{
    		Object temp = table[landing];
    		table[landing] = null;
    		size--;
    		return temp.toString();
    	}
    }
    public float load()
    {
    	System.out.println("Current Size: " + size);
    	System.out.println("Capacity: " + capacity);
    	System.out.println();
    	System.out.print("Load Factor: ");
    	return (float)size/capacity;
    }
    
}
