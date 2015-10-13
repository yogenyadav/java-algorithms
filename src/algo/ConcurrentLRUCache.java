package algo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLRUCache<K, V> implements Cache<K, V> {

	private final int maxSize;
	private ConcurrentHashMap<K, V> map;
	private ConcurrentLinkedQueue<K> queue;
	
	public ConcurrentLRUCache(final int maxSize) {
	    this.maxSize = maxSize;
	    map = new ConcurrentHashMap<K, V>(maxSize);
	    queue = new ConcurrentLinkedQueue<K>();
	}
	
	@Override
	public V get(final K key) {
	    V value = map.get(key);
	    if (value != null) {
	    	queue.remove(key);
	    	queue.add(key);
	    }
	    return value;
	}
	
	@Override
	public void put(final K key, final V value) {
	    if (map.containsKey(key)) {
	        queue.remove(key); // remove the key from the FIFO queue
	    }
	 
	    while (queue.size() >= maxSize) {
	        K oldestKey = queue.poll();
	        if (null != oldestKey) {
	            map.remove(oldestKey);
	        }
	    }
	    queue.add(key);
	    map.put(key, value);
	}
}
