
package leetcode.editor.cn;
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 913 👎 0


//date: 2021-03-27 10:27:38

import java.util.List;

public class P234PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    /**
     * 快慢指针，翻转一半链表
     */
    class Solution {

    //翻转整个链表  在进行对比
    public boolean isPalindrome(ListNode head) {

        ListNode revesed=reverseLinkList(head);
        ListNode p=head;
        ListNode pReversed=revesed;
        while (p!=null){
            if (p.val!=pReversed.val)
                return false;
            else {
                p=p.next;
                pReversed=pReversed.next;
            }
        }

        return true;
    }
    public ListNode reverseLinkList(ListNode head){

        ListNode headPoint=new ListNode();
        ListNode p=head;
        while(p!=null){
            ListNode newP=new ListNode(p.val);
            ListNode temp=headPoint.next;
            headPoint.next=newP;
            newP.next=temp;
            p=p.next;
        }
        return headPoint.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}