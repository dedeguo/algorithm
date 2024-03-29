
package leetcode.editor.cn;
//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 376 👎 0


//date: 2021-03-25 22:21:52

import java.util.Arrays;
import java.util.HashSet;

public class P217ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new P217ContainsDuplicate().new Solution();
        // TO TEST
        int[] nums={1,1,1,3,3,4,3,2,4,2};
        System.out.println(solution.containsDuplicate(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //排序
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            if (nums.length==1) return false;
            for (int i=1;i<nums.length;i++){
                if (nums[i-1]==nums[i]) return true;
            }
            return false;
        }
        public boolean containsDuplicateHash(int[] nums) {
            HashSet<Integer> data = new HashSet<>();
            for (int num : nums) {
                if (!data.contains(num))
                    data.add(num);
                else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}