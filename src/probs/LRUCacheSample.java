package probs;

import java.util.*;

/**
 * Created by home on 11/23/2020.
 */
public class LRUCacheSample {
    int capacity;

    //probs.LinkedListNode holds key and value pairs
    Set<Integer> cache;
    LinkedList<LinkedListNode> cache_vals;
    public LRUCacheSample(int capacity) {
        this.capacity = capacity;
        cache = new HashSet<Integer>(capacity);
        cache_vals = new LinkedList<LinkedListNode>();
    }

    LinkedListNode get(int key) {
        if(!cache.contains(key)){

            return null;
        }
        else {

            ListIterator<LinkedListNode> iterator1 = cache_vals.listIterator(0);
            while(iterator1.hasNext()){
                LinkedListNode node = iterator1.next();
                if (node.key == key){
                    return node;
                }
            }
            return null;
        }
    }

    void set(int key, int value) {
        LinkedListNode node = get(key);

        if(node == null){
            evict_if_needed();
            node = new LinkedListNode(key, value);
            cache_vals.addLast(node);
            cache.add(key);
        }
        else {
            cache_vals.remove(node);
            cache_vals.addLast(node);
        }
    }

    void evict_if_needed(){
        if(cache_vals.size() >= capacity) {
            LinkedListNode node = cache_vals.remove();
            cache.remove(node.key);

        }
    }

    void print() {
        ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
        while(iterator.hasNext()){
            LinkedListNode node = iterator.next();
            System.out.print(node.key + ":" +node.value + ", ");
        }
        System.out.println("");
    }
    public static void main(String[] args){
        LRUCacheSample cache = new LRUCacheSample(4);

        cache.set(10, 110);
        cache.print();

        cache.set(15, 150);
        cache.print();

        cache.set(20, 220);
        cache.print();

        cache.set(25, 225);
        cache.print();

        cache.set(20, 330);
        cache.print();

        cache.set(40, 350);
        cache.print();

        cache.set(25, 325);
        cache.print();
    }
}

class LinkedListNode {
    public int key;
    public int value;

    LinkedListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}