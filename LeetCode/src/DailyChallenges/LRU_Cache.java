package DailyChallenges;

import java.util.HashMap;

class DoubleLinkedNode {

    int key;
    int val;
    DoubleLinkedNode next;
    DoubleLinkedNode prev;

    public DoubleLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }


}

class LRUCache {

    HashMap<Integer, DoubleLinkedNode> cache;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    int counter;
    int cap;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        cache = new HashMap<>();
        cap = capacity;
        counter = 0;

    }

    public int get(int key) {


        if(cache.containsKey(key)){
            DoubleLinkedNode node = cache.get(key);

            if(node.next != null){

                if(node.prev != null)
                    node.prev.next = node.next;

                node.next.prev = node.prev;


                if(node.prev == null)
                    head = node.next;


                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;

            }


            return node.val;
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {

        DoubleLinkedNode node;
        if (head == null) {
            node = new DoubleLinkedNode(key, value);
            head = node;
            tail = node;
            counter++;
        } else {

            if (!cache.containsKey(key)) {

                node = new DoubleLinkedNode(key, value);
                counter++;
                if(counter > cap){
                    cache.remove(head.key);
                    if(head.next != null){
                        head = head.next;
                    }else{
                        head = node;
                    }

                    head.prev = null;
                    counter--;
                }

                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;

            } else {
                node = cache.get(key);
                node.val = value;

                if(node.next != null){

                    if(node.prev != null)
                        node.prev.next = node.next;

                    node.next.prev = node.prev;


                    if(node.prev == null)
                        head = node.next;


                    tail.next = node;
                    node.prev = tail;
                    node.next = null;
                    tail = node;

                }

            }

        }

        cache.put(key, node);
    }
}


public class LRU_Cache {
    public static void main(String[] args) {

        LRUCache myCache = new LRUCache(2);

        myCache.put(2,1);
        myCache.put(3,2);

        System.out.println(myCache.get(3));

        System.out.println(myCache.get(2));

        myCache.put(4,3);

        System.out.println(myCache.get(2));

        System.out.println(myCache.get(3));

        System.out.println(myCache.get(4));


    }
}
