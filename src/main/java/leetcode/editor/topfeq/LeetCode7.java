package leetcode.editor.topfeq;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeetCode7 {


    public static void main(String[] args) {

       LeetCode7 solution=new LeetCode7();
       int x=1463847412;
       //964632435
       //2147483647
       //1056389759
        //1463847412
     //   System.out.println(Integer.MAX_VALUE);
        System.out.println(solution.reverse(x));
    }



    public int reverseVsloution(int x) {
        StringBuilder result = new StringBuilder();
        String resultSt = "";
        int val = 0;

        if (x > 0) {
            resultSt = result.append(x).reverse().toString();

            try {
                val = (int) Integer.parseInt(resultSt);
            } catch (NumberFormatException e) { return 0; }

            return val;
        }

        else {
            x = -x;
            resultSt = result.append(x).reverse().toString();

            try {
                val = (int) Integer.parseInt(resultSt);
            } catch (NumberFormatException e) { return 0; }

            return -val;
        }
    }

    //重点是判断溢出边界条件

    public int reverse(int x) {

        if(x==0) return 0;
        if(x==Integer.MIN_VALUE) return 0;
        boolean isNagative = x<0;

        x=Math.abs(x);
        int result=0;
        int t;
        while (x>0){
           t=x%10;
           if (result>Integer.MAX_VALUE/10) return 0;
            result=result*10+t;
            x=x/10;
        }
        result=isNagative?result*(-1):result;
        return result;
    }

}
