package algo;


/**
 * 链表
 */
public class LinkedList {

    /**
     * 2020-4-8
     * 单链表--就地反转法
     * dummy->1->2->3->4->5的就地反转过程：
     * <p>
     * dummy->2->1->3->4->5
     * dummy->3->2->1->4->5
     * dummy->4>-3->2->1->5
     * dummy->5->4->3->2->1
     * <p>
     * 总结：三个指针：
     * 一个头结点：dummp
     * 一个pre（已经反转的之后的第一个结点）
     * 一个curr(当前需要反转的结点)
     * 就是把curr插入到头结点的后面
     *
     * @param head
     * @return
     */
    public  ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummp = new ListNode(-1);
        dummp.next = head;

        ListNode pre = head;
        while (pre.next != null) {
            ListNode curr = pre.next;
            pre.next = curr.next;
            curr.next = dummp.next;
            dummp.next = curr;
        }
        return dummp.next;
    }

    /**
     * 思路就是创建一个头结点，循环一遍单链表，插入在头结点的后面
     *
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode dummp = new ListNode(-1);
        dummp.next = head;
        if (head == null) {
            return dummp.next;
        }

        //遍历list
        ListNode curr = head.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummp.next;
            dummp.next = curr;
            curr = next; //下一个结点
        }

        return dummp.next;
    }


    /**
     * 2020-4-8
     * 单链表--递归，还没看懂含义
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }


    /**
     * 2020-4-8
     * 给定一个链表，判断链表中是否有环。
     * 不能用内容代表下表
     * <p>
     * 快慢指针的想法,太巧
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;

        while (true) {
            if (slow.next == null) {
                return false;
            }

            if (quick.next == null || quick.next.next == null) {
                return false;
            }

            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                return true;
            }

        }

    }


    /**
     * 约瑟夫问题（有时也称为约瑟夫斯置换），是一个出现在计算机科学和数学中的问题。在计算机编程的算法中，类似问题又称为约瑟夫环。
     * 人们站在一个等待被处决的圈子里。 计数从圆圈中的指定点开始，并沿指定方向围绕圆圈进行。 在跳过指定数量的人之后，执行下一个人。
     * 对剩下的人重复该过程，从下一个人开始，朝同一方向跳过相同数量的人，直到只剩下一个人，并被释放。
     * 问题即，给定人数、起点、方向和要跳过的数字，选择初始圆圈中的位置以避免被处决。
     *
     * @return
     */
    public static int yuesefu(int position, int num) {
        //1.构造环形链表
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        head.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = head;

        //2.找到指定位置
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val == position) {
                //圆圈的终止位置
                while (true) {
                    for (int i = 0; i <= num; i++) {
                        if (i == num) {
                            if (tmp.next == tmp) {
                                return tmp.val;
                            }
                            tmp.next = tmp.next.next;
                            i = -1;
                        } else {
                            tmp = tmp.next;
                        }


                    }
                }

            }
            tmp = tmp.next;
        }

        return head.val;

    }

    /**
     * 两个有序列表的合并
     *
     * @param one
     * @param other
     */
    public static ListNode mergeList(ListNode one, ListNode other) {

        if (one == null && other != null) {
            return other;
        }

        if (one != null && other == null) {
            return one;
        }

        if (one == null && other == null) {
            return null;
        }

       //两条链表合并到第三条链表上
        ListNode newHead = new ListNode(-1);
        //维护一个移动中的标识位
        ListNode curr=newHead;
        while (true){
            //比较的终止条件是什么？


            //比较两个链表头部节点的大小
            if (one.val< other.val){
                curr.next = one;
                one =one.next;
                if (one == null){
                    curr.next = other;
                    break;
                }
            }else {
                curr.next = other;
                other=other.next;
                if (other == null){
                    //other这个链表已经比较完了
                    curr.next=one;
                    break;
                }
            }
            curr = curr.next;


        }
        return newHead.next;

    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode second = new ListNode(2);
//        ListNode third = new ListNode(3);
//        ListNode four = new ListNode(4);
//        head.next = second;
//        second.next = third;
//        third.next = third;


//        ListNode result = LinkedList.reverseList2(head);
//        System.out.println(result.val);
//        System.out.println(result.next.val);
//        System.out.println(result.next.next.val);
//        System.out.println(result.next.next.next.val);

//        boolean hasCycle = LinkedList.hasCycle(head);
//        System.out.println(hasCycle);

//        int believe = LinkedList.yuesefu(1, 2);
//        System.out.println(believe);

        ListNode one = new ListNode(1);
        ListNode one1 = new ListNode(3);
        ListNode one2 = new ListNode(5);
        ListNode one3 = new ListNode(6);
        ListNode one4 = new ListNode(18);
        ListNode one5 = new ListNode(108);
        one.next = one1;
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        one4.next = one5;
        one5.next = null;


        ListNode other = new ListNode(2);
        ListNode other1 = new ListNode(6);
        ListNode other2 = new ListNode(9);
        ListNode other3 = new ListNode(16);
        ListNode other4 = new ListNode(58);
        ListNode other5 = new ListNode(59);
        other.next = other1;
        other1.next = other2;
        other2.next = other3;
        other3.next = other4;
        other4.next = other5;
        other5.next = null;

        ListNode reslut = LinkedList.mergeList(one, other);
        while (reslut != null) {
            System.out.println(reslut.val);
            reslut = reslut.next;
        }


    }

}
