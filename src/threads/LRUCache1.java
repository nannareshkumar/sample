package threads;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Created by home on 10/30/2017.
 */

    public class LRUCache1 < K, V > extends LinkedHashMap < K, V > {

        private int capacity; // Maximum number of items in the cache.

        public LRUCache1(int capacity) {
            super(capacity+1, 1.0f, true); // Pass 'true' for accessOrder.
            this.capacity = capacity;
        }

        protected boolean removeEldestEntry(Entry entry) {
            return (size() > this.capacity);
        }

        public V get(Object key) {
            V value = (V)( new Integer(-1));
            try {
                value = super.get(key);
            } catch (NullPointerException npe) {
                value = (V)( new Integer(-1));
            }
            return value;
        }


    public static void main(String[] args)
    {

        LRUCache1 lr=new LRUCache1(5);

        lr.put(1, 1);

        lr.put(2,2);

        lr.put(3, 3);

        lr.put(4, 4);

        lr.put(5, 5);

        int val = -1;
        for(int i = 1 ; i <= lr.size(); i++) {
            val = (Integer) lr.get(i);
            System.out.println("" + val);
        }

        lr.put(6, 6);

         val = -1;
        for(int i = 2 ; i <= lr.size(); i++) {
            val = (Integer) lr.get(i);
            System.out.println("" + val);
        }

    }


}