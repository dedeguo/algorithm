
package leetcode.editor.cn;
//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 801 👎 0


//date: 2021-04-11 19:04:16

import leetcode.editor.definedata.TreeNode;

import java.util.HashMap;

public class P337HouseRobberIii{
    public static void main(String[] args) {
        Solution solution = new P337HouseRobberIii().new Solution();
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

    //超时了
    HashMap<TreeNode,Integer> robMap=new HashMap<>();
    HashMap<TreeNode,Integer> notrobMap=new HashMap<>();

    public int rob(TreeNode root) {

        int max=Math.max(robTravel(root),notRobTravel(root));
        return max;
    }

    //抢劫节点p的
    private int robTravel(TreeNode p){
        if (p==null) return 0;
        Integer pRob=robMap.get(p);
        if (pRob!=null) return pRob;

        int rob=p.val+notRobTravel(p.left)+notRobTravel(p.right);
        robMap.put(p,rob);
        return rob;

    }

    //不抢劫节点p的
    private int notRobTravel(TreeNode p){

        if (p==null) return 0;
        Integer pRob=notrobMap.get(p);
        if (pRob!=null) return pRob;
        int left=Math.max(robTravel(p.left),notRobTravel(p.left));
        int right=Math.max(robTravel(p.right),notRobTravel(p.right));
//        System.out.println("node "+p.val+" notRobTravel:"+left+right);
        notrobMap.put(p,left+right);
        return left+right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}