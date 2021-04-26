
package leetcode.editor.cn;
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 447 👎 0


//date: 2021-04-18 12:58:42

import leetcode.editor.definedata.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P199BinaryTreeRightSideView{
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //广度优先
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res=new ArrayList<>();
        if (root==null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(root);

        int count=1;
        while (!stack.isEmpty()){
            TreeNode node= stack.poll();

            if (node.left!=null) {
                stack.offer(node.left);
            }
            if (node.right!=null) {
                stack.offer(node.right);
            }
            count--;
            if (count==0){
                res.add(node.val);
                count=stack.size();
            }
        }


        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}