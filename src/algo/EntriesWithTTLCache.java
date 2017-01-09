package algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class EntriesWithTTLCache<K extends Comparable<K>, V extends Expirable> implements Cache<K, V> {

	private final int maxSize;
	private HashMap<K, V> map;
	private PriorityQueue<K> queue;
	
	public EntriesWithTTLCache(final int maxSize) {
	    this.maxSize = maxSize;
	    map = new HashMap<K, V>(maxSize);
	    queue = new PriorityQueue<K>(maxSize, new Comparator<K>() {

			@Override
			public int compare(K o1, K o2) {
				if (o1.compareTo(o2) < 0)
					return 1;
				else if (o1.compareTo(o2) > 0)
					return -1;
				return 0;
			}
		});
	    
	}
	
	@Override
	public V get(final K key) {
	    V value = map.get(key);
	    if (value != null) {
	    	if (value.isExpired()) {
	    		synchronized (this) {
	    			map.remove(key);
			    	queue.remove(key);
				}
	    	}
	    }
	    return value;
	}
	
	@Override
	public synchronized void put(final K key, final V value) {
	    while (queue.size() >= maxSize) {
			K oldestKey = queue.poll();
			if (null != oldestKey) {
				V v = map.remove(oldestKey);
				v = null;
			}
	    }
	    queue.add(key);
	    map.put(key, value);
	}
}
