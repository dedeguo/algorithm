
package leetcode.editor.cn;
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 547 👎 0


//date: 2022-11-01 11:36:04

public class P383RansomNote{
    public static void main(String[] args) {
        Solution solution = new P383RansomNote().new Solution();
        // TO TEST
        String ransomNote="aa";
        String magazine="aab";
        System.out.println(solution.canConstruct(ransomNote,magazine));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] hash=new int[26];
//        for (int i=0;i<magazine.length();i++){
//            char ch=magazine.charAt(i);
//            hash[ch-'a']++;
//        }
        for (char c : magazine.toCharArray()) {
            hash[c - 'a']++;
        }
        for (int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            hash[ch-'a']--;
            if (hash[ch-'a']<0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}