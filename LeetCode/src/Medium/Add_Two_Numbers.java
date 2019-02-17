package Medium;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}


public class Add_Two_Numbers {
	public static void main(String[] args) {

		ListNode num1 = new ListNode(2);
		num1.next = new ListNode(4);
		num1.next.next = new ListNode(3);

		ListNode num2 = new ListNode(5);
		num2.next = new ListNode(6);
		num2.next.next = new ListNode(4);

		ListNode res = addTwoNumbers(num1, num2);

		while(res != null){
			System.out.print(res.val);
			res = res.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode res = new ListNode(0);
		ListNode root = res;

		boolean overflow = false;

		while(true){

			int num1 = 0, num2 = 0;

			if(l1 != null){
				num1 = l1.val;
				l1 = l1.next;
			}

			if(l2 != null){
				num2 = l2.val;
				l2 = l2.next;
			}


			if(overflow){
				res.val = (num1 + num2 + 1)%10;
				if((num1 + num2 + 1) > 9){
					overflow = true;
				}else{
					overflow = false;
				}
				
			}else{
				res.val = (num1 + num2)%10;
				if((num1 + num2) > 9){
					overflow = true;
				}else{
					overflow = false;
				}
				
			}


			if(l1 == null && l2 == null){
				if(overflow){
					res.next = new ListNode(1);
				}
				return root;
			}

			res.next = new ListNode(0);

			res = res.next;

		}

	}



}
