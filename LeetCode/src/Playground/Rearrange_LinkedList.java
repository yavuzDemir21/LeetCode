package Playground;


import Structures.ListNode;


class MyLinkedList{

    ListNode head;

    public MyLinkedList(ListNode node){
        this.head = node;
    }

    public void reArrangeNodeValues(){
        ListNode node = this.head;
        boolean decr = false;
        while(node.next != null){
            ListNode next = node.next;

            if((!decr && node.val > next.val) || (decr && node.val < next.val)){
                int temp = node.val;
                node.val = next.val;
                next.val = temp;
            }
            node = next;

            decr = !decr;
        }

    }
}


public class Rearrange_LinkedList {
    public static void main(String[] args) {
        ListNode x1 = new ListNode(5);
        ListNode x2 = new ListNode(4);
        ListNode x3 = new ListNode(3);
        ListNode x4 = new ListNode(2);
        ListNode x5 = new ListNode(1);
        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        x4.next = x5;

        reArrange(x1);

        System.out.println(x1.val + " " + x2.val + " " + x3.val + " " + x4.val + " " + x5.val);

    }

    public static void reArrange(ListNode node){

        boolean decr = false;
        while(node.next != null){
            ListNode next = node.next;

            if((!decr && node.val > next.val) || (decr && node.val < next.val)){
                int temp = node.val;
                node.val = next.val;
                next.val = temp;
            }
            node = next;

            decr = !decr;
        }

    }

}
