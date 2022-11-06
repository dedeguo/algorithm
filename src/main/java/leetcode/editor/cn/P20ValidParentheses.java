
package leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3594 👎 0


//date: 2022-11-06 21:20:15

import java.util.Stack;

public class P20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        String s = "(]";
        System.out.println(solution.isValid(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
       char[]  sChars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
       for (char ch:sChars){
           if (ch==')'){
               if (!stack.isEmpty() && '('==stack.peek() ){
                   stack.pop();
               }else {
                   return false;
               }
           }else if (ch==']'){
               if (!stack.isEmpty() && '['==stack.peek() ){
                   stack.pop();
               }else {
                   return false;
               }
           }else if (ch=='}'){
               if (!stack.isEmpty() && '{'==stack.peek() ){
                   stack.pop();
               }else {
                   return false;
               }
           }else {
               stack.push(ch);
           }
       }
       if (!stack.isEmpty()) return false;
       else return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}