package threads;

import java.util.HashMap;

public class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }

    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre = n;

        head = n;

        if(end ==null)
            end = head;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);

            }else{
                setHead(created);
            }

            map.put(key, created);
        }
    }

    public static void main(String[] args)

    {

        LRUCache lr=new LRUCache(5);

        lr.set(1, 1);

        lr.set(2,2);

        lr.set(3, 3);

        lr.set(4, 4);

        lr.set(5, 5);

        int val = -1;
        for(int i = 1 ; i <= lr.capacity+1; i++) {
            val = (Integer) lr.get(i);
            System.out.println("i:" + i + " val:" + val);
        }

        lr.set(6, 6);

        for(int i = 1 ; i <= lr.capacity +1; i++) {
            val = (Integer) lr.get(i);
            System.out.println("i:" + i + " val:" + val);
        }

    }


    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

}

