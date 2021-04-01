
package leetcode.editor.cn;
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 1079 👎 0


//date: 2021-03-28 09:49:13

//todo 动态规划
public class P96UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        // TO TEST
        int resN=solution.numTrees(3);
        System.out.println("resN:"+resN);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {

        int[] G=new int[n+1];
        G[0]=G[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                G[i]=G[i]+G[i-j]*G[j-1];
            }
        }
        return G[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}