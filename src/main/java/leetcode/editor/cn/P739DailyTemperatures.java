
package leetcode.editor.cn;
//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 715 👎 0


//date: 2021-04-11 22:15:22

public class P739DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {

        int[] warmer=new int[T.length];
        for (int i=0;i<T.length;i++){
            for (int j=i+1;j<T.length;j++){
                if (T[j]>T[i]){
                    warmer[i]=j-i;
                    break;
                }
            }
        }
        return warmer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}