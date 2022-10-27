
package leetcode.editor.cn;
//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 291 👎 0


//date: 2021-10-03 16:05:36

import java.util.*;

public class P166FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new P166FractionToRecurringDecimal().new Solution();
        // TO TEST
        //输入：numerator = 4, denominator = 333
//输出："0.(012)"
       // 解答失败: 测试用例:2 1 测试结果:"2." 期望结果:"2"
        //解答失败: 测试用例:-50 8 测试结果:"0.-2-5" 期望结果:"-6.25" stdout:
        // 解答失败: 测试用例:-1 -2147483648 测试结果:"0.0000000000000000000000000000001" 期望结果:"0.0000000004656612873077392578125" stdout:
     //解答失败: 测试用例:2147483647 37 测试结果:"58(040098.567)" 期望结果:"58040098.(567)"
      //解答失败: 测试用例:-2147483648 -10 测试结果:"0.8" 期望结果:"214748364.8" stdout:
       int numerator=-2147483648;
       int denominator=-10;
        //System.out.println(Integer.MIN_VALUE);
       String res=solution.fractionToDecimal(numerator,denominator);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //思路 需要清晰一点

        public String fractionToDecimal(int numerator, int denominator) {
            long numeratorLong=numerator;
            long denominatorLong=denominator;
            if (numeratorLong%denominatorLong==0) return String.valueOf(numeratorLong/denominatorLong);

            Map<Long,Integer> map=new HashMap<>();
            StringBuilder sb=new StringBuilder();

            if ((numerator>0 && denominator<0)  || (numerator<0 &&denominator>0)){
                sb.append('-');
            }

            numeratorLong=Math.abs(numeratorLong);
            denominatorLong=Math.abs(denominatorLong);
            if (numeratorLong>=denominatorLong){
                long temp=numeratorLong/denominatorLong;
                if (numeratorLong%denominatorLong==0) return temp+"";
                sb.append(temp).append(".");
            }else {
                sb.append("0.");
            }

            long reminder=numeratorLong%denominatorLong;
            int index=0;

            StringBuilder sb2=new StringBuilder();
            while (reminder!=0 && !map.containsKey(reminder)){
                map.put(reminder,index);
                reminder=reminder*10;
                sb2.append(reminder/denominatorLong);
                reminder=reminder%denominatorLong;
                index++;
            }
            if (reminder!=0){
                int insertIndex=map.get(reminder);
                sb2.insert(insertIndex,'(');
                sb2.append(')');
            }
            return sb.append(sb2.toString()).toString();


        }
    public String fractionToDecimalV22(int numerator, int denominator) {

        int[] pos=new int[denominator];

        Arrays.fill(pos,0);
        StringBuilder sb=new StringBuilder();


        if (numerator>=denominator){
            int temp=numerator/denominator;
            numerator=numerator%denominator;
            if (numerator==0) return temp+"";
            sb.append(temp).append(".");
        }else {
            sb.append("0.");
        }

        int i=2;

        while (numerator!=0 ){
            numerator=numerator*10;
            if (numerator<denominator) {
                sb.append("0");
                i++;
                continue;
            }

            int temp=numerator/denominator;
            sb.append(temp);
            numerator=numerator%denominator;

            if ( pos[numerator]==0){
                i++;
                break;
            }
            pos[numerator]=i;
            i++;
            if (numerator==0) return sb.toString();
        }

        //找出循环数字串
        int startPost=pos[numerator];
        System.out.println(i);
       // System.out.println(startPost);
        sb.insert(startPost,'(');
        sb.append(")");

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}