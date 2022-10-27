
package leetcode.editor.cn;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 8150 👎 0


//date: 2022-09-13 10:33:51

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        String s="tmmzuxt";
      //  System.out.println(s.substring(0,0));

        System.out.println(solution.lengthOfLongestSubstringV2(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringV2(String s) {
            if (s.length()==0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            //tmmzuxt
            for(int i = 0; i < s.length(); i ++){
                if(map.containsKey(s.charAt(i))){
                    left = Math.max(left,map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i),i);
                max = Math.max(max,i-left+1);
            }
            return max;

        }

        public int lengthOfLongestSubstring(String s) {
            int begin=0;
            int maxLen=0;
            Map<Character,Integer> map=new HashMap<>();
            for (int end=0;end<s.length();end++){
                if (!map.containsKey(s.charAt(end))  ||
                        (map.containsKey(s.charAt(end))) && map.get(s.charAt(end))<begin){
                    maxLen=Math.max(maxLen,end-begin+1);
                    map.put(s.charAt(end),end);
                } else {
                    begin = map.get(s.charAt(end))+1;
                    map.put(s.charAt(end),end);
                }
            }
            return maxLen;
        }

        //暴力法 --超时
        public int lengthOfLongestSubstringTimeLimit(String s) {
            if (s==null || s.length()==0) return 0;
            int maxLen=1;
            for (int i=0;i<s.length();i++){
                for (int j=i+1;j<=s.length();j++){
                    String subStr=s.substring(i,j);
                    if (!containSameChar(subStr)){
                        maxLen=Math.max(maxLen,subStr.length());
                    }
                }
            }

            return maxLen;
        }

        private boolean containSameChar(String s){
            Set<Character> set =new HashSet<>();
            for (int i=0; i<s.length(); i++){
                if (set.contains(s.charAt(i)))
                    return true;
                else
                    set.add(s.charAt(i));
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}