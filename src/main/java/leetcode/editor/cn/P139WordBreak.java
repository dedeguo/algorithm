
package leetcode.editor.cn;
//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 912 👎 0


//date: 2021-04-04 17:15:31

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//todo
public class P139WordBreak{
    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
        // TO TEST
//        String s="catsandog";
//        String[] words={"cats","dog","sand","and","cat"};
        /**
         * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
         * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
         */
        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] words={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};

        List<String> wordDict=new ArrayList<>();
        for (String word:words){
            wordDict.add(word);
        }
        wordDict.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println(Arrays.toString(wordDict.toArray()));
       boolean res= solution.wordBreak(s,wordDict);

        System.out.println("res:"+res);
    }

    /**
     * 超时了
     */
    class FailSolution{
        boolean flag=false;

        public boolean wordBreak(String s, List<String> wordDict) {

            travel(s,wordDict);
            return flag;
        }

        public void travel(String s,List<String> wordDict){
            if (flag==true) return;
            for (String word:wordDict){
                System.out.println(word);
                if (s.startsWith(word)){
                    if (s.length()==word.length()){
                        System.out.println("s:"+s+"  word:"+word);
                        flag=true;
                    }else {
                        System.out.println("s:"+s+"  word:"+word);
                        String str=s.substring(word.length());
                        travel(str,wordDict);
                    }

                }
            }
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //用dp
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp=new boolean[s.length()+1];
            dp[0]=true;
            for (int i=0;i<=s.length();i++){
                for (int j=0;j<i;j++){
                    String str=s.substring(j,i);
                    if (dp[j]&& wordDict.contains(str)){
                        dp[i]=true;
                        break;
                    }

                }
            }

          //  System.out.println(Arrays.toString(dp));
            return dp[s.length()];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}