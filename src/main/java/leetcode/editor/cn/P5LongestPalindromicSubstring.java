
package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5684 👎 0


//date: 2022-09-10 09:12:55

public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        String s="cbbd";
        String res=solution.longestPalindrome(s);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //中心扩展法
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        int start = 0, end = 0;
        for (int i=0;i<s.length();i++){
            int len1=expandFromCenter(i,i,s);
            int len2=expandFromCenter(i,i+1,s);
            int temStart, temEnd;
            if (len1>len2){
               temStart=i-(len1-1)/2;
               temEnd = i+(len1-1)/2;
            }else {
                temStart=i-(len2-2)/2;
                temEnd=i+len2/2;
            }
            if (temEnd-temStart > end-start){
                start=temStart;
                end=temEnd;
            }
        }
        return s.substring(start,end+1);
    }

    int expandFromCenter(int left, int right, String s){
        while (left>=0 && right<s.length()
                && s.charAt(left)==s.charAt(right) ){
            left--;
            right++;
        }
        //边界情况
        return right-left-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}