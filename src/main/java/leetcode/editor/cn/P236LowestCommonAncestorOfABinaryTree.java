
package leetcode.editor.cn;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 1062 👎 0


//date: 2021-04-12 18:55:52

import com.alibaba.fastjson.JSON;
import leetcode.editor.definedata.ListNode;
import leetcode.editor.definedata.TreeNode;
import leetcode.editor.definedata.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//先求出两个节点的祖先列表
//比较祖先列表  分叉节点就是最近公共祖先
public class P236LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
        // TO TEST
        Integer[] tree= {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNodeUtil.arrayToTreeNode(tree);
        //p = 5, q = 4
        TreeNode p= new TreeNode(5);
        List<TreeNode> ancestors =new ArrayList<>();
        solution.findAncestors(root,p,ancestors);
        for (TreeNode node:ancestors
             ) {
            System.out.println(node.val);
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    /**
     *
     */
    class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }

    public void findAncestors(TreeNode root, TreeNode p, List<TreeNode> ancestors){
        if (root!=null){
            if (p.val != root.val){
                ancestors.add(root);
            }else {
                ancestors.add(root);
                return;
            }
            findAncestors(root.left,p,ancestors);
            findAncestors(root.right,p,ancestors);
            ancestors.remove(root);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}