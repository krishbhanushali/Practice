import java.util.Scanner;

public class AddTwoNumbersLinkedList {
	public static void main(String[] args) {
		System.out.println("Please enter 1st linked lists ");
		Scanner scanner = new Scanner(System.in);
		ListNode head1 = new ListNode(scanner.nextInt());
		ListNode curr1 = head1;
		while(true) {
			int num = scanner.nextInt();
			if (num == -1) {
				break;
			}else {
				curr1.next = new ListNode(num);
				curr1 = curr1.next;
			}
		}
		
		System.out.println("Please enter 2nd linked lists ");
		
		ListNode head2 = new ListNode(scanner.nextInt());
		ListNode curr2 = head2;
		while(true) {
			int num = scanner.nextInt();
			if (num == -1) {
				break;
			}else {
				curr2.next = new ListNode(num);
				curr2 = curr2.next;
			}
		}
		ListNode sumHead = addTwoNumbers(head1, head2);
		while(sumHead!=null) {
			System.out.print(sumHead.val + " -> ");
			sumHead = sumHead.next;
		}
		System.out.print("null");
		scanner.close();
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int sum = l1.val + l2.val;
        int carry = (sum>=10)?1:0;
        sum = (sum>=10)?sum-10:sum;
        ListNode head = new ListNode(sum);
        ListNode curr = head;
        l1 = l1.next; l2 = l2.next;
        sum = 0;
        while(l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                sum = l2.val + carry;
            }
            else if (l2 == null && l1 != null) {
                sum = l1.val + carry;
            }else {
                sum = l1.val + l2.val + carry;
            }
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            }else {
            	carry = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = (l1!=null?l1.next:null);
            l2 = (l2!=null?l2.next:null);
        }
        if(carry == 1) {
            curr.next = new ListNode(1);
        }
        return head;
    }
}

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int val) {
		this.val = val;
	}
}
