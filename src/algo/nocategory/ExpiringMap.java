package algo.nocategory;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.*;

public class ExpiringMap<K, V> {

    private final Map<K,Value> m = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(1);
    private final ExecutorService es = Executors.newFixedThreadPool(5);

    public ExpiringMap() {
        scheduledExecutorService.scheduleAtFixedRate(new MapEntryExpirer(m), 5, 5, TimeUnit.SECONDS);
    }

    /**
     * Gets the value associated with key or null.
     *
     * @param key key for which value is requested
     * @return returns value associated with key is it exists and value is not expired.
     *         returns null in case key is null or value is null of value is expired.
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }

        Value v = this.m.get(key);
        if (v == null) {
            return null;
        }

        long currentEpoch = Instant.now().getEpochSecond();
        if (v.expiringEpoch <= currentEpoch) {
            return null;
        }

        return (V) v.value;
    }

    /**
     * Updates or adds key value into the map.
     * If Key does not exist then creates a new Key:Value pair in map with value expiring after given duration from now.
     * If Key exists in the map then it updates its value to new value and new expiring after given duration from now.
     *
     * @param key key for which value is associated in map
     * @param value value to be associated with key
     * @param duration duration from now for which value should exist
     * @return true is value is successfully associated with key in the map.
     *         returns false if key is null or value is null or duration is zero or negative.
     */
    public boolean put(K key, V value, long duration) {
        if (key == null) {
            return false;
        }

        if (value == null) {
            return false;
        }

        if (duration <= 0) {
            return false;
        }

        long currentEpoch = Instant.now().getEpochSecond();
        this.m.put(key, new Value(value, currentEpoch + duration));
        return true;
    }

    private class MapEntryExpirer implements Runnable {
        private final Map<K,Value> m;

        public MapEntryExpirer(Map<K, Value> m) {
            this.m = m;
        }

        @Override
        public void run() {
            long currentEpoch = Instant.now().getEpochSecond();
            for (Map.Entry<K,Value> e : m.entrySet()) {
                Value value = e.getValue();
                if (currentEpoch >= value.expiringEpoch) {
                    es.submit(new ExpireTask(this.m, e.getKey()));
                }
            }
        }
    }

    private static class Value<V> {
        final long expiringEpoch;
        final V value;

        private Value(V value, long expiringEpoch) {
            this.expiringEpoch = expiringEpoch;
            this.value = value;
        }
    }

    private class ExpireTask<K, Value> implements Runnable {
        private final Map<K, Value> m;
        private final K key;

        public ExpireTask(Map<K, Value> m, K key) {
            this.m = m;
            this.key = key;
        }

        @Override
        public void run() {
            m.remove(key);
        }
    }
}
