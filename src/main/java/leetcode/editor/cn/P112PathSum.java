
package leetcode.editor.cn;
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 
// 👍 570 👎 0


//date: 2021-04-17 14:05:46

import leetcode.editor.definedata.TreeNode;

public class P112PathSum{
    public static void main(String[] args) {
        Solution solution = new P112PathSum().new Solution();
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

    boolean flag=false;

    int  targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root==null) return false;
        this.targetSum=targetSum;
        travel(root,0);

        return flag;
    }

    public void travel(TreeNode p,int currentTatal){
        if (flag==true) return;
        if (p!=null){
            //判断叶子节点
            if (p.left==null && p.right==null){
                if (currentTatal+p.val==targetSum){
                    flag=true;

                }
            }
            travel(p.left,currentTatal+p.val);
            travel(p.right,currentTatal+p.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}