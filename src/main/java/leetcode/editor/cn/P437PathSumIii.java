
package leetcode.editor.cn;
//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 827 👎 0


//date: 2021-04-17 18:03:02

import leetcode.editor.definedata.TreeNode;

public class P437PathSumIii{
    public static void main(String[] args) {
        Solution solution = new P437PathSumIii().new Solution();
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
    public int pathSum(TreeNode root, int targetSum) {

        if (root==null) return 0;

       int r= pathSumTravel(root,targetSum,0);
        return r;
    }

    public int pathSumTravel(TreeNode p, int targetSum,int currentTotal){
        if (p==null) return 0;
        int c=0;
        if (targetSum==currentTotal+p.val)
            c=1;
        int res=c+pathSumTravel(p.left,targetSum,0)+pathSumTravel(p.left,targetSum,currentTotal+p.val)+
                pathSumTravel(p.right,targetSum,0)+pathSumTravel(p.right,targetSum,currentTotal+p.val);

        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}