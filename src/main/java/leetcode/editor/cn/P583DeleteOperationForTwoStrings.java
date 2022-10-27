
package leetcode.editor.cn;
//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 动态规划 
// 👍 256 👎 0


//date: 2021-09-25 10:22:40

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P583DeleteOperationForTwoStrings{
    public static void main(String[] args) {
        Solution solution = new P583DeleteOperationForTwoStrings().new Solution();
        // TO TEST
        String word1="sea"; String word2="eat";
        int res=solution.minDistance(word1,word2);
        System.out.println(res);
    }
    //最长公共子串
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int commonLen=longestCommonSubsequence(word1,word2);
        return word1.length()+word2.length()-2*commonLen;
    }
        public int longestCommonSubsequence(String text1, String text2) {

            int m=text1.length();
            int n=text2.length();
            int[][] dp=new int[m+1][n+1];
            for (int i=1;i<=m;i++){
                for (int j=1;j<=n;j++){
                    if (text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                        dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }
            return dp[m][n];

        }

}
//leetcode submit region end(Prohibit modification and deletion)

}