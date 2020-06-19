package DailyChallenges;


import java.util.HashMap;

class LinkedNode{

    int val;
    int occ;
    LinkedNode next;
    LinkedNode prev;
    LinkedNode(int val){
        this.val = val;
        occ = 1;
    }


}

class FirstUnique {

    LinkedNode head;
    LinkedNode tail;
    HashMap<Integer, LinkedNode> map;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();

        for(int i : nums){
            if(map.containsKey(i)){
                LinkedNode node = map.get(i);

                if(node.occ == 1){
                    if(node.prev != null){
                        node.prev.next = node.next;
                    }else{
                        head = node.next;
                    }

                    if(node.next != null){
                        node.next.prev = node.prev;
                    }else{
                        tail = node.prev;
                    }
                    node.occ++;
                }

            }else{
                LinkedNode node = new LinkedNode(i);
                map.put(i, node);
                if(head == null){
                    head = node;
                    tail = node;
                }else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
                map.put(i, node);
            }


        }


    }

    public int showFirstUnique() {
        if(head == null) return -1;

        return head.val;
    }

    public void add(int value) {

        if(map.containsKey(value)){
            LinkedNode node = map.get(value);

            if(node.occ == 1){
                if(node.prev != null){
                    node.prev.next = node.next;
                }else{
                    head = node.next;
                }

                if(node.next != null){
                    node.next.prev = node.prev;
                }else{
                    tail = node.prev;
                }
                node.occ++;
            }

        }else{
            LinkedNode node = new LinkedNode(value);
            if(head == null){
                head = node;
                tail = node;
            }else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            map.put(value, node);

        }

    }
}

public class First_Unique_Number {
    public static void main(String[] args) {

        int[] arr = {3,2,2,1,4};
        FirstUnique fu = new FirstUnique(arr);

        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());

        fu.add(1);
        System.out.println(fu.showFirstUnique());
        fu.add(4);
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());
        fu.add(5);
        System.out.println(fu.showFirstUnique());

    }
}
