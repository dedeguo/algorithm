
package leetcode.editor.cn;
//最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作： 
//
// 
// Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。 
// Paste（粘贴）：粘贴 上一次 复制的字符。 
// 
//
// 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
//解释：
//最初, 只有一个字符 'A'。
//第 1 步, 使用 Copy All 操作。
//第 2 步, 使用 Paste 操作来获得 'AA'。
//第 3 步, 使用 Paste 操作来获得 'AAA'。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 8
// 1 <= n <= 1000 
// 
// Related Topics 数学 动态规划 
// 👍 389 👎 0


//date: 2021-09-19 20:52:29

public class P650TwoKeysKeyboard{
    public static void main(String[] args) {
        Solution solution = new P650TwoKeysKeyboard().new Solution();
        // TO TEST

        //18  9
        int res=solution.minSteps(3);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int minSteps(int n) {
            int[] dp = new int[n+1];

//            for (int i = 2; i <= n; i++) {
//                dp[i] = i;
//                for (int j = i-1; j > 1; j--) {
//                    if (i % j == 0) {
//                        dp[i] = dp[j] + (i/j);
//                        break;
//                    }
//
//                }
//            }
            for (int i = 2; i <= n; i++) {
                for (int j = i/2; j >= 1; j--) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + (i/j);
                        break;
                    }

                }
            }

            return dp[n];
        }

        public int minStepsV2(int n) {
        int[] dp=new int[n+1];//dp[i]表示i个A所需要的
        dp[1]=0;
        for (int i=2;i<=n;i++){
            //求 dp[i]=dp[j]+ i/j (i能被j整除)
            dp[i]= Integer.MAX_VALUE;
            for (int j=1 ;j*j<=i ;j++){
                if (i%j==0){
                    dp[i]=Math.min(dp[i], dp[j]+i/j);
                    dp[i]=Math.min(dp[i],dp[i/j]+j);

                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}