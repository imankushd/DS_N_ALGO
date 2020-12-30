package com.dsAlgo.atoz;

import java.util.HashMap;

class Entry
{
	String key;
	String value;
	Entry prev;
	Entry next;
	
	Entry(String key, String value)
	{
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {

	static int LRU_SIZE = 3;
	static HashMap<String,Entry> hm;
	
	Entry start,end;
	
	LRUCache()
	{
		hm = new HashMap<String, Entry>();
	}
	
	
	
	public static void main(String[] args) {

		LRUCache lru = new LRUCache();
		lru.put("1","abc");
		lru.put("3","abc");
		lru.put("4","abcd");
		lru.put("5","abcz");
		lru.put("2","abcdf");
		lru.put("6","wwwz");
		
		System.out.println(lru.get("2"));
		System.out.println(lru.get("3"));
		
		for(String k : hm.keySet())
			System.out.print(k+" ");
		System.out.println();
	}

	private String get(String key) {
		// TODO Auto-generated method stub
		if(hm.containsKey(key))
		{
		  	Entry e = hm.get(key);
		  	removeNode(e);
		  	addToTop(e);
		  	return e.value;
		}
		return "No "+key+" key present";
	}

	private void removeNode(Entry e) {

		if(e.prev!=null)
		{
			e.prev.next = e.next;
		}
		else
			start = e.next;
		
		if(e.next!=null)
		{
			e.next.prev = e.prev;
		}
		else
			end = e.prev;
	}
	

	private void addToTop(Entry e) {
        e.next = start;
        e.prev = null;
        if(start!=null)
        {
        	start.prev = e;
        }
        start = e;
        
        if(end == null)
        	end = start;
	}

	private void put(String key, String value) {
		
		if(hm.containsKey(key))
		{
			Entry e = hm.get(key);
			e.value = value;
			removeNode(e);
			addToTop(e);
		}
		else
		{
		   Entry e = new Entry(key, value);	
		   e.prev = null;
		   e.next = null;
		   
		   if(hm.size()>=LRU_SIZE)
		   {
			   hm.remove(end.key);
			   removeNode(end);
			   addToTop(e);
		   }
		   else
		   {
			   addToTop(e);
		   }
		   
		   hm.put(key,e);
		}
		
	}

}
