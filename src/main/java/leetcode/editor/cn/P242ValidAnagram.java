
package leetcode.editor.cn;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 
// 👍 432 👎 0


//date: 2021-09-20 23:10:13

public class P242ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
       String s = "anagram";
       String t = "nagaram";

       //s = "rat", t = "car"

       boolean res=solution.isAnagram("rat","cat");
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 字母个数相同
    public boolean isAnagram(String s, String t) {

        int[] letterNum=new int[26];
        if (s.length()!=t.length()) return false;

        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            letterNum[ch-'a']++;
        }
        for (int j=0;j<t.length();j++){
            char ch=t.charAt(j);
            letterNum[ch-'a']--;
            if (letterNum[ch-'a'] <0 )
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}