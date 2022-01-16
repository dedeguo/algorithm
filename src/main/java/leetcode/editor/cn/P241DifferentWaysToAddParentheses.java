
package leetcode.editor.cn;
//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。 
//
// 示例 1: 
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// 示例 2: 
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 
// 👍 434 👎 0


//date: 2021-09-21 13:39:11

import java.util.List;

public class P241DifferentWaysToAddParentheses{
    public static void main(String[] args) {
        Solution solution = new P241DifferentWaysToAddParentheses().new Solution();
        // TO TEST
        //intValue
        Integer i=1;
        i.intValue();
        Long l;
        Float f;
        Double d;
        Byte byte1;
        Short s;
        Long.valueOf(10l);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}