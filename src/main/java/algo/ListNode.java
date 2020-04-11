package algo;

/**
 * Created by xufei on 2020/4/8.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = one;

        one.next= new ListNode(2);
        System.out.println(two.next.val);
    }
}
