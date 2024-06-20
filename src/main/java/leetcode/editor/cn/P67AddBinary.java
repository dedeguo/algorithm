
package leetcode.editor.cn;
//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 911 👎 0


//date: 2022-11-07 13:46:31

import java.math.BigInteger;

public class P67AddBinary{
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        // TO TEST
        String a="1010";
        String b="1011";
        System.out.println(solution.addBinary(a,b));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {

        BigInteger bigIntegerA=new BigInteger(a,2);
        BigInteger bigIntegerB=new BigInteger(b,2);
        BigInteger result =bigIntegerA.add(bigIntegerB);
        return  result.toString(2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}