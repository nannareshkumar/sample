package threads; /**
 * Created by home on 1/7/2018.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl {

    public static void main(String arg[]){
        LRUImpl lru = new LRUImpl();

        for(int i = 0 ; i < 3; i++) {
            lru.get(i);
        }
        System.out.println(lru); // 0,1,2
        lru.get(0);
        lru.put(3, "Object3");
        System.out.println(lru); // 0,2,3
        lru.get(2);
        lru.put(5, "Object5"); // 0,2,5
        System.out.println(lru);
        lru.get(5);
        lru.put(6, "Object6"); // 2,5,6
        lru.put(7, "Object7"); // 5,6,7
        System.out.println(lru);
    }
       
}

class LRUImpl extends LinkedHashMap<Integer, String> {
    private static final long serialVersionUID = 1L;
    private static final int capacity = 3;

    /**
     * removeEldestEntry() should be overridden by the user, otherwise it will not
     * remove the oldest object from the Map.
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > this.capacity;
    }

    String getValue(Integer x) {
        return "Object" + x;
    }

    String getCache(Integer x) {
        return super.get(x);
    }

    String get(Integer x){
        String result;
        if(containsKey(x)) {
            result = getCache(x);
        } else {
            result = getValue(x);
        }
        remove(x);
        put(x, result);

        return result;
    }


}