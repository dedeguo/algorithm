
package leetcode.editor.cn;
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 字符串 
// 👍 381 👎 0


//date: 2021-09-16 23:28:42

import java.util.HashMap;
import java.util.Map;

public class P290WordPattern{
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        // TO TEST
        // 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
        // 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false

        // 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false

        String pattern= "abba";
        String s="dog cat cat fish";
        boolean res=solution.wordPattern(pattern,s);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {

        Map<Character,String> patternMap=new HashMap<>();

        String[] words=s.split(" ");
        if (words.length!=pattern.length()) return false;
        for (int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String patterWord=patternMap.get(ch);
            if (patterWord==null){
                //判断不能重复
                if (patternMap.values().contains(words[i]))
                    return false;
                patternMap.put(ch,words[i]);
            }else {
                //比较
                String word=words[i];
                if (word.compareTo(patterWord)!=0){
                    return false;
                }
            }
        }
        return true;

    }

        public boolean wordPatternV2(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length())
                return false;
            Map index = new HashMap();
            for (Integer i=0; i<words.length; ++i)
                if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                    return false;
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}