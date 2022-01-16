
package leetcode.editor.cn;
//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 595 👎 0


//date: 2021-09-25 14:48:00

public class P343IntegerBreak{
    public static void main(String[] args) {
        Solution solution = new P343IntegerBreak().new Solution();
        // TO TEST、
        Integer i;
        //todo 这个动态规划有点不好证明其正确性呀
        int res=solution.integerBreak(10);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int integerBreak(int n) {

        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        int k=3;

        while (k<=n){
            for (int i=1;i<=(k-2);i++){
                dp[k]=Math.max(dp[k],Math.max(i*dp[k-i],i*(k-i)));
            }
            k++;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}