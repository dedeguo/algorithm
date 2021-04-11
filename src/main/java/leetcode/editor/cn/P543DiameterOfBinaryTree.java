
package leetcode.editor.cn;
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 673 👎 0


//date: 2021-04-11 16:26:56

import leetcode.editor.definedata.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P543DiameterOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
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


    Map<TreeNode,Integer> map=new HashMap<>();

    int max=Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {

        travel(root);
      //  System.out.println();
        return max;
    }

    public void travel(TreeNode p){

        if (p!=null){
            //计算 diameter
            int diameter=calHeightV2(p.left)+calHeightV2(p.right);
            max=Math.max(diameter,max);
            travel(p.left);
            travel(p.right);
        }
    }

    public int calHeightV2(TreeNode p){
        if (p==null) return 0;

        return Math.max(calHeightV2(p.right),calHeightV2(p.left))+1;

    }


    public int calHeight(TreeNode p){
        if (p==null) return 0;
        Integer pHeight=map.get(p);
        if (pHeight!=null) return pHeight;
        int height=Math.max(calHeight(p.left),calHeight(p.right))+1;
        map.put(p,height);
        System.out.println("p va;:"+p.val+ "  p.height: "+height);
        return height;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}