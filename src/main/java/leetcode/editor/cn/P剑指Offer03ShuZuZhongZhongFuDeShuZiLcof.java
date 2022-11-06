
package leetcode.editor.cn;
//找出数组中重复的数字。 
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
//请找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
//
// Related Topics 数组 哈希表 排序 👍 1000 👎 0


//date: 2022-11-06 15:30:29

import java.util.HashSet;
import java.util.Set;

public class P剑指Offer03ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指Offer03ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        // TO TEST
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.findRepeatNumber(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {

        Set<Integer> set =new HashSet<>();
        for (Integer num:nums){
            if (set.contains(num))
                return num;
            else
                set.add(num);
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}