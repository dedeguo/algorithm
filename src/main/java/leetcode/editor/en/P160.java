package leetcode.editor.en;

import leetcode.editor.definedata.ListNode;

public class P160 {


    //先分别计算两个链表长度
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA= listLen(headA);
        int lenB= listLen(headB);

        if (lenA>=lenB){
            //A 先走lenA-lenB
            int n = lenA-lenB;
            while (n>0){
                headA=headA.next;
                n--;
            }
        }else {
            int n = lenB-lenA;
            while (n>0){
                headB=headB.next;
                n--;
            }
        }

        while (headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

    private int listLen(ListNode head){
        int len=0 ;
        ListNode p =head;
        while (p!=null){
            len++;
            p=p.next;
        }
        return len;
    }

}
