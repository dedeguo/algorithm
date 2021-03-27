package leetcode.editor.cn;

public class CommonStructure {

    /**
     * Definition for singly-linked list.
     */
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

     class TreeNode {
        int val;
        P230KthSmallestElementInABst.TreeNode left;
        P230KthSmallestElementInABst.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, P230KthSmallestElementInABst.TreeNode left, P230KthSmallestElementInABst.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
