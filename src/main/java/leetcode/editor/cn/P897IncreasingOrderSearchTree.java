
package leetcode.editor.cn;
//给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右
//子节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,7]
//输出：[1,null,5,null,7]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的取值范围是 [1, 100] 
// 0 <= Node.val <= 1000 
// 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 273 👎 0


//date: 2022-04-17 14:46:31

import leetcode.editor.definedata.TreeNode;
import leetcode.editor.definedata.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class P897IncreasingOrderSearchTree{
    public static void main(String[] args) {
        Solution solution = new P897IncreasingOrderSearchTree().new Solution();
        // TO TEST
        Integer[] array = {5,3,6,2,4,null,8,1,null,null,null,7,9};
        TreeNode root = TreeNodeUtil.arrayToTreeNode(array);
        solution.increasingBST(root);
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

class SolutionBetter{

    //太抽象了！
    TreeNode prev=null, head=null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        increasingBST(root.left);
        if(prev!=null) {
            root.left=null; // we no  longer needs the left  side of the node, so set it to null
            prev.right=root;
        }
        if(head==null) head=root; // record the most left node as it will be our root
        prev=root; //keep track of the prev node
        increasingBST(root.right);
        return head;
    }

}

class Solution {

    /**
     * 笨办法，将二叉搜索数的顺序记录下来
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {

        List<TreeNode> nodes=new ArrayList<>();
        travel(root,nodes);
        for (int i=0;i<nodes.size();i++){
            TreeNode node=nodes.get(i);
            node.left=null;
            if (i==nodes.size()-1){
                node.right=null;
            }else {
                node.right=nodes.get(i+1);
            }
        }
        return nodes.get(0);
    }

    public void travel(TreeNode node , List<TreeNode> seq){
        if (node!=null){
            travel(node.left,seq);
            seq.add(node);
            travel(node.right,seq);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}