
package leetcode.editor.cn;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 525 👎 0


//date: 2021-03-25 22:39:10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


class Answer{
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
}
public class P224BasicCalculator{
    public static void main(String[] args) {
        Solution solution = new P224BasicCalculator().new Solution();
        // TO TEST
      String s="1-(2+3-(4+(5-(1-(2+4-(5+6))))))";
      int res=solution.calculate(s);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        s=s.replace(" ","");//去掉空格
        return complexCalculator(s);
    }

    //考虑括号
        public int complexCalculator(String exp){
        if (!exp.contains("("))
            return basicCalculator(exp);
        else {
            //去掉外层括号
            StringBuilder sb=new StringBuilder();
            int bracketCount=0;
            StringBuilder subExp=new StringBuilder();

            for (int i=0;i<exp.length();i++){
//                System.out.println("sb.toString():"+sb.toString());
//                System.out.println("subExp:"+subExp.toString());
                char ch=exp.charAt(i);
                if (ch=='(' ){
                    if (bracketCount>0)
                        subExp.append(ch);
                    bracketCount++;
                }else if (ch==')'){
                    bracketCount--;
                    if (bracketCount>0)
                        subExp.append(ch);
                    else if (bracketCount==0){
                      int subreult=  complexCalculator(subExp.toString());
                      subExp=new StringBuilder();
                      sb.append(subreult);
                    }

                }else {
                    if (bracketCount>0)
                        subExp.append(ch);
                    else {
                        sb.append(ch);
                    }

                }

            }
            return complexCalculator(sb.toString());
        }
        }


    //先做不包括括号的  "-2+ 1"
        public int basicCalculator(String exp){
          //  System.out.println(exp);
            if (exp.startsWith("-") || exp.startsWith("+")){
                exp="0"+exp;
            }
            exp=exp.replace("--","+");
            exp=exp.replace("+-","-");
            String[] numStr=exp.split("[+-]");
            List<String> calsStr=getCalOperators(exp);

            int result=Integer.parseInt(numStr[0]);
        for (int i=1;i<numStr.length;i++){

//            System.out.println("numStr[i]"+numStr[i]);
//            System.out.println("exp:"+exp);
            int num=Integer.parseInt(numStr[i]);
            String calStr=calsStr.get(i-1);
            if (calStr.equals("+")){
                result=result+num;
            }
            else if (calStr.equals("-")){
                result=result-num;
            }
        }
        return result;
        }

        public List<String> getCalOperators(String exp){
            List<String>  operators=new ArrayList<>();
        for (int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if (ch=='-') operators.add("-");
            else if (ch=='+') operators.add("+");
        }
        return operators;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}