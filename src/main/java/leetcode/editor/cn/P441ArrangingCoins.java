
package leetcode.editor.cn;
//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 155 👎 0


//date: 2021-10-10 13:56:13

public class P441ArrangingCoins{
    public static void main(String[] args) {
        Solution solution = new P441ArrangingCoins().new Solution();
        // TO TEST
        int res=solution.arrangeCoins(1804289383);
        System.out.println(res);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int arrangeCoins222(int n) {
            long left = 0, right = n;
            long k, curr;
            while (left <= right) {
                k = left + (right - left) / 2;
                curr = k * (k + 1) / 2;

                if (curr == n) return (int)k;

                if (n < curr) {
                    right = k - 1;
                } else {
                    left = k + 1;
                }
            }
            return (int)right;
        }


    public int arrangeCoins(int n) {

        int low=0;
        int high=n;
        int mid=(low+high)/2;
        while (high>=low ){
            long temp=countTotal(mid);
            if (temp==n) return mid;
            else if (temp<n) {
                low=mid+1;
            }else if (temp>n){
                high=mid-1;
            }
            mid=(low+high)/2;;
        }
//        System.out.println("low"+low);
//        System.out.println("hgh"+high);
//        System.out.println("mid"+mid);
        return high;
    }

    long countTotal(int n){
        return (long)n*(n+1)/2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}