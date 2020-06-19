package DailyChallenges;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Middle_Linkedlist {
    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {

        if(head == null || head.next==null){
            return head;
        }
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next == null ? slow : slow.next;
    }


}
