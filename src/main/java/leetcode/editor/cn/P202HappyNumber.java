
package leetcode.editor.cn;
//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 
// 👍 567 👎 0


//date: 2021-04-01 07:55:28

import java.util.HashSet;
import java.util.Set;

public class P202HappyNumber{
    public static void main(String[] args) {
        Solution solution = new P202HappyNumber().new Solution();
        // TO TEST
        solution.isHappy(2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {

        Set<String> nums=new HashSet<>();
        String num=n+"";
        while (!num.equals("1") && !nums.contains(num)){
            System.out.println("num:"+num);
            nums.add(num);
            int sum=0;
            for (int i=0;i<num.length();i++){
                int e=num.charAt(i)-'0';
                sum=sum+e*e;
            }
            num=sum+"";
        }
        if (num.equals("1")) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 有点像双指针
     */
    class Answer{
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
}
}