
package leetcode.editor.cn;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1199 👎 0


//date: 2021-06-16 07:42:57

import java.util.HashMap;
import java.util.Map;

public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
        String s="ab";
        String t="a";
        long start=System.currentTimeMillis();

       String output= solution.minWindow22(s,t);
        long end=System.currentTimeMillis();
        long cost=end-start;
        System.out.println(" cost "+cost+"ms");
        System.out.println(output);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {

        return "";

    }
    //暴力法 所有子串
        public String minWindow22(String s,String t){
        int minLen=s.length()+1;
        String minStr="";
        for (int i=0;i<s.length();i++){
//           char chStart= s.charAt(i);
//           if (!t.contains(chStart+""))
//               continue;
            for (int j=i+1;j<=s.length();j++){
                String subStr=s.substring(i,j);
                //检查是否包含所有
                if (isContain(subStr,t)){
                    System.out.println("substr:"+subStr+"   t:"+t);
                   // minLen=Math.min(subStr.length(),minLen);
                    if (subStr.length()<minLen){
                        minLen=subStr.length();
                        System.out.println("substr:"+subStr.length()+"   minLen:"+minLen);

                        minStr=subStr;
                    }
                }
            }
        }
        return minStr;
        }

        public boolean isContain(String subStr,String t){
            HashMap<Character,Integer> tfreq=new HashMap<>();
            for (int i=0;i<subStr.length();i++){
              char ch=  subStr.charAt(i);
            Integer  num=  tfreq.getOrDefault(ch,0);
            tfreq.put(ch,num+1);
            }

            for (int i=0;i<t.length();i++){
                char ch=t.charAt(i);
                Integer  num=  tfreq.getOrDefault(ch,0);
                if (num<1) return false;
                tfreq.put(ch,num-1);

            }

        return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution222 {

        public String minWindow(String s, String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            // Dictionary which keeps a count of all the unique characters in t.
            Map<Character, Integer> dictT = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
                int count = dictT.getOrDefault(t.charAt(i), 0);
                dictT.put(t.charAt(i), count + 1);
            }

            // Number of unique characters in t, which need to be present in the desired window.
            int required = dictT.size();

            // Left and Right pointer
            int l = 0, r = 0;

            // formed is used to keep track of how many unique characters in t
            // are present in the current window in its desired frequency.
            // e.g. if t is "AABC" then the window must have two A's, one B and one C.
            // Thus formed would be = 3 when all these conditions are met.
            int formed = 0;

            // Dictionary which keeps a count of all the unique characters in the current window.
            Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

            // ans list of the form (window length, left, right)
            int[] ans = {-1, 0, 0};

            while (r < s.length()) {
                // Add one character from the right to the window
                char c = s.charAt(r);
                int count = windowCounts.getOrDefault(c, 0);
                windowCounts.put(c, count + 1);

                // If the frequency of the current character added equals to the
                // desired count in t then increment the formed count by 1.
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    formed++;
                }

                // Try and contract the window till the point where it ceases to be 'desirable'.
                while (l <= r && formed == required) {
                    c = s.charAt(l);
                    // Save the smallest window until now.
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    // The character at the position pointed by the
                    // `Left` pointer is no longer a part of the window.
                    windowCounts.put(c, windowCounts.get(c) - 1);
                    if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                        formed--;
                    }

                    // Move the left pointer ahead, this would help to look for a new window.
                    l++;
                }

                // Keep expanding the window once we are done contracting.
                r++;
            }

            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        }
    }
}

